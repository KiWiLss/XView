package com.kiwilss.xview.design.behavioractivity

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kiwilss.xview.R

class HeaderZoomFg: Fragment() {

    companion object{
        fun instance(type: Int): HeaderZoomFg {
            val bundle = Bundle()
            bundle.putInt("type",type)
            val viewPagerFragment =
                HeaderZoomFg()
            viewPagerFragment.arguments = bundle
            return viewPagerFragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fg_header__zoom, container,false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val type = arguments?.getInt("type")
//        tv_fg_vp_text.text = "第${type}个fragment"
//        LogUtils.e("fragment---$type")
//        tv_fg_vp_text.setOnClickListener {
//            ActivityHelper.init(requireActivity())
//                .startActivityForResult(Intent(activity,HelpResultActivity::class.java),
//                object : ActivityHelper.Callback{
//                    override fun onActivityResult(resultCode: Int, data: Intent?) {
//                        LogUtils.e(resultCode)
//
//                    }
//
//                })
//        }
    }
}