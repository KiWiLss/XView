package com.kiwilss.xview.ui.view.recyclerview.stick.test

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.recyclerview.stick.CategoryBean

/**
 *@FileName: StickTestAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
class StickTestAdapter: BaseQuickAdapter<CategoryBean,BaseViewHolder>(R.layout.item_stick_test) {
    override fun convert(holder: BaseViewHolder, item: CategoryBean) {

        holder.setText(R.id.tv_item_stick_test_title,item.categoryName)

    }
}