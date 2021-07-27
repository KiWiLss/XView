package com.kiwilss.xview.ui.aac.datastore

import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.kiwilss.App
import com.kiwilss.xview.base.viewbinding.BaseVBActivity
import com.kiwilss.xview.config.Constant
import com.kiwilss.xview.databinding.ActivityDatastoreBasicBinding
import com.kiwilss.xview.ui.aac.hilt.SingleTest
import com.kiwilss.xview.utils.LogUtils
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject


/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/27
 *  desc   :
 */
@AndroidEntryPoint
class DataStoreBasicActivity : BaseVBActivity<ActivityDatastoreBasicBinding>() {
    @Inject
    lateinit var single : SingleTest

    override fun initData() {
        LogUtils.e(single.name)
    }

    override fun initEvent() {
    }

    // 创建 Preferences DataStore
    private lateinit var  dataStore: DataStore<Preferences>

    private lateinit var  mKey: Preferences.Key<String>

    override fun initInterface(savedInstanceState: Bundle?) {
        LogUtils.e(Thread.currentThread().name,"初始线程：")
        //可以放在baseactivity中
        dataStore  =  createDataStore(Constant.DATA_STORE_GLOBAL)
        mKey = preferencesKey(Constant.DATA_STORE_TEST)
        //存数据
        binding.btnSave.setOnClickListener {
            lifecycleScope.launch {
                saveData("存一个String类型数据")
            }
        }


        binding.btnQuery.setOnClickListener {
            val flow = dataStore.data.map {
                it[mKey]
            }
            lifecycleScope.launch {
                flow.collectLatest {
                    LogUtils.e(it,"查询数据：")
                }
            }
        }

        binding.btnDelete.setOnClickListener {
            lifecycleScope.launch {
                deleteData()
            }
        }

        binding.btnSet.setOnClickListener {
            lifecycleScope.launch{
                val data = readData()
                data.collectLatest {
                    //设置以后改变了存储的数据，textview的text也会改变
                        binding.tvDataStoreData.text = it
                }
            }
        }



    }

    private suspend fun deleteData(){
        dataStore.edit {
            it[mKey] = ""
        }
    }

    private suspend fun readData(): Flow<String?> {
        LogUtils.e("read")
        return dataStore.data
            .catch {
                // 当读取数据遇到错误时，如果是 `IOException` 异常，发送一个 emptyPreferences 来重新使用
                // 但是如果是其他的异常，最好将它抛出去，不要隐藏问题
                LogUtils.e(it)
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map {
               it[mKey]
            }
    }

    private suspend fun saveData(s: String) {
        dataStore.edit {
            it[mKey] = s
        }
    }

    //取DataStore的值加一后再次存入
//    private suspend fun incrementCounter() {
//        dataStore.edit { settings ->
//            val currentCounterValue = settings[mKey] ?: 0
//            settings[mKey] = currentCounterValue + 1
//        }
//    }


    fun readData2(key: Preferences.Key<Boolean>): Flow<Boolean> =
        dataStore.data
            .catch {
                // 当读取数据遇到错误时，如果是 `IOException` 异常，发送一个 emptyPreferences 来重新使用
                // 但是如果是其他的异常，最好将它抛出去，不要隐藏问题
                if (it is IOException) {
                    it.printStackTrace()
                    emit(emptyPreferences())
                } else {
                    throw it
                }
            }.map { preferences ->
                preferences[key] ?: false
            }

}