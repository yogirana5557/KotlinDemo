package com.android.kotlin.view

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import android.widget.FrameLayout
import com.android.kotlin.R
import kotlinx.android.synthetic.main.search_card.view.*
import com.android.kotlin.extension.inflateLayout

/**
 * Created by yogi.
 */
class SearchCardView : FrameLayout {

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context) : super(context) {
        init(context)
    }

    fun init(context: Context) {
        context.inflateLayout(R.layout.search_card, this, true)
        searchCardClear.setOnClickListener { searchCardEditText.text = null }
    }

    fun getEditText(): EditText = searchCardEditText
}