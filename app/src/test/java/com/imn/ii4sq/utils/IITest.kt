package com.imn.ii4sq.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import io.mockk.unmockkAll
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.Ignore
import org.junit.Rule

@OptIn(ExperimentalCoroutinesApi::class)
@Ignore("This is base class")
open class IITest {

    protected val td = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(td)

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    open fun setUp() {
        Dispatchers.setMain(td)
    }

    open fun tearDown() {
        testScope.uncaughtExceptions.firstOrNull()?.let { throw it }
        unmockkAll()
        Dispatchers.resetMain()
        td.cleanupTestCoroutines()
        testScope.cleanupTestCoroutines()
    }
}
