package com.he.mvpcleanarchdemo.data.source

import com.he.mvpcleanarchdemo.di.scope.Local
import com.he.mvpcleanarchdemo.di.scope.Remote
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository
@Inject
constructor(
    @Local private val localDataSource: DataSource,
    @Remote private val remoteDataSource: DataSource
) : DataSource {

    companion object {
        private val TAG = Repository::class.java.simpleName
    }
}