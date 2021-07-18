package com.imn.ii4sq.ui.map

import com.google.common.truth.Truth.assertThat
import com.imn.ii4sq.data.repository.location.LocationRepository
import com.imn.ii4sq.data.repository.search.SearchVenuesRepository
import com.imn.ii4sq.domain.entities.*
import com.imn.ii4sq.utils.*
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest

import org.junit.After
import org.junit.Before
import org.junit.Test
import java.net.UnknownHostException

@OptIn(ExperimentalCoroutinesApi::class)
class MapViewModelTest : IITest() {

    private lateinit var searchVenuesRepository: SearchVenuesRepository
    private lateinit var locationRepository: LocationRepository
    private lateinit var mapViewModel: MapViewModel

    @Before
    override fun setUp() {
        super.setUp()

        mockkObject(DebugUtils)
        every { DebugUtils.isDebug } returns false

        mockkStatic("com.imn.ii4sq.utils.MapUtilsKt")
        every { any<LocationEntity>().distanceTo(any()) } answers {
            val loc1 = firstArg<LocationEntity>()
            val loc2 = secondArg<LocationEntity>()

            loc1.distanceToTest(loc2)
        }

        searchVenuesRepository = mockk {
            coEvery { search(testLocation, testRadius) } returns testSearchedVenues
            coEvery { search(testLocationAfterPan, testRadius) } returns testSearchedVenuesAfterPan
        }

        locationRepository = mockk()

        mapViewModel = MapViewModel(searchVenuesRepository, locationRepository)
    }

    @After
    override fun tearDown() {
        confirmVerified(searchVenuesRepository)
        super.tearDown()
    }


    @Test
    fun `loading search results`() = td.runBlockingTest {
        val expected = testSearchedVenues.sortedBy {
            it.location.toLocationEntity().distanceToTest(testLocation)
        }
        mapViewModel.venuesList.awaitValue(2) {

            mapViewModel.search(testLocation, testRadius)

        }.let {
            assertThat(it[0]).isEqualTo(loadingState<List<Venue>>())
            assertThat(it[1]).isEqualTo(successState(expected))
        }

        coVerifySequence {
            searchVenuesRepository.search(testLocation, testRadius)
        }
    }

    @Test
    fun `loading search results after panning`() = td.runBlockingTest {
        val expectedBeforePan = testSearchedVenues.sortedBy {
            it.location.toLocationEntity().distanceToTest(testLocation)
        }

        val expectedAfterPan = testSearchedVenuesAfterPan.toMutableList()
            .apply { addAll(expectedBeforePan) }
            .sortedBy {
                it.location.toLocationEntity().distanceToTest(testLocationAfterPan)
            }



        mapViewModel.venuesList.awaitValue(3) {

            mapViewModel.search(testLocation, testRadius)
            mapViewModel.search(testLocationAfterPan, testRadius)

        }.let {
            assertThat(it[0]).isEqualTo(loadingState<List<Venue>>())
            assertThat(it[1]).isEqualTo(successState(expectedBeforePan))
            assertThat(it[2]).isEqualTo(loadingState<List<Venue>>())
            assertThat(it[3]).isEqualTo(successState(expectedAfterPan))
            assertThat(it[3]).isEqualTo(successState(expectedAfterPan))
            assertThat((it[3] as State.Success).value.first() == testVenue)
        }

        coVerifySequence {
            searchVenuesRepository.search(testLocation, testRadius)
            searchVenuesRepository.search(testLocationAfterPan, testRadius)
        }
    }

    @Test
    fun `loading search results throws exception`() = td.runBlockingTest {
        coEvery { searchVenuesRepository.search(testLocation, testRadius) } throws
                testUnknownHostException

        mapViewModel.venuesList.awaitValue(2) {

            mapViewModel.search(testLocation, testRadius)

        }.let {
            assertThat(it[0]).isEqualTo(loadingState<List<Venue>>())
            assertThat(it[1]).isEqualTo(failureState<List<Venue>>(testUnknownHostException.asIIError()))
        }

        coVerifySequence {
            searchVenuesRepository.search(testLocation, testRadius)
        }
    }
}