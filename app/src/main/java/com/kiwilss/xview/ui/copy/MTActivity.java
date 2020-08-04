package com.kiwilss.xview.ui.copy;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kiwilss.xview.R;
import com.kiwilss.xview.nulltest.enumtest.Coupon;
import com.kiwilss.xview.utils.LogUtils;

/**
 * @author : Lss Administrator
 * @FileName: MTActivity
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/27
 * @desc : {DESCRIPTION}
 */
public class MTActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rl_test);
         findViewById(R.id.btn_rl_camera).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
//                 Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                 intent.putExtra("android.intent.extras.CAMERA_FACING", 2); // 调用前置摄像头
//                 startActivityForResult(intent, 1);
                 Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                 intent.putExtra("camerasensortype", 2); // 调用前置摄像头
                 intent.putExtra("autofocus", true); // 自动对焦
                 intent.putExtra("fullScreen", false); // 全屏
                 intent.putExtra("showActionIcons", false);
                 startActivityForResult(intent, 2);
             }
         });

        Coupon coupon = new Coupon(9,"hello");
        LogUtils.e(coupon.isBeanShort());

    }
}

