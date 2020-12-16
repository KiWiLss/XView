package com.kiwilss.xview.ui.captcha

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.captcha.puzzle.PuzzleActivity
import com.kiwilss.xview.ui.captcha.swipe.SwipePuzzleActivity
import com.kiwilss.xview.utils.ktx.IntentKtx.startActivity2
import kotlinx.android.synthetic.main.activity_captcha.*

/**
 *@FileName: CaptchaActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/16
 * @desc   : {DESCRIPTION}
 */
class CaptchaActivity : BaseActivity(R.layout.activity_captcha){
    override fun initData() {

    }

    override fun initEvent() {
        btn_captcha_puzzle.setOnClickListener {
            startActivity2<PuzzleActivity>()
        }
        btn_captcha_puzzle2.setOnClickListener {
            startActivity2<SwipePuzzleActivity>()
        }
    }

    override fun initInterface() {
    }

}