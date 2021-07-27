package com.kiwilss.xview.ui.aac.hilt

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

/**
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2021/7/27
 * @desc   : {测试单利}
 */
@Module
@InstallIn(SingletonComponent::class)
class SingleModule {//如果使用 object,singlemodule 类也是单利的

    @Singleton//加上这个注解才能全局唯一
    @Provides
    fun provideUtils(): SingleTest{
        return SingleTest("全局唯一单利")
    }


}

class SingleTest(var name: String)


