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
import com.kiwilss.xview.design.behavioractivity.TopBackActivity
import com.kiwilss.xview.design.behavioractivity.TopBackRefreshActivity
import com.kiwilss.xview.design.behavioractivity.TopScaleActivity
import com.kiwilss.xview.design.collapsing.CollapsingOneActivity
import com.kiwilss.xview.design.collapsing.CollaspingTwoActivity
import com.kiwilss.xview.design.imitate.JianSuActivity
import com.kiwilss.xview.design.imitate.PictureActivity
import com.kiwilss.xview.design.refresh.Refresh2Activity
import com.kiwilss.xview.design.refresh.RefreshActivity
import com.kiwilss.xview.design.toolbar.ToolbarActivity
import com.kiwilss.xview.design.toolbar.ToolbarScrollActivity
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

        }
        btn_design_picture.setOnClickListener {
            startActivity(Intent(this, PictureActivity::class.java))
        }
    }
}