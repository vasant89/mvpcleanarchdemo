package com.he.mvpcleanarchdemo

interface BaseView<T : BasePresenter> {

    fun setPresenter(presenter: T)
}