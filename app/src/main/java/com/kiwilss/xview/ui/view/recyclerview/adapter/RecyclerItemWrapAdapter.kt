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

import android.view.ViewGroup
import android.widget.LinearLayout
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.utils.Utils
import kotlinx.android.synthetic.main.activity_recyclerview_wrap.*


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

        //获取屏幕的宽度,进行分配,4.5代表可以放4.5个item,高度任意,这里是match_parent
        //如果设置了margin,需要减去margin
        // val width = (context.resources.displayMetrics.widthPixels - Utils.dip2px(context,margin)) / 4.5f
        //参考https://blog.csdn.net/qq_32518491/article/details/81033275?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.channel_param
        val width = (context.resources.displayMetrics.widthPixels) / 4.5f
        val params = ViewGroup.LayoutParams(
            width.toInt(),
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        holder.itemView.layoutParams = params

    }

}