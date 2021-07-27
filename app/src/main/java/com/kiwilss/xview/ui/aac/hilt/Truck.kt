package com.kiwilss.xview.ui.aac.hilt

import com.kiwilss.xview.utils.LogUtils
import javax.inject.Inject

/**
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2021/7/27
 * @desc   : {DESCRIPTION}
 */
class Truck @Inject constructor(val driver: Driver){

    @BindGasEngine
    @Inject
    lateinit var gasEngine: Engine

    @BindElectricEngine
    @Inject
    lateinit var electricEngine: Engine

    fun deliver(){
        gasEngine.start()
        electricEngine.start()
        LogUtils.e("Truck is delivering cargo. Driven by $driver")
        gasEngine.shutdown()
        electricEngine.shutdown()
    }
}

class Driver @Inject constructor(){

}