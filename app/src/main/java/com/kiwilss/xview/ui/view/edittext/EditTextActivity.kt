package com.kiwilss.xview.ui.view.edittext

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.EditText
import androidx.core.view.isVisible
import androidx.core.widget.*
import com.kiwilss.xview.R
import com.kiwilss.xview.base.BaseActivity
import com.kiwilss.xview.utils.LogUtils
import com.kiwilss.xview.utils.keyboard.KeyboardUtils
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
//        et_edittext_input.addTextChangedListener(object : TextWatcher{
//            override fun afterTextChanged(p0: Editable?) {
//                LogUtils.e("afterTextChanged----${p0.toString()}")
//            }
//
//            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {
//                LogUtils.e("beforeTextChanged----charSequence=${p0?.toString()}---start=$start------count=$count----after=$after")
//            }
//
//            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
//                val selectionStart = et_edittext_input.selectionStart
//                LogUtils.e("onTextChanged----charSequence=${p0?.toString()}---start=$start------count=$count----before=$before----select= $selectionStart")
//            }
//
//        })


        et_edittext_input.textWatch{

        }


        btn_edittext_change.setOnClickListener {
            et_edittext_input.setText("更换新内容")
        }
        btn_edittext_select.setOnClickListener {
            et_edittext_input.setSelection(et_edittext_input.text.length)
        }
    }

     var mHeight = 0
    override fun initInterface() {
        KeyboardUtils.registerSoftInputChangedListener(this,object :KeyboardUtils.OnSoftInputChangedListener{
            override fun onSoftInputChanged(height: Int) {
                LogUtils.e(height)
                if (height > 0){
                    mHeight = height
                }
                if (height <= 0){//键盘隐藏
                    if (ll_edittext_express.isVisible){
                        ll_edittext_bottom.visibility = View.VISIBLE
                    }else{
                        ll_edittext_bottom.visibility = View.GONE
                    }
                }else{//键盘显示
                    ll_edittext_bottom.visibility = View.VISIBLE
                    nsv_edittext_outer.fullScroll(NestedScrollView.FOCUS_DOWN)
                }
            }

        })

        tv_edittext_keyboard.setOnClickListener {
            KeyboardUtils.showSoftInput(this)
            ll_edittext_express.visibility = View.GONE
        }

        tv_edittext_express.setOnClickListener {
            //暂时表情,隐藏键盘
            KeyboardUtils.hideSoftInput(window)
            ll_edittext_express.visibility = View.VISIBLE
            ll_edittext_express.layoutParams.height = mHeight
        }

    }
}

//EditText相关
fun EditText.textWatch(textWatcher: SimpleTextWatcher.() -> Unit){


}

class SimpleTextWatcher(var editText: EditText){

    private var afterText : (Editable.() -> Unit)? = null
    fun afterTextChanged(){

    }

    init {
        editText.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
    }
}