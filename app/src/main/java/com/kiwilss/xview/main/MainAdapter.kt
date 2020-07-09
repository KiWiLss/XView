/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: MainAdapter
 * Author:   kiwilss
 * Date:     2020/7/8 00:07
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.main

import android.util.Log
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.model.main.MainBean

/**
 *@FileName: MainAdapter
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/8
 * @desc   : {DESCRIPTION}
 */
class MainAdapter(resId : Int = R.layout.item_main):
    BaseQuickAdapter<MainBean,BaseViewHolder>(resId) {

    override fun convert(holder: BaseViewHolder, item: MainBean) {
        Log.e("MMM", ": conver----${item.title}" );
        holder.setText(R.id.tv_item_main_content,item.title)
    }
}