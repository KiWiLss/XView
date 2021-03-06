/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ListDialog
 * Author:   kiwilss
 * Date:     2020/8/3 21:10
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.mddialog.dialog

import android.content.Context
import android.os.Bundle
import android.view.WindowManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.mddialog.adapter.ListDialogAdapter
import kotlinx.android.synthetic.main.dialog_bottom.*

/**
 *@FileName: ListDialog
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/3
 * @desc   : {DESCRIPTION}
 */
class ListDialog(context: Context): BottomSheetDialog(context) {
    fun getScreenHeight(context: Context): Int {
        val wm =
            context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        return wm.defaultDisplay.height
    }

    init {
        setContentView(R.layout.dialog_bottom)
        setCancelable(true)//是否可以滑动关闭
        setCanceledOnTouchOutside(true)//是否可以点击外部关闭
//        //设置全屏
//        behavior.state = BottomSheetBehavior.STATE_EXPANDED
//        //设置下滑跳过折叠态
//        behavior.skipCollapsed = true
    }
    val list = arrayListOf<String>("测试数据一","测试数据二","测试数据三","测试数据四"
    ,"测试数据一","测试数据二","测试数据三","测试数据四")
    private val mAdapter by lazy { ListDialogAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rv_dialog_bottom_list.layoutManager = LinearLayoutManager(context)
        rv_dialog_bottom_list.setHasFixedSize(true)
        rv_dialog_bottom_list.adapter = mAdapter
        mAdapter.setList(list)


    }
}