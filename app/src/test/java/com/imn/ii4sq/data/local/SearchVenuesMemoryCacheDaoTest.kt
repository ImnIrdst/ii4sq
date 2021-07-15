package com.imn.ii4sq.data.local

import com.google.common.truth.Truth.assertThat
import com.imn.ii4sq.data.repository.SearchVenuesLocalDataSource
import com.imn.ii4sq.utils.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest

import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchVenuesMemoryCacheDaoTest : IITest() {

    private lateinit var searchVenuesLocalDataSource: SearchVenuesLocalDataSource

    @Before
    override fun setUp() {
        super.setUp()

        searchVenuesLocalDataSource = SearchVenuesMemoryCacheDao(td)
    }

    @After
    override fun tearDown() = super.setUp()


    @Test
    fun `is caching works`() = td.runBlockingTest {
        val beforeCachingResult = searchVenuesLocalDataSource.search(testLat, testLon, testRadius)

        assertThat(beforeCachingResult).isNull()

        searchVenuesLocalDataSource.insert(testLat, testLon, testRadius, testSearchedVenues)

        val afterCachingResult = searchVenuesLocalDataSource.search(testLat, testLon, testRadius)

        assertThat(afterCachingResult).isEqualTo(testSearchedVenues)

        val randomQueryResult = searchVenuesLocalDataSource.search(1.0, 2.0, 3.0)

        assertThat(randomQueryResult).isNull()
    }
}