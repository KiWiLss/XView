/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ShawShapeActivity
 * Author:   Administrator
 * Date:     2020/8/6 10:45
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.shawshape

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.google.android.material.shape.MaterialShapeDrawable
import com.google.android.material.shape.RoundedCornerTreatment
import com.google.android.material.shape.ShapeAppearanceModel
import com.google.android.material.shape.ShapePathModel
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_shaw_shape.*

/**
 *@FileName: ShawShapeActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/6
 * @desc   : {DESCRIPTION}
 */
class ShawShapeActivity: AppCompatActivity() {
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shaw_shape)


        //代码实现shape
        //设置圆角
        val shapePathModel = ShapeAppearanceModel.builder()
            .setAllCorners(RoundedCornerTreatment())
            .setAllCornerSizes(resources.getDimension(R.dimen.m12))
            .build()
            //设置背景
        val backgroundDrawable = MaterialShapeDrawable(shapePathModel).apply {
            setTint(Color.RED)
            paintStyle = Paint.Style.FILL

            //设置阴影
            shadowCompatibilityMode = MaterialShapeDrawable.SHADOW_COMPAT_MODE_ALWAYS
            initializeElevationOverlay(this@ShawShapeActivity)
//            shadowRadius = resources.getDimension(R.dimen.m12).toInt()
            elevation = resources.getDimension(R.dimen.m12)
            setShadowColor(Color.parseColor("#D2D2D2"))
            shadowVerticalOffset = resources.getDimension(R.dimen.m2).toInt()

        }
        (tv_shaw_shape_corner.parent as? ViewGroup)?.clipChildren = false
        tv_shaw_shape_corner.background = backgroundDrawable

    }
}