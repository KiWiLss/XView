package com.kiwilss.xview.ui.captcha.puzzle

import android.graphics.BitmapFactory
import android.widget.Toast
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_puzzle.*

/**
 *@FileName: PuzzleActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/16
 * @desc   : {DESCRIPTION}
 */
class PuzzleActivity: BaseActivity(R.layout.activity_puzzle) {
    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface() {

        slide_puzzle.setBitmap(BitmapFactory.decodeResource(resources,R.drawable.ic_slide_puzzle_test))
        slide_puzzle.setOnVerifyListener {
            Toast.makeText(this,if(it) "验证成功" else "验证失败", Toast.LENGTH_SHORT).show()
        }


    }
}