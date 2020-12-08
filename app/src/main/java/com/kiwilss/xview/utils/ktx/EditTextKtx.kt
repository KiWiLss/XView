package com.kiwilss.xview.utils.ktx

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

/**
 *@FileName: EditTextKtx
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/8
 * @desc   : {DESCRIPTION}
 */
//EditText输入监听
fun EditText.textWatch(textWatcher: SimpleTextWatcher.() -> Unit){
    val simpleTextWatcher = SimpleTextWatcher(this)
    textWatcher.invoke(simpleTextWatcher)
}

class SimpleTextWatcher(private var editText: EditText){

    private var afterText : (Editable?.() -> Unit)? = null
    fun afterTextChanged(afterText : (Editable?.() -> Unit)?){
        this.afterText = afterText
    }

    private var beforeText: ((s: CharSequence?, start: Int, count: Int, after: Int) -> Unit)? = null
    fun beforeTextChanged(beforeText: ((s: CharSequence?, start: Int, count: Int, after: Int) -> Unit)?){
        this.beforeText = beforeText
    }

    private var onTextChange: ((p0: CharSequence?, p1: Int, p2: Int, p3: Int) -> Unit)? = null
    fun onTextChanged(onTextChange: ((p0: CharSequence?, p1: Int, p2: Int, p3: Int) -> Unit)?){
        this.onTextChange = onTextChange
    }

    init {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                afterText?.invoke(p0)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                beforeText?.invoke(p0,p1,p2,p3)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                onTextChange?.invoke(p0,p1,p2,p3)
            }

        })
    }
}