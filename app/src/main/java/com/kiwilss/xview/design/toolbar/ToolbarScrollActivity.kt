/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ToolbarScrollActivity
 * Author:   Administrator
 * Date:     2020/8/13 9:23
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.toolbar

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_toolbar_scroll.*

/**
 *@FileName: ToolbarScrollActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/13
 * @desc   : {只有toolbar,随着向上滚动消失,向下滚动显示}
 */
class ToolbarScrollActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar_scroll)

        /*
        toolbar 滚动设置:app:layout_scrollFlags="scroll|snap|enterAlways"
        scroll: 表示向上滚动时,toolbar一起滚动并隐藏
        snap: 表示当toolbar还没有显示或隐藏时,会根据当前的距离自动选择显示还是隐藏
        enterAlways: 表示向下滚动时,toolbar会一起滚动并显示
        exitUntilCollapsed: 表示当 collapsingToolbarLayout 随着滚动完成折叠后就保留在界面上
         */
        tb_tb_scroll_tb.setNavigationOnClickListener {
            finish()
        }
        //点击悬浮按钮,底部显示snackbar,然后snackbar顶起悬浮按钮,只有在coordicationlayout中才能实现
        fab_tb_scroll_menu.setOnClickListener {
            Snackbar.make(fab_tb_scroll_menu,"hello",Snackbar.LENGTH_SHORT)
                .setAction("sure",View.OnClickListener {
                    Toast.makeText(this, "action", Toast.LENGTH_SHORT).show()
                }).show()
        }
    }
}