package com.kiwilss.xview.ui.aac.hilt

import android.app.Application
import com.kiwilss.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2021/7/27
 * @desc   : {获取自定义 application}
 */
@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {
    @Provides
    fun provideMyApp(application: Application): App{
        return application as App
    }
}