package com.kiwilss.xview.nulltest.enumtest

import android.text.TextUtils

data class UserCouponDetail(
    val couponStatus: String,
    val couponType: String
){

    fun isMy() = TextUtils.equals("my",couponStatus)

    val isMy2 : Boolean
    get() = TextUtils.equals("my2",couponStatus)


}