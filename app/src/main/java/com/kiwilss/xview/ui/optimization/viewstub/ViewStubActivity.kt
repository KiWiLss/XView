/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: ViewStubActivity
 * Author:   kiwilss
 * Date:     2020/7/10 00:21
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.optimization.viewstub

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.nulltest.enumtest.Coupon
import com.kiwilss.xview.nulltest.enumtest.MyCoupon
import com.kiwilss.xview.nulltest.enumtest.UserCouponDetail
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_viewstub.*
import kotlinx.android.synthetic.main.include_layout.*

/**
 *@FileName: ViewStubActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/7/10
 * @desc   : {DESCRIPTION}
 */
class ViewStubActivity: AppCompatActivity() {
     var  inflate: View? = null
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewstub)

        btn_viewstub_show.setOnClickListener {
            //inflate 只能调用一次
            if (inflate == null){
                 inflate = vs_viewstub_sv.inflate()
            }
            //调用这个方法会闪退,viewstub 加载过后就会被移除
            //vs_viewstub_sv.visibility = View.VISIBLE
            rl_viewstub_outer.visibility = View.VISIBLE
        }
        btn_viewstub_hide.setOnClickListener {
            //vs_viewstub_sv.visibility = View.GONE
            rl_viewstub_outer.visibility = View.GONE
        }
        btn_viewstub_midify.setOnClickListener {
            //在 viewStub inflate 之前不可调用
            // tv_include_layout.text = "任意改变的内容"
            if (inflate == null){
                inflate = vs_viewstub_sv.inflate()
                tv_include_layout.text = "修改过后的内容"
            }else{
                tv_include_layout.text = "修改过后的内容"
            }
        }


        val coupon = Coupon(9,"hello")
        LogUtils.e(coupon.isBeanShort)

        val myCoupon = MyCoupon(UserCouponDetail("my","hello"))
        LogUtils.e(myCoupon.userCouponDetail.isMy())
        LogUtils.e(myCoupon.userCouponDetail.isMy2)
    }
}