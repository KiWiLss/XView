package com.kiwilss.xview.ui.view.viewpager.vp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kiwilss.xview.R
import kotlinx.android.synthetic.main.fg_vp_test.*

/**
 *@FileName: VpTestFg
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/9/4
 * @desc   : {DESCRIPTION}
 */
class VpTestFg: Fragment() {

    companion object{
        fun newInstance(type: Int): VpTestFg{
            val bundle = Bundle()
            bundle.putInt("type",type)
            val fragment = VpTestFg()
            fragment.arguments = bundle
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fg_vp_test,container,false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val type = arguments?.getInt("type")
        tv_fg_vp_test_text.text = "this is fragment $type"

    }

}