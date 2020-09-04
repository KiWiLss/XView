package com.kiwilss.xview.ui.view.viewpager.vp

import androidx.fragment.app.Fragment
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import kotlinx.android.synthetic.main.activity_vp_test.*

/**
 *@FileName: VpTestActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/4
 * @desc   : {DESCRIPTION}
 */
class VpTestActivity : BaseActivity(R.layout.activity_vp_test) {
    override fun initData() {

    }

    override fun initEvent() {

    }

    override fun initInterface() {

        val dataList = arrayListOf<Fragment>()
        for (i in 0..5){
            dataList.add(VpTestFg.newInstance(i))
        }
        val adapter = VpTestAdapter(supportFragmentManager,dataList)
        vp_vp_test_vp.adapter = adapter


    }

    override fun onReload() {
    }
}