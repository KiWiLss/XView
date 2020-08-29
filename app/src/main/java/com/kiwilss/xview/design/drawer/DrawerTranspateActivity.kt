package com.kiwilss.xview.design.drawer

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.snackbar.Snackbar
import com.gyf.immersionbar.ktx.immersionBar
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.activity_drawer_bottom.*
import kotlinx.android.synthetic.main.activity_drawer_transpate.*

/**
 *@FileName: DrawerTranspateActivity
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/24
 * @desc   : {DESCRIPTION}
 */
class DrawerTranspateActivity: AppCompatActivity(R.layout.activity_drawer_transpate) {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        immersionBar {
            //fullScreen(true)
            transparentStatusBar()
           //statusBarColor(R.color.blue_74D3FF)
            statusBarDarkFont(false)
        }

        tb_drawer_transpate_toolbar.title = "抽屉透明状态栏"
        setSupportActionBar(tb_drawer_transpate_toolbar)

//        tb_drawer_transpate_toolbar.setNavigationIcon(R.mipmap.ic_navigation_menu)
//        tb_drawer_transpate_toolbar.setNavigationOnClickListener {
//            dl_drawer_bottom_drawer.open()
//        }

        //创建返回键，并实现打开关/闭监听
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,dl_drawer_transpate_drawer,tb_drawer_transpate_toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        dl_drawer_transpate_drawer.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        //抽屉打开关闭监听
//        dl_drawer_transpate_drawer.addDrawerListener(object : DrawerLayout.DrawerListener{
//            override fun onDrawerStateChanged(newState: Int) {
//
//            }
//
//            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
//
//            }
//
//            override fun onDrawerClosed(drawerView: View) {
//
//            }
//
//            override fun onDrawerOpened(drawerView: View) {
//
//            }
//
//        })

        //侧滑抽屉点击监听
        nv_drawer_transpate_navigation.run {
            //设置每个文字和图片颜色变化
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                itemTextColor = resources.getColorStateList(R.drawable.nav_menu_text_color, null)
                itemIconTintList = resources.getColorStateList(R.drawable.nav_menu_text_color, null)
            }
            //设置默认选中
            setCheckedItem(R.id.nav_home)
            setNavigationItemSelectedListener {
                Snackbar.make(nv_drawer_transpate_navigation, "hello", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
                dl_drawer_transpate_drawer.close()
                true
            }
        }



    }
}