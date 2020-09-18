package com.kiwilss.xview.ui.view.recyclerview.stick.two.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.recyclerview.stick.CategoryBean

/**
 *@FileName: StickyTwoCustomAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/18
 * @desc   : {DESCRIPTION}
 */
class StickyTwoCustomAdapter : BaseQuickAdapter<CategoryBean,BaseViewHolder>(R.layout.item_sticky_two) {
    override fun convert(holder: BaseViewHolder, item: CategoryBean) {
        holder.setText(R.id.tv_item_sticky_two_text,item.categoryName)
    }
}