package com.renanparis.desafio_android_renan_oliveira.data.api

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.renanparis.desafio_android_renan_oliveira.BuildConfig
import com.renanparis.desafio_android_renan_oliveira.extensions.md5
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

object RetrofitBuilder {

    private const val URL = "http://gateway.marvel.com/v1/public/"

    private fun getClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor{chain ->
            val original = chain.request()
            val originalHttpUrl = original.url()

            val ts = (Calendar.getInstance(TimeZone.getTimeZone("UTC")).timeInMillis / 1000L).toString()

            val url = originalHttpUrl.newBuilder()
                .addQueryParameter("apikey", BuildConfig.Apikey)
                .addQueryParameter("ts", ts)
                .addQueryParameter("hash", "$ts${BuildConfig.PrivateKey}${BuildConfig.Apikey}".md5())
                .build()

            chain.proceed(original.newBuilder().url(url).build())
        }
        return httpClient.build()

    }

    private fun getRetrofit(): Retrofit {
        val gson = GsonBuilder().setLenient().create()
        return Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(getClient())
            .build()
    }

    val service: MarvelService = getRetrofit().create(MarvelService::class.java)
}