package com.kiwilss.xview.ui.aac

import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.ui.aac.viewbinding.ViewBindingActivity
import com.kiwilss.xview.utils.ktx.IntentKtx.startActivity2
import kotlinx.android.synthetic.main.activity_aac.*

/**
 * author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/13
 *  desc   :
 */
class AACTestActivity : BaseActivity(R.layout.activity_aac) {
    override fun initData() {

    }

    override fun initEvent() {
        btnAACViewBinding.setOnClickListener {
            startActivity2<ViewBindingActivity>()
        }
    }

    override fun initInterface() {
    }
}