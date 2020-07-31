/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: BannerActivity
 * Author:   Administrator
 * Date:     2020/7/31 11:52
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.banner

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.model.banner.BannerBean
import com.kiwilss.xview.ui.banner.adapter.ImageBannerAdapter
import com.kiwilss.xview.ui.banner.adapter.ImageTitleAdapter
import com.kiwilss.xview.utils.Utils
import com.youth.banner.adapter.BannerAdapter
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import kotlinx.android.synthetic.main.activity_banner.*

/**
 *@FileName: BannerActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/31
 * @desc   : {DESCRIPTION}
 */
class BannerActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)


        //默认圆形指示器
//        val circleAdapter = ImageBannerAdapter()
//        circleAdapter.setList(Utils.getBannerList1())
        val dimens = resources.getDimensionPixelOffset(R.dimen.dp_10)
        val circleAdapter = ImageTitleAdapter(Utils.getBannerList1(),dimens)
        banner_circle?.let {
            it.indicator = CircleIndicator(this)
            it.addBannerLifecycleObserver(this)
            it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            it.adapter = circleAdapter
        }
        val circleTitleAdapter = ImageTitleAdapter(Utils.getBannerList2(),dimens)
        banner_circle_title?.let {
            it.indicator = CircleIndicator(this)
            it.addBannerLifecycleObserver(this)
            it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            it.adapter = circleTitleAdapter
        }


    }


}