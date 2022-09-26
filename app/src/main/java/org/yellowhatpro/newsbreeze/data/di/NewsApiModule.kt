package org.yellowhatpro.newsbreeze.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.yellowhatpro.newsbreeze.data.api.NewsApi
import org.yellowhatpro.newsbreeze.util.Constants.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NewsApiModule {

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi {
        val okHttpClient = OkHttpClient.Builder()
            .build()
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(NewsApi::class.java)
    }
}