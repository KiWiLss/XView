package com.kiwilss.xview.ui.view.edittext.emoji

import android.view.View
import android.widget.Toast
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.lqr.emoji.EmotionKeyboard
import com.lqr.emoji.IEmotionExtClickListener
import com.lqr.emoji.IEmotionSelectedListener
import kotlinx.android.synthetic.main.activity_emoji_edittext.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/11
 *  desc   :
 */
class EmojiEdittextActiity: BaseActivity(R.layout.activity_emoji_edittext) {
    lateinit var mEmotionKeyboard: EmotionKeyboard

    override fun initData() {
    }

    override fun initEvent() {
    }

    override fun initInterface() {

        initEmotionKeyboard()

        elEmotion.attachEditText(etKey)
        elEmotion.setEmotionAddVisiable(true)
        elEmotion.setEmotionSettingVisiable(true)
        elEmotion.setEmotionExtClickListener(object : IEmotionExtClickListener {
            override fun onEmotionAddClick(view: View) {
                Toast.makeText(applicationContext, "add", Toast.LENGTH_SHORT).show()
            }

            override fun onEmotionSettingClick(view: View) {
                Toast.makeText(applicationContext, "setting", Toast.LENGTH_SHORT).show()
            }
        })

        elEmotion.setEmotionSelectedListener(object : IEmotionSelectedListener {
            override fun onEmojiSelected(key: String) {}
            override fun onStickerSelected(
                categoryName: String,
                stickerName: String,
                stickerBitmapPath: String
            ) {
                Toast.makeText(applicationContext, stickerBitmapPath, Toast.LENGTH_SHORT).show()
            }
        })

    }

    private fun initEmotionKeyboard() {
        mEmotionKeyboard = EmotionKeyboard.with(this)
        mEmotionKeyboard.bindToContent(llContent)
        mEmotionKeyboard.bindToEmotionButton(tvExpression)
        mEmotionKeyboard.bindToEditText(etKey)
        mEmotionKeyboard.setEmotionLayout(elEmotion)
    }
}