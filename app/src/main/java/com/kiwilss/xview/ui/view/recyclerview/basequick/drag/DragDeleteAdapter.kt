package com.kiwilss.xview.ui.view.recyclerview.basequick.drag

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.module.DraggableModule
import com.chad.library.adapter.base.module.LoadMoreModule
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: DragDeleteAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/9
 * @desc   : {DESCRIPTION}
 */
class DragDeleteAdapter : BaseQuickAdapter<DragBean, BaseViewHolder>(R.layout.item_multi_quick_text)
    , DraggableModule,LoadMoreModule {
    override fun convert(holder: BaseViewHolder, item: DragBean) {
        holder.setText(R.id.tv_item_multi_quick_text,item.title + item.test)
    }
}