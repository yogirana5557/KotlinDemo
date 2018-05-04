package com.android.kotlin.activity

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.android.kotlin.MainApp
import com.android.kotlin.R
import com.android.kotlin.adapter.RepositoryAdapter
import com.android.kotlin.extension.*
import com.android.kotlin.service.GitHubService
import com.jakewharton.rxbinding.widget.RxTextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*
import timber.log.Timber
import java.util.concurrent.TimeUnit
import javax.inject.Inject

/**
 * Created by yogi.
 */
class MainActivity : BaseActivity() {
    @Inject
    lateinit var gitHubService: GitHubService

    private lateinit var repositoryAdapter: RepositoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        MainApp.graph.inject(this)

        setSupportActionBar(toolbar)
        setUpRecyclerView()
        setUpSearchView()
    }

    private fun setUpRecyclerView() {
        repositoryAdapter = RepositoryAdapter(this)
        mainResultsRecycler.adapter = repositoryAdapter
        mainResultsRecycler.layoutManager = LinearLayoutManager(this)
    }

    private fun setUpSearchView() {
        val searchEditText = mainSearchCardView.getEditText()
        searchEditText.setText("kotlin")
        searchEditText.setSelection(searchEditText.text.length)
        searchEditText.setHint(R.string.search_repositories)
        RxTextView.textChanges(searchEditText)
                .doOnNext { mainResultsSpinner.show() }
                .sample(1, TimeUnit.SECONDS)
                .switchMap { gitHubService.searchRepositories(it.toString()).subscribeOnIo() }
                .subscribeUntilDestroy(this) {
                    onNext {
                        mainResultsSpinner.hide()
                        repositoryAdapter.loadRepositories(it)
                    }
                    onError {
                        Timber.e(it, "Failed to load repositories")
                        mainResultsSpinner.hide()
                        alert {
                            setTitle(R.string.error)
                            setMessage(R.string.search_repositories_error)
                            setPositiveButton(android.R.string.ok, null)
                        }
                    }
                }
    }

}