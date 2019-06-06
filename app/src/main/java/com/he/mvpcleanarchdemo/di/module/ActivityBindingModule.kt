package com.he.mvpcleanarchdemo.di.module

import com.he.mvpcleanarchdemo.di.scope.ActivityScoped
import com.he.mvpcleanarchdemo.main.MainActivity
import com.he.mvpcleanarchdemo.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBindingModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [MainModule::class])
    internal abstract fun mainActivity(): MainActivity
}
