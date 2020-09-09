package com.kiwilss.xview.ui.view.recyclerview.basequick.section

import com.chad.library.adapter.base.BaseSectionQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: SectionQuickAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
class SectionQuickAdapter: BaseSectionQuickAdapter<SectionBean,BaseViewHolder>(R.layout.item_section_quick_header,R.layout.item_section_quick) {
    override fun convert(holder: BaseViewHolder, item: SectionBean) {
       holder.setText(R.id.tv_item_section_quick_text,item.name)
    }

    override fun convertHeader(helper: BaseViewHolder, item: SectionBean) {
        helper.setText(R.id.tv_item_section_quick_header_text,item.headerTitle)
    }
}