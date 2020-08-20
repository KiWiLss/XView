/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: XiTuActivity
 * Author:   Administrator
 * Date:     2020/8/20 10:12
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.imitate

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_xitu.*


/**
 *@FileName: XiTuActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/20
 * @desc   : {DESCRIPTION}
 */
class XiTuActivity: AppCompatActivity(R.layout.activity_xitu) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_xitu)

        setSupportActionBar(tb_xitu_toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        tb_xitu_toolbar.setNavigationOnClickListener {
            finish()
        }

        //对标题处理
        appbar_xitu_appbar.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->
            LogUtils.e(verticalOffset)
            if (verticalOffset <= -head_layout.height / 2) {
                ctl_xitu_collapsing.title = "涩郎"
            } else {
                ctl_xitu_collapsing.title = " "
            }
        })

    }
}