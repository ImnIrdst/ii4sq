package com.imn.ii4sq.data.remote.interceptors

import com.imn.ii4sq.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class QueryParamsInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url
            .newBuilder()
            .addQueryParameter(
                "client_id",
                BuildConfig.FOURSQUARE_CLIENT_ID
            )
            .addQueryParameter(
                "client_secret",
                BuildConfig.FOURSQUARE_CLIENT_SECRET
            )
            .addQueryParameter(
                "v",
                "20210515"
            )
            .build()
        return chain.proceed(
            request.newBuilder()
                .url(url)
                .build()
        )
    }
}
