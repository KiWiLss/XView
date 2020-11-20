package com.kiwilss.xview.ui.view.recyclerview.itemdecration

import android.content.Context

/**
 *@FileName: MyDivider
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/20
 * @desc   : {DESCRIPTION}
 */
class MyDivider(context: Context,divider: Int, color: Int): BaseDividerItemDecoration(context,divider,color) {
    override fun getItemSidesIsHaveOffsets(itemPosition: Int): BooleanArray {
        //顺时针顺序:left, top, right, bottom
        //默认只有bottom显示分割线
        return booleanArrayOf(false, false, false, true)
    }
}