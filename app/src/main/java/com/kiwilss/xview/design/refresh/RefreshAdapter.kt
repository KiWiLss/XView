/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: RefreshAdapter
 * Author:   kiwilss
 * Date:     2020/8/16 22:55
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.design.refresh

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.item_refresh.view.*

/**
 *@FileName: RefreshAdapter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/16
 * @desc   : {DESCRIPTION}
 */
class RefreshAdapter(layoutId: Int = R.layout.item_refresh)
    : BaseQuickAdapter<String,BaseViewHolder>(layoutId){
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.itemView.tv_item_refresh_text.text = item
    }
}