package com.kiwilss.xview.ui.startforresulthelp

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.MediaStore
import android.util.AttributeSet
import android.util.SparseArray
import android.view.View

import androidx.annotation.RequiresApi
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





    }

//    private fun dslRequestPerssion() {
//        val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
//        requestPermission(Manifest.permission.RECORD_AUDIO,
//            granted = { permission ->
//                //权限申请成功
//                LogUtils.e("granted")
//            },
//            denied = { permission ->
//                //权限申请失败且未勾选不再询问，下次可继续申请
//                LogUtils.e("denied")
//            },
//            explained = { permission ->
//                //权限申请失败且已勾选不再询问，需要向用户解释原因并引导用户开启权限
//                LogUtils.e("explained")
//            })
//    }

//    private val startActivity =
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult? ->
//            LogUtils.e(result?.data?.getStringExtra("result") ?: "什么都没有返回")
//        }
//
//    private val takePic = registerForActivityResult(TakePicDrawable()){result ->
//
//    }
//
//    private class TakePicDrawable : ActivityResultContract<Void, Drawable>(){
//        override fun parseResult(resultCode: Int, intent: Intent?): Drawable? {
//            if (resultCode != Activity.RESULT_OK || intent == null) return null
//            val bitmap = intent.getParcelableExtra<Bitmap>("data")
//            return BitmapDrawable(bitmap)
//        }
//
//        override fun createIntent(context: Context, input: Void?): Intent {
//            return Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//        }
//    }

    override fun onStart() {
        super.onStart()
    }
    override fun onResume() {
        super.onResume()
        btn_help_add.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                //requestOnePerssion()
            }
//            dslRequestPerssion()
            //startActivity.launch(Intent(this,HelpResultActivity::class.java))
        }
    }


//    @RequiresApi(Build.VERSION_CODES.M)
//    private fun requestOnePerssion() {
//        val permission = Manifest.permission.WRITE_EXTERNAL_STORAGE
//        registerForActivityResult(ActivityResultContracts.RequestPermission()) { result ->
//            // 请求结果，result 为 boolean true 代表已授权，false 代表未授权
//            when{
//                result -> {
//                    LogUtils.e("get")
//                }
//                shouldShowRequestPermissionRationale(permission) -> {
//                    LogUtils.e("被拒绝")
//                }
//                else -> {
//                    LogUtils.e("not show")
//                }
//            }
//        }.launch(permission)
//
//    }

    override fun onDestroy() {
        super.onDestroy()
        LogUtils.e("--------${mCallbacks.size()}----${isDestroyed}")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        LogUtils.e("onActivityResult$requestCode-----$resultCode")
    }
}