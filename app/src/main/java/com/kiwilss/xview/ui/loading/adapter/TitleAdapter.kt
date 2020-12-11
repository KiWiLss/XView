package com.kiwilss.xview.ui.loading.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.dylanc.loadinghelper.LoadingHelper
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.layout_toolbar.view.*

/**
 *@FileName: TitleAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {DESCRIPTION}
 */
class TitleAdapter(val title: String) : LoadingHelper.Adapter<LoadingHelper.ViewHolder>() {
    override fun onBindViewHolder(holder: LoadingHelper.ViewHolder) {
        holder.rootView.run {
            iv_layout_toolbar_back?.setOnClickListener {
                if (context is Activity) {
                    (context as Activity).finish()
                }
            }
            tv_layout_toolbar_title?.text = title
        }
    }

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): LoadingHelper.ViewHolder {
        return LoadingHelper.ViewHolder(inflater.inflate(R.layout.layout_toolbar,parent,false))
    }
}