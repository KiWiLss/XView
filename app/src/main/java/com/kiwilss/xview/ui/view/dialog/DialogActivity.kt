/**
 * Copyright (C), 2017-2020, XXX有限公司
 * FileName: DialogActivity
 * Author:   Administrator
 * Date:     2020/8/10 16:00
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

package com.kiwilss.xview.ui.view.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.dialog.base.XDialog
import com.kiwilss.xview.ui.view.dialog.custom.BaseDialogTest
import com.kiwilss.xview.ui.view.dialog.custom.BaseDialogTest2
import com.kiwilss.xview.ui.view.dialog.custom.FgDialog
import com.kiwilss.xview.ui.view.dialog.custom.PersonThree
import com.kiwilss.xview.ui.view.dialog.dialog_test.CenterDialog
import kotlinx.android.synthetic.main.activity_dialog.*

/**
 *@FileName: DialogActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/8/10
 * @desc   : {DESCRIPTION}
 */
class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)
        //PersonThree.Builder()
        btn_dialog_center.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.pw_center)
            //dialog.setCancelable(false)
            dialog.setCanceledOnTouchOutside(false)
            dialog.show()
        }
        btn_dialog_center2.setOnClickListener {
            val pp = FgDialog()
            //pp.isCancelable = true
            pp.show(supportFragmentManager,"fgdialog")
        }
        btn_dialog_centerL.setOnClickListener {
            val dialog = CenterDialog(this)
            dialog.show()
        }
        btn_dialog_centerX.setOnClickListener {
             val dialog = XDialog.Builder(this,R.layout.pw_center)
                 .gravity(Gravity.TOP)
                 .width(ViewGroup.LayoutParams.MATCH_PARENT)
                .build()
            dialog.setText(R.id.tv_pw_onetitle_title,"设置标题")
                .setOnClick(R.id.tv_pw_onetitle_cancel
                ) {
                    dialog.dismiss()
                }
           .show()

        }

        btn_dialog_default.setOnClickListener {
            BaseDialogTest().show(supportFragmentManager,"test")
        }
        btn_dialog_set.setOnClickListener {
            BaseDialogTest2().show(supportFragmentManager,"test2")
        }
        btn_dialog_tag.setOnClickListener {

        }

    }
}