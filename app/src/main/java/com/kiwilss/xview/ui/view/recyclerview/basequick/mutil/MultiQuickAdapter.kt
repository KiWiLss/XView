package com.kiwilss.xview.ui.view.recyclerview.basequick.mutil

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: MultiQuickAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
class MultiQuickAdapter: BaseMultiItemQuickAdapter<MuiltBean,BaseViewHolder>( ) {

    init {
        addItemType(MuiltBean.TEXT, R.layout.item_multi_quick_text)
        addItemType(MuiltBean.IMG,R.layout.item_multi_quick_img)
        addItemType(MuiltBean.Span,R.layout.item_multi_quick_span)
    }


    override fun convert(holder: BaseViewHolder, item: MuiltBean) {
        when (holder.itemViewType) {
            MuiltBean.TEXT -> {
                holder.setText(R.id.tv_item_multi_quick_text,item.first)
            }
            MuiltBean.IMG -> {

            }
            MuiltBean.Span -> {
                holder.setText(R.id.tv_item_multi_quick_span_text,item.second)
            }
        }
    }
}