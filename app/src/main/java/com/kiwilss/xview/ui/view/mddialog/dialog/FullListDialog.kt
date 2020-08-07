/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: FullListDialog
 * Author:   Administrator
 * Date:     2020/8/7 10:08
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.mddialog.dialog

import android.content.Context
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.mddialog.adapter.ListDialogAdapter
import kotlinx.android.synthetic.main.dialog_bottom.*
import kotlinx.android.synthetic.main.dialog_bottom_list.*

/**
 *@FileName: FullListDialog
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/7
 * @desc   : {recyclerview数据较少时,高度自适应,数据较多时,占据全屏(初始显示不会占据全屏,上拉占据全屏)}
 */
class FullListDialog(context: Context): BottomSheetDialog(context) {
    init {
        setContentView(R.layout.dialog_bottom_list)
        setCancelable(true)
        setCanceledOnTouchOutside(true)
    }

    val list = arrayListOf<String>("测试数据一","测试数据二","测试数据三","测试数据四"
        ,"测试数据一","测试数据二","测试数据三","测试数据四","测试数据二","测试数据三","测试数据四"
        ,"测试数据一","测试数据二","测试数据三","测试数据四"  ,"测试数据一","测试数据二","测试数据三","测试数据四"
    )

    private val mAdapter by lazy { ListDialogAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        rv_dialog_bottom_list_list.layoutManager = LinearLayoutManager(context)
        rv_dialog_bottom_list_list.setHasFixedSize(true)
        rv_dialog_bottom_list_list.adapter = mAdapter
        mAdapter.setList(list)

    }
}