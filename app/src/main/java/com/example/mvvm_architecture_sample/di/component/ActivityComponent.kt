package com.example.mvvm_architecture_sample.di.component

import com.example.mvvm_architecture_sample.di.ActivityScope
import com.example.mvvm_architecture_sample.di.module.ActivityModule
import com.example.mvvm_architecture_sample.ui.topheadline.TopHeadlineActivity
import dagger.Component

@ActivityScope
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: TopHeadlineActivity)
}