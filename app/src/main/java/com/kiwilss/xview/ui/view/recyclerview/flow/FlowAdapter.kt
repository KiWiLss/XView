package com.kiwilss.xview.ui.view.recyclerview.flow

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: FlowAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/10
 * @desc   : {DESCRIPTION}
 */
class FlowAdapter: BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_my_home_tag) {
    override fun convert(holder: BaseViewHolder, item: String) {
            holder.setText(R.id.tv_item_my_home_tag_text,item)
    }
}