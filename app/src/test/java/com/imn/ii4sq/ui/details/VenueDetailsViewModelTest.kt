package com.imn.ii4sq.ui.details

import com.google.common.truth.Truth
import com.imn.ii4sq.data.repository.details.VenueDetailsRepository
import com.imn.ii4sq.domain.entities.*
import com.imn.ii4sq.utils.*
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class VenueDetailsViewModelTest : IITest() {

    private lateinit var venueDetailsRepository: VenueDetailsRepository
    private lateinit var venueDetailsViewModel: VenueDetailsViewModel

    @Before
    override fun setUp() {
        super.setUp()

        mockkObject(DebugUtils)
        every { DebugUtils.isDebug } returns false

        venueDetailsRepository = mockk {
            coEvery { getVenueDetails(testVenueDetails.id) } returns testVenueDetails
        }


        venueDetailsViewModel = VenueDetailsViewModel(venueDetailsRepository)
    }

    @After
    override fun tearDown() {
        confirmVerified(venueDetailsRepository)
        super.tearDown()
    }

    @Test
    fun `loading venue details successfully`() = td.runBlockingTest {
        val expected = testSearchedVenues.sortedBy {
            it.location.toLocationEntity().distanceToTest(testLocation)
        }
        venueDetailsViewModel.venueDetails.awaitValue(2) {

            venueDetailsViewModel.loadVenueDetails(testVenueDetails.id)

        }.let {
            Truth.assertThat(it[0]).isEqualTo(loadingState<VenueDetails>())
            Truth.assertThat(it[1]).isEqualTo(successState(expected))
        }

        coVerifySequence {
            venueDetailsRepository.getVenueDetails(testVenueDetails.id)
        }
    }
}