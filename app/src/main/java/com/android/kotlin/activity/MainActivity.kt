package com.android.kotlin.activity

import android.os.Bundle
import com.android.kotlin.R
import kotlinx.android.synthetic.main.toolbar.*

/**
 * Created by yogi.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        setUpRecyclerView()
        setUpSearchView()
    }

    private fun setUpRecyclerView() {

    }

    private fun setUpSearchView() {

    }

}