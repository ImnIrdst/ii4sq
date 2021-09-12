package com.imn.ii4sq.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

fun <T> LiveData<T>.awaitValue(count: Int, block: () -> Unit): List<T> {
    val data = mutableListOf<T>()
    val latch = CountDownLatch(count)

    val observer = Observer<T> { o ->
        data.add(o)
        latch.countDown()
    }

    observeForever(observer)

    block.invoke()

    latch.await(TEST_AWAIT_TIMEOUT, TimeUnit.SECONDS)
    removeObserver(observer)

    return data
}
