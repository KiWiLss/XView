/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: CouponTeest
 * Author:   Administrator
 * Date:     2020/8/4 17:02
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.nulltest.optional

import com.squareup.moshi.Json

/**
 *@FileName: CouponTeest
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/4
 * @desc   : {DESCRIPTION}
 */
data class CouponTeest(
    val userCouponDetail: UserCouponDetail
)

data class UserCouponDetail(
    @Json(name = "acquired")
    val acquired: String,
    val activeBeginDate: String,
    val activeDays: String,
    val activeEndDate: String,
    val available: String,
    val couponDesc: String,
    val couponName: String,
    val couponRemainCount: Int,
    val couponRule: String,
    val couponStatus: String,
    val couponType: String,
    val couponValue: String,
    val id: Int,
    val merchantId: Int
)