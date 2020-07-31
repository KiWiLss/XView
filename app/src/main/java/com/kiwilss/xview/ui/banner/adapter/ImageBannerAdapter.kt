/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ImageBannerAdapter
 * Author:   Administrator
 * Date:     2020/7/31 11:59
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.banner.adapter

import android.os.Build
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.kiwilss.xview.R
import com.kiwilss.xview.model.banner.BannerBean
import com.kiwilss.xview.utils.glide.GlideUtil
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.util.BannerUtils

/**
 *@FileName: ImageBannerAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/31
 * @desc   : {DESCRIPTION}
 */
class ImageBannerAdapter(resId: Int = R.layout.banner_image_title):
    BaseQuickAdapter<BannerBean,BaseViewHolder>(resId) {

    override fun convert(holder: BaseViewHolder, bannerBean: BannerBean) {

        val ivImageView = holder.getView<ImageView>(R.id.image)
        val tvTitle = holder.getView<TextView>(R.id.bannerTitle)
        if (bannerBean.isShowTitle){
            tvTitle.visibility =  View.VISIBLE
            tvTitle.text = bannerBean.title ?: "标题"
        }else{
            tvTitle.visibility =  View.GONE
        }
        val dimens = context.resources.getDimensionPixelOffset(R.dimen.dp_10)
        GlideUtil.loadImgRound(context,bannerBean.imgUrl,ivImageView,dimens)
    }
}

class ImageTitleAdapter(data: List<BannerBean>, private val round: Int): BannerAdapter<BannerBean,ImageTitleAdapter.ImageTitleHolder>(data){

    class ImageTitleHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imageView: ImageView? = itemView.findViewById(R.id.image)
        var title: TextView? = itemView.findViewById(R.id.bannerTitle)
    }

    override fun onCreateHolder(parent: ViewGroup?, viewType: Int): ImageTitleHolder {
        //整个布局圆角
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            if (round != 0){
                BannerUtils.setBannerRound(parent, round.toFloat())
            }
        }
        return ImageTitleHolder(BannerUtils.getView(parent!!, R.layout.banner_image_title))
    }

    override fun onBindView(
        holder: ImageTitleHolder?,
        data: BannerBean?,
        position: Int,
        size: Int
    ) {
        holder?.let {

            GlideUtil.loadImg(holder.imageView?.context,data?.imgUrl,holder.imageView)
            //GlideUtil.loadImgRound(holder.imageView?.context,data?.imgUrl,holder.imageView,round)
            if (data?.isShowTitle!!){
                holder.title!!.visibility =  View.VISIBLE
                holder.title!!.text = data.title ?: "标题"
            }else{
                holder.title!!.visibility =  View.GONE
            }
        }
    }
}

