package com.kiwilss.xview.ui.aac.hilt

import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.kiwilss.xview.utils.LogUtils
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2021/7/27
 * @desc   : {hilt 在 viewmodel 中使用}
 */
@HiltViewModel
class TestViewModel @Inject constructor(private val repository: TestRepository): ViewModel(){

    fun test(){
        repository.test()
    }

}

class TestRepository @Inject constructor(){
    fun test(){
        LogUtils.e("TestRepository")
    }
}