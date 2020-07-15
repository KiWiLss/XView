package com.kiwilss.xview.ui.glide.glidej;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kiwilss.xview.R;
import com.kiwilss.xview.utils.LogUtils;
import com.kiwilss.xview.utils.glide.GlideUtil;

/**
 * @author : Lss Administrator
 * @FileName: GlideJActivity
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/11
 * @desc : {DESCRIPTION}
 */
public class GlideJActivity extends AppCompatActivity implements View.OnClickListener {

    String url = "http://guolin.tech/book.png";
    String url2 = "http://cn.bing.com/az/hprichbg/rb/AvalancheCreek_ROW11173354624_1920x1080.jpg";

    String url3 = "http://guolin.tech/test.gif";

    ImageView ivIcon;
    ImageView ivIcon2;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glidej);

         ivIcon = findViewById(R.id.iv_glidej_icon);
         ivIcon2 = findViewById(R.id.iv_glidej_icon2);
        findViewById(R.id.btn_glidej_load).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
//        RequestOptions options = new RequestOptions()
//                .centerCrop()
//                .circleCrop()
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher);
//                //.diskCacheStrategy(DiskCacheStrategy.NONE);
//
//        Glide.with(this).load(url)
////                .placeholder(R.mipmap.ic_launcher)
////                .error(R.mipmap.ic_launcher)
//                .apply(options)
//                .into(ivIcon);
        int dimens = getResources().getDimensionPixelSize(R.dimen.m10);
        LogUtils.e(dimens);
        //GlideUtil.loadImg2(this,url2,ivIcon);
        GlideUtil.loadImg(this,url2,ivIcon,R.mipmap.ic_launcher,R.mipmap.ic_launcher,true);

       //GlideUtil.loadImg(this,R.mipmap.ic_launcher,ivIcon2);
        GlideUtil.loadGif(this,url3,ivIcon2);
    }
}

