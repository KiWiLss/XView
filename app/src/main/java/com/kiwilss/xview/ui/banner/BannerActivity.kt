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
import com.kiwilss.xview.ui.banner.adapter.ImageTitleAdapter
import com.kiwilss.xview.utils.Utils
import com.youth.banner.config.IndicatorConfig
import com.youth.banner.indicator.CircleIndicator
import com.youth.banner.indicator.RectangleIndicator
import com.youth.banner.indicator.RoundLinesIndicator
import com.youth.banner.transformer.*
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
        val dimens = resources.getDimensionPixelOffset(R.dimen.dp_10)
        //dimens代码动态设置整个banner圆角,也可以在xml中通过banner_radius设置(xml中优先级更高)
        val circleAdapter = ImageTitleAdapter(Utils.getBannerList1(),dimens)
        banner_circle?.let {
            it.indicator = CircleIndicator(this)
            it.addBannerLifecycleObserver(this)
            it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            it.adapter = circleAdapter
        }
        //圆形指示器 + 标题
        val circleTitleAdapter = ImageTitleAdapter(Utils.getBannerList2(),dimens)
        banner_circle_title?.let {
            it.indicator = CircleIndicator(this)
            it.addBannerLifecycleObserver(this)
            it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            it.adapter = circleTitleAdapter
        }
        //矩形指示器,带圆角
        banner_rect?.let {
            it.indicator = RectangleIndicator(this)
            it.addBannerLifecycleObserver(this)
            it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            it.adapter = circleAdapter
        }
        //矩形指示器,不带圆角
        banner_rectNo?.let {
            it.indicator = RectangleIndicator(this)
            it.setIndicatorRadius(0)
            it.addBannerLifecycleObserver(this)
            //it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            it.adapter = circleAdapter
        }
        //矩形圆角和圆形指示器切换
        banner_rectCircle?.let {
            it.indicator = RectangleIndicator(this)
            it.addBannerLifecycleObserver(this)
            //it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            it.adapter = circleAdapter
        }

        //圆形指示器 + 画廊
        banner_gallery?.let {
            it.indicator = CircleIndicator(this)
            it.addBannerLifecycleObserver(this)
            //it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            //添加画廊效果(可以和其他PageTransformer组合使用，比如AlphaPageTransformer，注意但和其他带有缩放的PageTransformer会显示冲突)
            it.setBannerGalleryEffect(18,10)
            //添加透明效果(画廊配合透明效果更棒)
            it.addPageTransformer(AlphaPageTransformer())
            it.adapter = circleAdapter
        }
        //圆形指示器 + 圆形指示器外置
        banner_outer?.let {
            it.setIndicator(indicator,false)//外置圆形指示器
            it.addBannerLifecycleObserver(this)
            //it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            //添加透明效果(画廊配合透明效果更棒)
            it.addPageTransformer(AlphaPageTransformer())
            it.adapter = circleAdapter
        }

        //圆形指示器 + 切换效果
        banner_page?.let {
            it.indicator = CircleIndicator(this)
            it.addBannerLifecycleObserver(this)
            //it.setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
            //添加透明效果(画廊配合透明效果更棒)
            it.addPageTransformer(AlphaPageTransformer())
            it.adapter = circleAdapter
        }
        btn_rotateY.setOnClickListener {
            banner_page.addPageTransformer(RotateYTransformer())
        }
        btn_depth.setOnClickListener {
            banner_page.addPageTransformer(DepthPageTransformer())
        }
        btn_ScaleIn.setOnClickListener {
            banner_page.addPageTransformer(ScaleInTransformer())
        }
        btn_zoomOut.setOnClickListener {
            banner_page.addPageTransformer(ZoomOutPageTransformer())
        }
    }


}