package com.bacnguyen.basenetwork.di

import io.reactivex.disposables.Disposable

object Dispose {

    private val listDisposable = ArrayList<Disposable>()

    fun addDisposable(disposable: Disposable) {
        listDisposable.add(disposable)
    }

    fun disposeAll() {
        listDisposable.forEach { it.dispose() }
    }
}