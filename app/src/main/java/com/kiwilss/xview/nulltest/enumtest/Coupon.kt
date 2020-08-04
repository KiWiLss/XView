package com.kiwilss.xview.nulltest.enumtest

import android.text.TextUtils

/**
 * @author : Lss Administrator
 * @FileName: Coupon
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
data class Coupon(val merchantId: Long, val exchangeStatus: String) {
//    var merchantId //商家Id
//            : Long = 0
//     var exchangeStatus //兑换状态 0:可以领取，1：已抢完，2：已兑换，3：已过期，4：卡豆不足
//            : String? = null

    /**是否卡豆不足
     * @return
     */
    val isBeanShort: Boolean
        get() = TextUtils.equals("4", exchangeStatus)

    /**是否已兑换
     * @return
     */
    val isExchange: Boolean
        get() = TextUtils.equals("2", exchangeStatus)

    /**是否已抢完
     * @return
     */
    val isGrabbed: Boolean
        get() = TextUtils.equals("1", exchangeStatus)

    /**是否可以领取
     * @return
     */
    val isReceiver: Boolean
        get() = TextUtils.equals("0", exchangeStatus)
}