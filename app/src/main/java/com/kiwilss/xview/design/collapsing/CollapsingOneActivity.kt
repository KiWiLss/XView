/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: CollapsingOneActivity
 * Author:   kiwilss
 * Date:     2020/8/13 22:50
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.collapsing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.StatusBarUtils
import kotlinx.android.synthetic.main.activity_collasping_one.*

/**
 *@FileName: CollapsingOneActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/13
 * @desc   : {DESCRIPTION}
 */
class CollapsingOneActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collasping_one)

        //设置沉浸式状态栏,可以设置状态栏颜色
        StatusBarUtils.initStatusBarStyle(this,true)
        /*
        layout_collapseMode: 用来指当前控件在 CollapsingToolbarLayout 在折叠过程中的折叠模式,
                                            其中 Toolbar 指定成 pin, 表示在折叠过程中位置始终保持不变,
                                            ImageView 指定成 parallax,表示在折叠过程中会有一定的错位偏移
         */

        fab_collaspingone_fab.setOnClickListener {
            Snackbar.make(fab_collaspingone_fab,"hello",Snackbar.LENGTH_SHORT)
                .show()
        }
        tb_collaspingone_tb.setNavigationOnClickListener {
            finish()
        }
    }
}