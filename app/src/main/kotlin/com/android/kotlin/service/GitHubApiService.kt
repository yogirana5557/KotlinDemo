package com.android.kotlin.service

import com.android.kotlin.model.Repository
import com.android.kotlin.model.RepositoryReadme
import com.android.kotlin.model.RepositorySearchResults
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import rx.Observable


/**
 * Created by yogi.
 */
interface GitHubApiService {

    @GET("search/repositories")
    fun searchRepositories(@Query("q") query: String): Observable<RepositorySearchResults>

    @GET("/repos/{owner}/{repo}")
    fun getRepository(@Path("owner") owner: String, @Path("repo") repository: String): Observable<Repository>

    @GET("/repos/{owner}/{repo}/readme")
    fun getRepositoryReadme(@Path("owner") owner: String, @Path("repo") repository: String): Observable<RepositoryReadme>

}