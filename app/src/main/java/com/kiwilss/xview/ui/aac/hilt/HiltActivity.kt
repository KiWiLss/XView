package com.kiwilss.xview.ui.aac.hilt

import android.os.Bundle
import androidx.activity.viewModels
import com.kiwilss.xview.base.viewbinding.BaseVBActivity
import com.kiwilss.xview.databinding.ActivityHiltBinding
import com.kiwilss.xview.utils.LogUtils
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject

/**
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2021/7/27
 * @desc   : {DESCRIPTION}
 */
@AndroidEntryPoint
class HiltActivity: BaseVBActivity<ActivityHiltBinding>() {

    @Inject lateinit var truck: Truck
    @Inject lateinit var okHttpClient: OkHttpClient
    @Inject lateinit var retrofit: Retrofit

    @Inject lateinit var single : SingleTest

    @Inject lateinit var contextApplication: ContextApplication
    @Inject lateinit var contextActivity: ContextActivity

    val viewModel by viewModels<TestViewModel>()

    override fun initData() {

    }

    override fun initEvent() {
    }

    override fun initInterface(savedInstanceState: Bundle?) {
        viewModel.test()
       /* contextApplication.testContext()
        contextActivity.testContext()*/
      /*  truck.deliver()
        LogUtils.e(single.name)
        single.name = "单利已经修改"*/
    }
}