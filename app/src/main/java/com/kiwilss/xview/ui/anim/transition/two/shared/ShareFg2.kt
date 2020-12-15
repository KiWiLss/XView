package com.kiwilss.xview.ui.anim.transition.two.shared

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kiwilss.xview.R
import com.kiwilss.xview.ui.anim.transition.bean.Sample
import kotlinx.android.synthetic.main.fg_share_element2.*

/**
 *@FileName: ShareFg2
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/15
 * @desc   : {DESCRIPTION}
 */
class ShareFg2: Fragment() {

    companion object{
        fun newInstance(sample: Sample): ShareFg2{
            val bundle = Bundle()
            bundle.putSerializable(ShareFg1.EXTRA_SAMPLE,sample)
            val fg = ShareFg2()
            fg.arguments = bundle
            return fg
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fg_share_element2,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sample: Sample = arguments?.getSerializable(ShareFg1.EXTRA_SAMPLE) as Sample

        square_blue.setColorFilter(sample.color)

    }


}