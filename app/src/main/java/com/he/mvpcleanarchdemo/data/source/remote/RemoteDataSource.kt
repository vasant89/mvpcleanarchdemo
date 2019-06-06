package com.he.mvpcleanarchdemo.data.source.remote

import com.he.mvpcleanarchdemo.connection.RetrofitServiceFactory
import com.he.mvpcleanarchdemo.data.source.DataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource
@Inject
constructor(
    private val retrofitServiceFactory: RetrofitServiceFactory
) : DataSource {


    companion object {
        private val TAG = RemoteDataSource::class.java.simpleName
    }
}
