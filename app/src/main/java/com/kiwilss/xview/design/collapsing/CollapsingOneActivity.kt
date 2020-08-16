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

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.internal.CollapsingTextHelper
import com.google.android.material.snackbar.Snackbar
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.StatusBarUtils
import kotlinx.android.synthetic.main.activity_collasping_one.*
import java.lang.reflect.Field


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
        //setSupportActionBar(tb_collaspingone_tb)
        //折叠标题设置
        ctl_collaspone_collapsing.title = "测试标题"
        ctl_collaspone_collapsing.collapsedTitleGravity = Gravity.START
        ctl_collaspone_collapsing.expandedTitleGravity = Gravity.BOTTOM
        ctl_collaspone_collapsing.setCollapsedTitleTextColor(ContextCompat.getColor(this,R.color.red))
        ctl_collaspone_collapsing.setExpandedTitleColor(ContextCompat.getColor(this,R.color.blue_74D3FF))


//        val field: Field =
//            ctl_collaspone_collapsing.javaClass.getDeclaredField("collapsingTextHelper")
//
//        ctl_collaspone_collapsing.addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
//            @SuppressLint("RestrictedApi")
//            override fun onLayoutChange(
//                v: View?,
//                left: Int,
//                top: Int,
//                right: Int,
//                bottom: Int,
//                oldLeft: Int,
//                oldTop: Int,
//                oldRight: Int,
//                oldBottom: Int
//            ) {
//                if (oldBottom == bottom) {
//                    ctl_collaspone_collapsing.removeOnLayoutChangeListener(this)
//                    try {
//                        // 请注意参数字符串‘collapsingTextHelper’，这里对应都是Android X版本中CollapsingToolbarLayout类中声明的CollapsingTextHelper类的变量名
//                        // 由于collapsingTextHelper是不对外提供获取的，因此，这里需要用到反射来获取这个对象
//                        val field: Field =
//                            //ctl_collaspone_collapsing::class.java.getDeclaredField("collapsingTextHelper")
//                        ctl_collaspone_collapsing.javaClass.getDeclaredField("collapsingTextHelper")
//                        field.setAccessible(true)
//                        val collapsingTextHelper: CollapsingTextHelper =
//                            field.get(ctl_collaspone_collapsing) as CollapsingTextHelper
//                        field.setAccessible(false)
//                        // 请注意‘collapsedBounds’是CollapsingTextHelper类中声明的Rect的变量名
//                        // 这里是要获取原collapsedBounds的边界数值
//                        val collapsedBoundsField =
//                            field.getType().getDeclaredField("collapsedBounds")
//                        collapsedBoundsField.setAccessible(true)
//                        // 获取到原collapsedBounds的边界数值
//                        val oldRect: Rect = collapsedBoundsField.get(collapsingTextHelper) as Rect
//                        collapsedBoundsField.setAccessible(false)
//                        // 设置新的边界数值
//                        collapsingTextHelper.setCollapsedBounds(
//                            0,
//                            oldRect.top,
//                            right,
//                            oldRect.bottom
//                        )
//                        collapsingTextHelper.recalculate()
//                    } catch (e: NoSuchFieldException) {
//                        e.printStackTrace()
//                    } catch (e: IllegalAccessException) {
//                        e.printStackTrace()
//                    }
//                }
//            }
//        })


    }
}