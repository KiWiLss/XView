package com.kiwilss.xview.ui.startforresulthelp

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.SparseArray
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.startforresulthelp.help.ActivityHelper
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_help.*

/**
 *@FileName: HelpActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/20
 * @desc   : {DESCRIPTION}
 */
class HelpActivity: AppCompatActivity(R.layout.activity_help) {

    private val mCallbacks: SparseArray<ActivityHelper.Callback> =
        SparseArray<ActivityHelper.Callback>()
    private var key = 9

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_help_jump.setOnClickListener {
            ActivityHelper.init(this)
                .startActivityForResult(HelpResultActivity::class.java,object : ActivityHelper.Callback{
                    override fun onActivityResult(resultCode: Int, data: Intent?) {
                        LogUtils.e(resultCode)
                        data?.run {
                            LogUtils.e(getStringExtra("result"))
                        }
                    }

                })
        }

        btn_help_jump2.setOnClickListener {

            val intent = Intent(this,HelpResultActivity::class.java)
            intent.putExtra("key","hello")
            ActivityHelper.init(this)
                .startActivityForResult(intent,object : ActivityHelper.Callback{
                    override fun onActivityResult(resultCode: Int, data: Intent?) {
                        LogUtils.e(resultCode)
                        data?.run {
                            LogUtils.e(getStringExtra("result"))
                            LogUtils.e(getStringExtra("callback"))
                        }
                    }

                })

        }
        btn_help_size.setOnClickListener {
//           val size =  ActivityHelper.init(this).mRouterFragment?.mCallbacks?.size()
//            LogUtils.e(size)
            startActivityForResult(Intent(this,HelpResultActivity::class.java),99)
        }
        btn_help_add.setOnClickListener {
            key++
            val callback = object : ActivityHelper.Callback{
                override fun onActivityResult(resultCode: Int, data: Intent?) {

                }

            }
            mCallbacks.put(key,callback)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.e("--------${mCallbacks.size()}----${isDestroyed}")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        LogUtils.e("onActivityResult$requestCode-----$resultCode")
    }
}