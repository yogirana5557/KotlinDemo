package com.android.kotlin.dagger

import com.android.kotlin.MainApp
import com.android.kotlin.activity.MainActivity
import com.android.kotlin.activity.RepositoryDetailActivity
import com.android.kotlin.service.GitHubService
import dagger.Component
import javax.inject.Singleton

/**
 * Created by yogi.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(mainApp: MainApp)

    fun inject(mainActivity: MainActivity)

    fun inject(repositoryDetailActivity: RepositoryDetailActivity)

    fun inject(gitHubService: GitHubService)

}