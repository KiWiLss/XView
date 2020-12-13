package com.kiwilss

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gyf.immersionbar.ktx.immersionBar
import com.kiwilss.xview.R
import com.kiwilss.xview.main.MainActivity

/**
 * @author : Lss Administrator
 * @FileName: SplashActivity
 * @e-mail : kiwilss@163.com
 * @time : 2020/11/28
 * @desc : {背景图片会变形}
 */
class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //setTheme(R.style.AppTheme)
        window.setBackgroundDrawable(null)
        super.onCreate(savedInstanceState)

//        immersionBar {
//            transparentStatusBar()
//            //fullScreen()
//        }



    }

    override fun onResume() {
        super.onResume()
        window.decorView.postDelayed(next,1000)
    }

    val next = Runnable {
        startActivity(Intent(this,MainActivity::class.java))
        finish()
    }

    override fun onStop() {
        super.onStop()
        window.decorView.removeCallbacks(next)

    }
}