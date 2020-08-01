/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RecyclerItemFixedAdapter
 * Author:   Administrator
 * Date:     2020/8/1 11:10
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.recyclerview.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: RecyclerItemFixedAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/1
 * @desc   : {DESCRIPTION}
 */
class RecyclerItemWrapAdapter(resId: Int = R.layout.item_recycelr_wrap)
    : BaseQuickAdapter<String,BaseViewHolder>(resId){
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_item_recycler_wrap_title,item)
    }
}