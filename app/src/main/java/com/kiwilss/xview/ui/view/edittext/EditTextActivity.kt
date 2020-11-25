package com.kiwilss.xview.ui.view.edittext

import android.text.Editable
import android.text.TextWatcher
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import kotlinx.android.synthetic.main.activity_edittext.*

/**
 *@FileName: EditTextActivity
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/11/25
 * @desc   : {edittext监听相关操作}
 */
class EditTextActivity : BaseActivity(R.layout.activity_edittext) {
    override fun initData() {
    }

    override fun initEvent() {
        et_edittext_input.setOnClickListener {
            val selectionStart = et_edittext_input.selectionStart
            LogUtils.e("OnClickListener----$selectionStart")
        }
        et_edittext_input.setOnLongClickListener {
            val selectionStart = et_edittext_input.selectionStart
            LogUtils.e("OnLongClickListener----$selectionStart")
            false
        }
        et_edittext_input.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                LogUtils.e("afterTextChanged----${p0.toString()}")
            }

            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {
                LogUtils.e("beforeTextChanged----charSequence=${p0?.toString()}---start=$start------count=$count----after=$after")
            }

            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                val selectionStart = et_edittext_input.selectionStart
                LogUtils.e("onTextChanged----charSequence=${p0?.toString()}---start=$start------count=$count----before=$before----select= $selectionStart")
            }

        })
        btn_edittext_change.setOnClickListener {
            et_edittext_input.setText("更换新内容")
        }
        btn_edittext_select.setOnClickListener {
            et_edittext_input.setSelection(et_edittext_input.text.length)
        }
    }

    override fun initInterface() {
    }
}