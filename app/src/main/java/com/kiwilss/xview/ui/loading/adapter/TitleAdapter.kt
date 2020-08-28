package com.kiwilss.xview.ui.loading.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import com.dylanc.loadinghelper.LoadingHelper
import com.kiwilss.xview.R

/**
 *@FileName: TitleAdapter
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/28
 * @desc   : {DESCRIPTION}
 */
class TitleAdapter : LoadingHelper.Adapter<LoadingHelper.ViewHolder>() {
    override fun onBindViewHolder(holder: LoadingHelper.ViewHolder) {

    }

    override fun onCreateViewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup
    ): LoadingHelper.ViewHolder {
        return LoadingHelper.ViewHolder(inflater.inflate(R.layout.layout_toolbar,parent,false))
    }
}