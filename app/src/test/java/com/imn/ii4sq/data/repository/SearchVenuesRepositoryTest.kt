package com.imn.ii4sq.data.repository

import com.imn.ii4sq.utils.*
import io.mockk.*
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class SearchVenuesRepositoryTest: IITest() {

    private lateinit var searchVenuesRemoteDataSource: SearchVenuesRemoteDataSource
    private lateinit var searchVenuesRepository: SearchVenuesRepository

    @Before
    override fun setUp() {
        super.setUp()

        searchVenuesRemoteDataSource = mockk {
            coEvery { search(testLat, testLon, testRadius) } returns testSearchedVenues
        }

        searchVenuesRepository = SearchVenuesRepository(searchVenuesRemoteDataSource)
    }

    @After
    override fun tearDown() {
        confirmVerified(searchVenuesRemoteDataSource)
        super.tearDown()
    }

    @Test
    fun `search returns results from remote data source`() = td.runBlockingTest {

        val result = searchVenuesRepository.search(testLat, testLon, testRadius)

        assertThat(result).isEqualTo(testSearchedVenues)

        coVerifySequence {
            searchVenuesRemoteDataSource.search(testLat, testLon, testRadius)
        }
    }
}