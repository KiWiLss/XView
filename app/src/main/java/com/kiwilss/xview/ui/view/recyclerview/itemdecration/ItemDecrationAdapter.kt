package com.kiwilss.xview.ui.view.recyclerview.itemdecration

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: ItemDecrationAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/17
 * @desc   : {DESCRIPTION}
 */
class ItemDecrationAdapter : BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_decration_vertical) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_item_decoration_text,item)
    }
}