package com.kiwilss.xview.design.collapsing

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.appbar.AppBarLayout
import com.kiwilss.xview.R
import com.kiwilss.xview.design.appbar.AppBarStateChangeListener
import kotlinx.android.synthetic.main.activity_collasping_center.*
import kotlinx.android.synthetic.main.activity_collasping_tab.*

/**
 *@FileName: CollaspingCenterActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/22
 * @desc   : {DESCRIPTION}
 */
class CollaspingCenterActivity: AppCompatActivity(R.layout.activity_collasping_center) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        ctl_collapsing_center_collapsing.run {
            collapsedTitleGravity = Gravity.CENTER_HORIZONTAL
            setExpandedTitleColor(ContextCompat.getColor(this@CollaspingCenterActivity,R.color.blue_74D3FF))
            setCollapsedTitleTextColor(ContextCompat.getColor(this@CollaspingCenterActivity,R.color.transparent))
        }


        //监听折叠和展开
        appbar_collasping_center_appbar.addOnOffsetChangedListener(object : AppBarStateChangeListener(){
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?, i: Int) {
                if (state == State.EXPANDED){
                    rl_collapsing_center_tittle.visibility = View.GONE
                    tb_collaspingone_tb.setNavigationIcon(R.mipmap.ic_navigation_back_white)
                }else if (state == State.COLLAPSED){
                    rl_collapsing_center_tittle.visibility = View.VISIBLE
                    tb_collaspingone_tb.navigationIcon = null
                }
            }

        })

    }
}