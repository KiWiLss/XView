/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ListDialogAdapter
 * Author:   kiwilss
 * Date:     2020/8/3 21:16
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.mddialog.adapter

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: ListDialogAdapter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/3
 * @desc   : {DESCRIPTION}
 */
class ListDialogAdapter(resId: Int = R.layout.item_list_dialog)
    : BaseQuickAdapter<String,BaseViewHolder>(resId){
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.setText(R.id.tv_item_list_dialog_title,item)
    }
}