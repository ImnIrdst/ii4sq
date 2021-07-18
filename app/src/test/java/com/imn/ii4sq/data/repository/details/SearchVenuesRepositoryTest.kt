package com.imn.ii4sq.data.repository.details

import com.google.common.truth.Truth.assertThat
import com.imn.ii4sq.data.local.details.VenueDetailsMemoryCacheDao
import com.imn.ii4sq.utils.*
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class VenueDetailsRepositoryTest : IITest() {

    private lateinit var searchVenuesRemoteDataSource: VenueDetailsRemoteDataSource
    private lateinit var searchVenuesLocalDataSource: VenueDetailsLocalDataSource
    private lateinit var searchVenuesRepository: VenueDetailsRepository

    @Before
    override fun setUp() {
        super.setUp()

        searchVenuesRemoteDataSource = mockk {
            coEvery { getVenueDetails(testVenueDetails.id) } returns testVenueDetailsResponse
        }

        searchVenuesLocalDataSource = spyk(VenueDetailsMemoryCacheDao(td))

        searchVenuesRepository = VenueDetailsRepository(
            searchVenuesRemoteDataSource,
            searchVenuesLocalDataSource,
            td
        )
    }

    @After
    override fun tearDown() {
        confirmVerified(searchVenuesRemoteDataSource, searchVenuesLocalDataSource)
        super.tearDown()
    }

    @Test
    fun `getVenueDetails returns results from remote data source and caches it`() = td.runBlockingTest {

        val notCacheResults = searchVenuesRepository.getVenueDetails(testVenueDetails.id)

        assertThat(notCacheResults).isEqualTo(testVenueDetails)

        val cachedResults = searchVenuesRepository.getVenueDetails(testVenueDetails.id)

        assertThat(cachedResults).isEqualTo(testVenueDetails)

        coVerifySequence {
            // before caching
            searchVenuesLocalDataSource.getVenueDetails(testVenueDetails.id)

            searchVenuesRemoteDataSource.getVenueDetails(testVenueDetails.id)
            searchVenuesLocalDataSource.insert(testVenueDetails)

            // after caching
            searchVenuesLocalDataSource.getVenueDetails(testVenueDetails.id)
        }
    }
}