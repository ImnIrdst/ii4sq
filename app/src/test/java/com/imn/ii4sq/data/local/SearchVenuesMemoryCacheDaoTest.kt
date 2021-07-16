package com.imn.ii4sq.data.local

import com.google.common.truth.Truth.assertThat
import com.imn.ii4sq.data.local.search.SearchVenuesMemoryCacheDao
import com.imn.ii4sq.data.repository.search.SearchVenuesLocalDataSource
import com.imn.ii4sq.domain.entities.LocationEntity
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
        val beforeCachingResult = searchVenuesLocalDataSource.search(testLocation, testRadius)

        assertThat(beforeCachingResult).isNull()

        searchVenuesLocalDataSource.insert(testLocation, testRadius, testSearchedVenues)

        val afterCachingResult = searchVenuesLocalDataSource.search(testLocation, testRadius)

        assertThat(afterCachingResult).isEqualTo(testSearchedVenues)

        val randomQueryResult = searchVenuesLocalDataSource.search(LocationEntity(1.0, 2.0), 3.0)

        assertThat(randomQueryResult).isNull()
    }
}