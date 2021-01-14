package com.kiwilss.xview.ui.aac.viewbinding

import android.os.Bundle
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.base.BaseActivity2
import com.kiwilss.xview.databinding.ActivityViewbindingBinding
import com.kiwilss.xview.databinding.ActivityViewbindingBinding.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/14
 *  desc   :
 */
class VBTestActivity : BaseActivity2<ActivityViewbindingBinding>() {
    override fun initBinding(): ActivityViewbindingBinding {
        return ActivityViewbindingBinding.inflate(layoutInflater)
    }

    override fun initData() {

    }


    override fun initEvent() {
    }

    override fun initInterface(savedInstanceState: Bundle?) {
        mVB.textAccount.text = "baseactivity test"

        //初始化fragment
        val vbFg = VBFg()
        supportFragmentManager.beginTransaction()
            .add(R.id.flViewBindingTest,vbFg)
            .commit()

    }

}