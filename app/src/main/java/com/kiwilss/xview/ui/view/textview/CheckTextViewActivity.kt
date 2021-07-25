package com.kiwilss.xview.ui.view.textview

import android.content.res.Configuration
import android.os.Bundle
import android.widget.CheckedTextView
import com.kiwilss.xview.base.viewbinding.BaseVBActivity
import com.kiwilss.xview.databinding.ViewActivityChecktextviewBinding
import com.kiwilss.xview.utils.LogUtils

/**
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2021/7/25
 * @desc   : {DESCRIPTION}
 */
class CheckTextViewActivity: BaseVBActivity<ViewActivityChecktextviewBinding>() {
    override fun initData() {

    }

    override fun initEvent() {

        binding.ctvSingle.setOnClickListener {
            toggle()
        }

    }

    private fun toggle() {
        val isCheck = binding.ctvSingle.isChecked
        binding.ctvSingle.isChecked = !isCheck
    }


    override fun initInterface(savedInstanceState: Bundle?) {


    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LogUtils.e("onConfigurationChanged")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        LogUtils.e("onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        LogUtils.e("onRestoreInstanceState")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.e("onCreate")
    }

    override fun onRestart() {
        super.onRestart()
        LogUtils.e("onRestart")
    }

    override fun onStart() {
        super.onStart()
        LogUtils.e("onStart")
    }

    override fun onResume() {
        super.onResume()
        LogUtils.e("onResume")
    }

    override fun onPause() {
        super.onPause()
        LogUtils.e("onPause")
    }

    override fun onStop() {
        super.onStop()
        LogUtils.e("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.e("onDestroy")
    }
}