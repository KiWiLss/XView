package com.kiwilss.xview.ui.view.recyclerview.loadmore

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: LoadMoreAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/8
 * @desc   : {DESCRIPTION}
 */
class LoadMoreAdapter: BaseQuickAdapter<String,BaseViewHolder>(R.layout.item_load_more) ,LoadMoreModule{
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_item_load_more_text,item)
    }
}