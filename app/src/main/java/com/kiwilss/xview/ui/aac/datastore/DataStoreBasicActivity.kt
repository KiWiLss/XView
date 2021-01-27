package com.kiwilss.xview.ui.aac.datastore

import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.kiwilss.xview.base.viewbinding.BaseVBActivity
import com.kiwilss.xview.databinding.ActivityDatastoreBasicBinding
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.io.IOException


/**
 * @author : Administrator
 * e-mail : kiwilss@163.com
 * time   : 2021/01/27
 *  desc   :
 */
class DataStoreBasicActivity: BaseVBActivity<ActivityDatastoreBasicBinding>() {



    override fun initData() {

    }

    override fun initEvent() {
    }
    val dataStore: DataStore<Preferences> = createDataStore(
        name = "settings"
    )

    private val mKey = preferencesKey<Int>(name = "my_counter")


    override fun initInterface(savedInstanceState: Bundle?) {

        // 创建 Preferences DataStore
//        val dataStore: DataStore<Preferences> = createDataStore(
//            name = "settings"
//        )
        //存数据
        binding.btnSave.setOnClickListener {
        val key = preferencesKey<Boolean>("true")
            lifecycleScope.launch {
                saveData(key)
            }
        }




        val keyB = preferencesKey<Boolean>("keyB")

        readData(keyB).map {

        }


    }

    //取DataStore的值加一后再次存入
    private suspend fun incrementCounter() {
        dataStore.edit { settings ->
            val currentCounterValue = settings[mKey] ?: 0
            settings[mKey] = currentCounterValue + 1
        }
    }



     suspend fun saveData(key: Preferences.Key<Boolean>) {
        dataStore.edit { mutablePreferences ->
            val value = mutablePreferences[key] ?: false
            mutablePreferences[key] = !value
        }
    }


     fun readData(key: Preferences.Key<Boolean>): Flow<Boolean> =
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