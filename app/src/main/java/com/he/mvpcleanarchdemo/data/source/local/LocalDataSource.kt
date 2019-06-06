package com.he.mvpcleanarchdemo.data.source.local

import com.he.mvpcleanarchdemo.connection.RetrofitServiceFactory
import com.he.mvpcleanarchdemo.data.source.DataSource

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LocalDataSource
constructor(
    private val retrofitServiceFactory: RetrofitServiceFactory
) : DataSource {


    companion object {
        private val TAG = LocalDataSource::class.java.simpleName
    }
}
