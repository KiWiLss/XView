package com.kiwilss.xview.ui.view.recyclerview.swapadpter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: SwapAdapterTwoAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/2
 * @desc   : {DESCRIPTION}
 */
class SwapAdapterTwoAdapter: BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_swpaadapter_grid) {
    /**
     * Implement this method and use the helper to adapt the view to the given item.
     *
     * 实现此方法，并使用 helper 完成 item 视图的操作
     *
     * @param helper A fully initialized helper.
     * @param item   The item that needs to be displayed.
     */
    override fun convert(holder: BaseViewHolder, item: String) {

    }
}