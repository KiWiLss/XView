/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ViewPagerAdapter
 * Author:   Administrator
 * Date:     2020/8/4 17:27
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.viewpager.vp2

import android.graphics.Color
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R

/**
 *@FileName: ViewPagerAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/4
 * @desc   : {DESCRIPTION}
 */
class ViewPagerAdapter(resId: Int = R.layout.item_viewpager): BaseQuickAdapter<String,BaseViewHolder>(resId) {
    override fun convert(holder: BaseViewHolder, item: String) {
        holder.getView<View>(R.id.tv_item_viewpager_text).setBackgroundColor(Color.parseColor(item))
    }
}