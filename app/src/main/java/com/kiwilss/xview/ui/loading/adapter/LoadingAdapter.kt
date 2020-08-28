package com.kiwilss.xview.ui.loading.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dylanc.loadinghelper.LoadingHelper
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.layout_loading.view.*

/**
 *@FileName: LoadingAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {DESCRIPTION}
 */
class LoadingAdapter: LoadingHelper.Adapter<LoadingHelper.ViewHolder>() {
    override fun onBindViewHolder(holder: LoadingHelper.ViewHolder) {
        //可以对布局进行处理
        holder.rootView.tv_layout_loading_text?.text = "加载中..."
    }

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): LoadingHelper.ViewHolder {
       return LoadingHelper.ViewHolder(inflater.inflate(R.layout.layout_loading,parent,false))
    }
}