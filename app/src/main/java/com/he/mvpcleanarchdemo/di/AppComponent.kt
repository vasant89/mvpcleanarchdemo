package com.he.mvpcleanarchdemo.di

import android.app.Application
import com.he.mvpcleanarchdemo.data.source.Repository
import com.he.mvpcleanarchdemo.di.module.ActivityBindingModule
import com.he.mvpcleanarchdemo.di.module.ApplicationModule
import com.he.mvpcleanarchdemo.di.module.DataModule
import com.he.mvpcleanarchdemo.di.picassomodules.NetworkModule
import com.he.mvpcleanarchdemo.di.picassomodules.PicassoModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        (ApplicationModule::class),
        (AndroidSupportInjectionModule::class),
        (ActivityBindingModule::class),
        (PicassoModule::class),
        (NetworkModule::class),
        (DataModule::class)
    ]
)
interface AppComponent : AndroidInjector<App> {

    fun getRepository(): Repository

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

}