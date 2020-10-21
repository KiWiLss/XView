package com.kiwilss.xview.ui.view.recyclerview.stick.two.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.recyclerview.stick.CategoryBean

/**
 *@FileName: AddressBookAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/10/20
 * @desc   : {DESCRIPTION}
 */
class AddressBookAdapter : BaseQuickAdapter<CategoryBean,BaseViewHolder>(R.layout.item_address_book) {
    override fun convert(holder: BaseViewHolder, item: CategoryBean) {
        holder.setText(R.id.tv_item_address_book_text,item.categoryName)
    }
}