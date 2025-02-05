package com.example.mvvm_architecture_sample

import android.app.Application
import com.example.mvvm_architecture_sample.di.component.ApplicationComponent
import com.example.mvvm_architecture_sample.di.component.DaggerApplicationComponent
import com.example.mvvm_architecture_sample.di.module.ApplicationModule

class MVVMApplication : Application() {

    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injectDependencies()
    }

    private fun injectDependencies() {
        applicationComponent = DaggerApplicationComponent
            .builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }
}