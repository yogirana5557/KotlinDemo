package com.android.kotlin.dagger

import com.android.kotlin.service.GitHubApiService
import com.android.kotlin.service.GitHubService
import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import javax.inject.Singleton

@Module
class TestAppModule {

    @Provides
    @Singleton
    fun provideGitHubService() = mock(GitHubService::class.java)

    @Provides
    @Singleton
    fun provideGitHubApiService() = mock(GitHubApiService::class.java)
}
