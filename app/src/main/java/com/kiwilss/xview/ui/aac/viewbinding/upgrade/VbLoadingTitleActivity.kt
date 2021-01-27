package com.kiwilss.xview.ui.aac.viewbinding.upgrade

import android.os.Bundle
import com.dylanc.loadinghelper.LoadingHelper
import com.dylanc.loadinghelper.ViewType
import com.kiwilss.xview.base.viewbinding.BaseVBActivity
import com.kiwilss.xview.databinding.ActivityVbloadingTitleBinding
import com.kiwilss.xview.ui.loading.adapter.TitleAdapter
import com.kiwilss.xview.utils.LogUtils

/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/27
 *  desc   :
 */
class VbLoadingTitleActivity: BaseVBActivity<ActivityVbloadingTitleBinding>() {
    override fun initData() {

    }

    override fun initEvent() {

    }

    override fun initInterface(savedInstanceState: Bundle?) {
        binding.btnVbLoadingTitleChange.setOnClickListener {
            //通过adapter对内容进行修改
            val adapter = mLoadingHelper.getAdapter<TitleAdapter>(ViewType.TITLE)
            adapter.changeTitle("更换标题")
        }



    }

    override fun initTitleBar(titleC: CharSequence?) {
        val title = intent.getStringExtra(EXTRA_TITLE)
        LogUtils.e(title)
        super.initTitleBar(title)
    }

}