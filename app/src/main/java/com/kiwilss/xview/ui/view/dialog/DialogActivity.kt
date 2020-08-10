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

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.view.dialog.custom.PersonThree
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

    }
}