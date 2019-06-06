package com.he.mvpcleanarchdemo.connection

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import android.util.Log
import com.he.mvpcleanarchdemo.connection.webservices.GIPHYService
import com.he.mvpcleanarchdemo.extentions.isInternetAvailable
import com.he.mvpcleanarchdemo.extentions.showMessage
import javax.inject.Singleton

@Singleton
class RetrofitServiceFactory
@Inject
constructor(private val context: Context) {

    private val TAG = RetrofitServiceFactory::class.java.simpleName

    private var client: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .addInterceptor { chain ->

            if (!context.isInternetAvailable()) {
                Log.e(TAG, "No Internet!")
                context.showMessage("No Internet!")
            }

            val original: Request = chain.request()

            val request: Request = original.newBuilder()
                .header("x-api-key", "abcd1234")
                .method(original.method(), original.body())
                .build()

            chain.proceed(request)

        }.connectTimeout(100, TimeUnit.SECONDS)
        .readTimeout(100, TimeUnit.SECONDS)
        .build()


    private var retrofit: Retrofit = Retrofit.Builder()
        .client(client)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://api.androidhive.info/")
        .build()

    fun createGIPHYService(): GIPHYService {
        return retrofit.create(GIPHYService::class.java)
    }

}