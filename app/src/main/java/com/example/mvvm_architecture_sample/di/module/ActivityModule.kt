package com.example.mvvm_architecture_sample.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm_architecture_sample.data.repository.TopHeadlineRepository
import com.example.mvvm_architecture_sample.di.ActivityContext
import com.example.mvvm_architecture_sample.ui.base.ViewModelProviderFactory
import com.example.mvvm_architecture_sample.ui.topheadline.TopHeadlineAdapter
import com.example.mvvm_architecture_sample.ui.topheadline.TopHeadlineViewModel
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @ActivityContext
    @Provides
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideTopHeadlineViewModel(
        topHeadlineRepository: TopHeadlineRepository
    ): TopHeadlineViewModel {
        return ViewModelProvider(activity,
            ViewModelProviderFactory(TopHeadlineViewModel::class) {
                TopHeadlineViewModel(topHeadlineRepository)
            })[TopHeadlineViewModel::class.java]
    }

    @Provides
    fun provideTopHeadlineAdapter() = TopHeadlineAdapter(ArrayList())
}