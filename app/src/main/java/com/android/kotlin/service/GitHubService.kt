package com.android.kotlin.service

import rx.Observable
import com.android.kotlin.MainApp
import com.android.kotlin.model.Repository
import javax.inject.Inject

/**
 * Created by yogi.
 */
open class GitHubService {

    @Inject
    lateinit var gitHubApiService: GitHubApiService

    constructor() {
        MainApp.graph.inject(this)
    }

    open fun searchRepositories(query: String): Observable<List<Repository>> {
        if (query.isBlank()) {
            return Observable.just(ArrayList())
        } else {
            return gitHubApiService.searchRepositories(query).map { it.items }
        }
    }

    fun getRepository(owner: String, repository: String) = gitHubApiService.getRepository(owner, repository)

    fun getRepositoryReadme(owner: String, repository: String) = gitHubApiService.getRepositoryReadme(owner, repository)
}