package com.imn.ii4sq.data.local.details

import com.google.common.truth.Truth.assertThat
import com.imn.ii4sq.data.repository.details.VenueDetailsLocalDataSource
import com.imn.ii4sq.utils.IITest
import com.imn.ii4sq.utils.testVenueDetails
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class VenueDetailsMemoryCacheDaoTest : IITest() {

    private lateinit var venueDetailsLocalDataSource: VenueDetailsLocalDataSource

    @Before
    override fun setUp() {
        super.setUp()

        venueDetailsLocalDataSource = VenueDetailsMemoryCacheDao(td)
    }

    @After
    override fun tearDown() = super.setUp()


    @Test
    fun `is caching works`() = td.runBlockingTest {
        val beforeCachingResult = venueDetailsLocalDataSource.getVenueDetails(testVenueDetails.id)

        assertThat(beforeCachingResult).isNull()

        venueDetailsLocalDataSource.insert(testVenueDetails)

        val afterCachingResult = venueDetailsLocalDataSource.getVenueDetails(testVenueDetails.id)

        assertThat(afterCachingResult).isEqualTo(testVenueDetails)

        val randomQueryResult = venueDetailsLocalDataSource.getVenueDetails("random-venue")

        assertThat(randomQueryResult).isNull()
    }
}