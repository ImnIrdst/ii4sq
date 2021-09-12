package com.imn.ii4sq.di

import com.imn.ii4sq.data.local.details.VenueDetailsMemoryCacheDao
import com.imn.ii4sq.data.local.location.FusedLocationLiveData
import com.imn.ii4sq.data.local.search.SearchVenuesMemoryCacheDao
import com.imn.ii4sq.data.remote.details.VenueDetailsApi
import com.imn.ii4sq.data.remote.interceptors.QueryParamsInterceptor
import com.imn.ii4sq.data.remote.search.SearchVenueApi
import com.imn.ii4sq.data.repository.details.VenueDetailsLocalDataSource
import com.imn.ii4sq.data.repository.details.VenueDetailsRemoteDataSource
import com.imn.ii4sq.data.repository.details.VenueDetailsRepository
import com.imn.ii4sq.data.repository.location.LocationRepository
import com.imn.ii4sq.data.repository.search.SearchVenuesLocalDataSource
import com.imn.ii4sq.data.repository.search.SearchVenuesRemoteDataSource
import com.imn.ii4sq.data.repository.search.SearchVenuesRepository
import com.imn.ii4sq.ui.details.VenueDetailsViewModel
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
    single { SearchVenuesRepository(get(), get()) }
    single { LocationRepository(FusedLocationLiveData(get())) }
    viewModel { MapViewModel(get(), get()) }

    single<VenueDetailsLocalDataSource> { VenueDetailsMemoryCacheDao() }
    single<VenueDetailsRemoteDataSource> { get<Retrofit>().create(VenueDetailsApi::class.java) }
    single { VenueDetailsRepository(get(), get()) }
    viewModel { VenueDetailsViewModel(get()) }
}
