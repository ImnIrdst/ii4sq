package com.imn.ii4sq.data.repository

import com.imn.ii4sq.utils.*
import io.mockk.*
import com.google.common.truth.Truth.assertThat
import com.imn.ii4sq.data.local.search.SearchVenuesMemoryCacheDao
import com.imn.ii4sq.data.repository.search.SearchVenuesLocalDataSource
import com.imn.ii4sq.data.repository.search.SearchVenuesRemoteDataSource
import com.imn.ii4sq.data.repository.search.SearchVenuesRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchVenuesRepositoryTest : IITest() {

    private lateinit var searchVenuesRemoteDataSource: SearchVenuesRemoteDataSource
    private lateinit var searchVenuesLocalDataSource: SearchVenuesLocalDataSource
    private lateinit var searchVenuesRepository: SearchVenuesRepository

    @Before
    override fun setUp() {
        super.setUp()

        searchVenuesRemoteDataSource = mockk {
            coEvery { search("$testLat,$testLon", testRadius) } returns testSearchResponse
        }

        searchVenuesLocalDataSource = spyk(SearchVenuesMemoryCacheDao(td))

        searchVenuesRepository = SearchVenuesRepository(
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
    fun `search returns results from remote data source and caches it`() = td.runBlockingTest {

        val notCacheResults = searchVenuesRepository.search(testLocation, testRadius)

        assertThat(notCacheResults).isEqualTo(testSearchedVenues)

        val cachedResults = searchVenuesRepository.search(testLocation, testRadius)

        assertThat(cachedResults).isEqualTo(testSearchedVenues)

        coVerifySequence {
            // before caching
            searchVenuesLocalDataSource.search(testLocation, testRadius)

            searchVenuesRemoteDataSource.search("$testLat,$testLon", testRadius)
            searchVenuesLocalDataSource.insert(testLocation, testRadius, testSearchedVenues)

            // after caching
            searchVenuesLocalDataSource.search(testLocation, testRadius)
        }
    }
}