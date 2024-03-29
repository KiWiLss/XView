/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: DesignActivity
 * Author:   Administrator
 * Date:     2020/8/12 9:27
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.xview.design

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.design.behavioractivity.*
import com.kiwilss.xview.design.collapsing.CollapsingOneActivity
import com.kiwilss.xview.design.collapsing.CollaspingCenterActivity
import com.kiwilss.xview.design.collapsing.CollaspingTwoActivity
import com.kiwilss.xview.design.drawer.DrawerBottomActivity
import com.kiwilss.xview.design.drawer.DrawerTranspateActivity
import com.kiwilss.xview.design.drawer.NormalDrawerActivity
import com.kiwilss.xview.design.imitate.JianSuActivity
import com.kiwilss.xview.design.imitate.MeiTuanHomeActivity
import com.kiwilss.xview.design.imitate.PictureActivity
import com.kiwilss.xview.design.imitate.XiTuActivity
import com.kiwilss.xview.design.refresh.Refresh2Activity
import com.kiwilss.xview.design.refresh.RefreshActivity
import com.kiwilss.xview.design.toolbar.*
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_design.*

/**
 *@FileName: DesignActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/12
 * @desc   : {DESCRIPTION}
 */
class DesignActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_design)

        btn_design_toolbar.setOnClickListener {
            startActivity(Intent(this,ToolbarActivity::class.java))
        }
        btn_design_toolbars.setOnClickListener {
            startActivity(Intent(this,ToolbarScrollActivity::class.java))
        }
        btn_design_zt1.setOnClickListener {
            startActivity(Intent(this,CollapsingOneActivity::class.java))
        }
        btn_design_refresh.setOnClickListener {
            startActivity(Intent(this,RefreshActivity::class.java))
        }
        btn_design_refresh2.setOnClickListener {
            startActivity(Intent(this, Refresh2Activity::class.java))
        }
        btn_design_topscale.setOnClickListener {
            startActivity(Intent(this, TopScaleActivity::class.java))
        }
        btn_design_topscale2.setOnClickListener {
            startActivity(Intent(this, TopBackActivity::class.java))
        }
        btn_design_topscale3.setOnClickListener {
            startActivity(Intent(this, TopBackRefreshActivity::class.java))
        }
        btn_design_collasping.setOnClickListener {
            startActivity(Intent(this, CollaspingTwoActivity::class.java))
        }
        btn_design_js.setOnClickListener {
            startActivity(Intent(this, JianSuActivity::class.java))
        }
        btn_design_mt.setOnClickListener {
            startActivity(Intent(this, MeiTuanHomeActivity::class.java))
        }
        btn_design_picture.setOnClickListener {
            startActivity(Intent(this, PictureActivity::class.java))
        }
        btn_design_tab1.setOnClickListener {
            startActivity(Intent(this, ToolbarTabVpActivity::class.java))
        }
        btn_design_tab2.setOnClickListener {
            startActivity(Intent(this, CollaspingTabActivity::class.java))
        }

        btn_design_xitu.setOnClickListener {
            startActivity(Intent(this, XiTuActivity::class.java))
        }
        btn_design_center.setOnClickListener {
            startActivity(Intent(this, CollaspingCenterActivity::class.java))
        }
        btn_design_header.setOnClickListener {
            startActivity(Intent(this, HeaderScrollActivity::class.java))
        }
        btn_design_header2.setOnClickListener {
            startActivity(Intent(this, Header2Activity::class.java))
        }
        btn_design_drawer.setOnClickListener {
            startActivity(Intent(this, NormalDrawerActivity::class.java))
        }
        btn_design_drawer2.setOnClickListener {
            startActivity(Intent(this, DrawerBottomActivity::class.java))
        }
        btn_design_drawer3.setOnClickListener {
            startActivity(Intent(this, DrawerTranspateActivity::class.java))
        }

        btn_design_drawer3.post {
            LogUtils.e("height=${btn_design_drawer3.height}")
        }
        btn_design_zoom.setOnClickListener {
            startActivity(Intent(this, HeaderZoomActivity::class.java))
        }
        btn_design_search.setOnClickListener {
            startActivity(Intent(this, SearchTabActivity::class.java))
        }
    }
}