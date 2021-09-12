package com.imn.ii4sq.ui.details

import com.google.common.truth.Truth
import com.imn.ii4sq.data.repository.details.VenueDetailsRepository
import com.imn.ii4sq.domain.entities.VenueDetails
import com.imn.ii4sq.domain.entities.asIIError
import com.imn.ii4sq.domain.entities.failureState
import com.imn.ii4sq.domain.entities.loadingState
import com.imn.ii4sq.domain.entities.successState
import com.imn.ii4sq.utils.DebugUtils
import com.imn.ii4sq.utils.IITest
import com.imn.ii4sq.utils.awaitValue
import com.imn.ii4sq.utils.testUnknownHostException
import com.imn.ii4sq.utils.testVenueDetails
import io.mockk.coEvery
import io.mockk.coVerifySequence
import io.mockk.confirmVerified
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkObject
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
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
        venueDetailsViewModel.venueDetails.awaitValue(2) {

            venueDetailsViewModel.loadVenueDetails(testVenueDetails.id)
        }.let {
            Truth.assertThat(it[0]).isEqualTo(loadingState<VenueDetails>())
            Truth.assertThat(it[1]).isEqualTo(successState(testVenueDetails))
        }

        coVerifySequence {
            venueDetailsRepository.getVenueDetails(testVenueDetails.id)
        }
    }

    @Test
    fun `loading venue details throws exception`() = td.runBlockingTest {
        coEvery { venueDetailsRepository.getVenueDetails(testVenueDetails.id) } throws
                testUnknownHostException

        venueDetailsViewModel.venueDetails.awaitValue(2) {

            venueDetailsViewModel.loadVenueDetails(testVenueDetails.id)
        }.let {
            Truth.assertThat(it[0]).isEqualTo(loadingState<VenueDetails>())
            Truth.assertThat(it[1])
                .isEqualTo(failureState<VenueDetails>(testUnknownHostException.asIIError()))
        }

        coVerifySequence {
            venueDetailsRepository.getVenueDetails(testVenueDetails.id)
        }
    }
}
