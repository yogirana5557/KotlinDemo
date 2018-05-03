package com.android.kotlin.activity

import android.view.MenuItem
import com.trello.rxlifecycle.components.support.RxAppCompatActivity

/**
 * Created by yogi.
 */
abstract class BaseActivity : RxAppCompatActivity() {

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}