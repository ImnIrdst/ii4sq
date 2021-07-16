package com.imn.ii4sq.ui.map

import com.google.common.truth.Truth.assertThat
import com.imn.ii4sq.data.repository.search.SearchVenuesRepository
import com.imn.ii4sq.domain.entities.Venue
import com.imn.ii4sq.domain.entities.loadingState
import com.imn.ii4sq.domain.entities.successState
import com.imn.ii4sq.utils.*
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest

import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MapViewModelTest : IITest() {

    private lateinit var searchVenuesRepository: SearchVenuesRepository
    private lateinit var mapViewModel: MapViewModel

    @Before
    override fun setUp() {
        super.setUp()

        mockkObject(DebugUtils)
        every { DebugUtils.isDebug } returns false

        searchVenuesRepository = mockk {
            coEvery { search(testLat, testLon, testRadius) } returns testSearchedVenues
        }

        mapViewModel = MapViewModel(searchVenuesRepository)
    }

    @After
    override fun tearDown() {
        confirmVerified(searchVenuesRepository)
        super.tearDown()
    }


    @Test
    fun `loading search results`() = td.runBlockingTest {
        mapViewModel.venuesList.awaitValue(2) {

            mapViewModel.search(testLat, testLon, testRadius)

        }.let {
            assertThat(it[0]).isEqualTo(loadingState<List<Venue>>())
            assertThat(it[1]).isEqualTo(successState(testSearchedVenues))
        }

        coVerifySequence {
            searchVenuesRepository.search(testLat, testLon, testRadius)
        }
    }
}