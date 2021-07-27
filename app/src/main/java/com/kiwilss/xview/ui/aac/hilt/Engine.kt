package com.kiwilss.xview.ui.aac.hilt

import com.kiwilss.xview.utils.LogUtils
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Inject
import javax.inject.Qualifier

/**
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2021/7/27
 * @desc   : {DESCRIPTION}
 */
interface Engine {
    fun start()
    fun shutdown()
}

class GasEngine @Inject constructor() : Engine {
    override fun start() {
        LogUtils.e("Gas engine start.")
    }

    override fun shutdown() {
        LogUtils.e("Gas engine shutdown.")
    }
}
class ElectricEngine @Inject constructor() : Engine {
    override fun start() {
        LogUtils.e("Electric engine start.")
    }

    override fun shutdown() {
        LogUtils.e("Electric engine shutdown.")
    }
}
@Module
@InstallIn(ActivityComponent::class)
abstract class EngineModule{
    /*//这种写法只能使用其中一个
    @Binds
    abstract fun bingEngine(gasEngine: GasEngine): Engine*/

    @BindGasEngine
    @Binds
    abstract fun bindGas(gasEngine: GasEngine): Engine

    @BindElectricEngine
    @Binds
    abstract fun bindElectric(gasEngine: ElectricEngine): Engine

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindGasEngine

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BindElectricEngine


