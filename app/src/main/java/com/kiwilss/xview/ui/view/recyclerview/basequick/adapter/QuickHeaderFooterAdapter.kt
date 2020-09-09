package com.kiwilss.xview.ui.view.recyclerview.basequick.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.LogUtils

/**
 *@FileName: QuickHeaderFooterAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/8
 * @desc   : {DESCRIPTION}
 */
class QuickHeaderFooterAdapter :
    BaseQuickAdapter<String, BaseViewHolder>(R.layout.item_quick_header_footer)
    , LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_item_quick_header_footer_text, item)

        val adapterPosition = holder.adapterPosition
        val layoutPos = holder.layoutPosition
        val oldPos = holder.oldPosition

        //LogUtils.e("item = $item ----- data = ${data[layoutPos - 1]}")
        LogUtils.e("adapterpos = $adapterPosition --------- layoutpos = $layoutPos --------- oldpos = $oldPos")
    }
}