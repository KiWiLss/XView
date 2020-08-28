package com.kiwilss.xview.ui.loading.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dylanc.loadinghelper.LoadingHelper
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.layout_empty.view.*

/**
 *@FileName: EmptyAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {DESCRIPTION}
 */
class EmptyAdapter: LoadingHelper.Adapter<LoadingHelper.ViewHolder>() {
    override fun onBindViewHolder(holder: LoadingHelper.ViewHolder) {
        holder.rootView.tv_layout_empty_text?.setOnClickListener {
            if (holder.onReloadListener != null) {
                holder.onReloadListener?.onReload()
            }
        }
    }

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): LoadingHelper.ViewHolder {
        return LoadingHelper.ViewHolder(inflater.inflate(R.layout.layout_empty,parent,false))
    }
}