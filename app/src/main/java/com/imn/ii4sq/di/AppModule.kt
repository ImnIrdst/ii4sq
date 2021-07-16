package com.imn.ii4sq.di

import com.google.gson.Gson
import com.imn.ii4sq.data.local.search.SearchVenuesMemoryCacheDao
import com.imn.ii4sq.data.remote.interceptors.QueryParamsInterceptor
import com.imn.ii4sq.data.remote.search.SearchVenueApi
import com.imn.ii4sq.data.repository.search.SearchVenuesLocalDataSource
import com.imn.ii4sq.data.repository.search.SearchVenuesRemoteDataSource
import com.imn.ii4sq.ui.map.MapViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://api.foursquare.com/")
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = HttpLoggingInterceptor.Level.BODY
                        }
                    )
                    .addInterceptor(QueryParamsInterceptor())
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<SearchVenuesLocalDataSource> { SearchVenuesMemoryCacheDao() }
    single<SearchVenuesRemoteDataSource> { get<Retrofit>().create(SearchVenueApi::class.java) }
    viewModel { MapViewModel(get(), get()) }
}