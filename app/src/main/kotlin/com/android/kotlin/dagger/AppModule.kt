package com.android.kotlin.dagger

import com.android.kotlin.BuildConfig
import com.android.kotlin.MainApp
import com.android.kotlin.service.GitHubApiService
import com.android.kotlin.service.GitHubService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by yogi.
 */
@Module
class AppModule(private val mainApp: MainApp) {

    @Provides
    @Singleton
    fun provideMainApp() = mainApp

    @Provides
    @Singleton
    fun provideGitHubApiService(): GitHubApiService {
        val interceptor = HttpLoggingInterceptor();
        interceptor.setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE);
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build();

        return Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
                .create(GitHubApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGitHubService() = GitHubService()

}