package com.kiwilss.xview.ui.view.edittext.emoji

import android.view.View
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.keyboard.KeyboardUtils
import kotlinx.android.synthetic.main.activity_emoji_two.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/11
 *  desc   :
 */
class EmojiEditTwoActivity: BaseActivity(R.layout.activity_emoji_two) {
    override fun initData() {

    }

    override fun initEvent() {
        btnEmoji.setOnClickListener {
            silEmojiTwoOuter.showEmojiLayout()
        }
        btnFens.setOnClickListener {
            KeyboardUtils.showSoftInput()
        }
        KeyboardUtils.registerSoftInputChangedListener(this,object : KeyboardUtils.OnSoftInputChangedListener{
            override fun onSoftInputChanged(height: Int) {
                when {
                    silEmojiTwoOuter.isEmojiLayoutShow -> {
                        llExpress.visibility = View.VISIBLE
                    }
                    silEmojiTwoOuter.isSoftInputShow -> {
                        llExpress.visibility = View.VISIBLE
                    }
                    else -> {
                        llExpress.visibility = View.GONE
                    }
                }
            }

        })
    }

    override fun initInterface() {
    }

    override fun onBackPressed() {
        if (!silEmojiTwoOuter.handleBack()) {
            super.onBackPressed()
        }
    }
}