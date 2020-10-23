package com.kiwilss.xview.ui.copy;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.kiwilss.xview.R;
import com.kiwilss.xview.nulltest.enumtest.Coupon;
import com.kiwilss.xview.utils.LogUtils;
import com.kiwilss.xview.utils.StringLengthsUtil;

/**
 * @author : Lss Administrator
 * @FileName: MTActivity
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/27
 * @desc : {测试各种难以处理的布局}
 */
public class MTActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rl_test);
        View btnCamera = findViewById(R.id.btn_rl_camera);
        btnCamera.setOnClickListener(new View.OnClickListener() {
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

        btnCamera.post(new Runnable() {
            @Override
            public void run() {
                int height = btnCamera.getHeight();
                LogUtils.e("height= " + height);
            }
        });

        //


        String name = "不确定宽度,,度,不确定字数--不确定宽度,,度,不确定字数--不确定宽度,,度,不确定不确定宽度,,度,不确定字数--不确定宽度,,度,不确定字数--不确定宽度,,度,不确定字数哈哈哈";
        TextView tvIcon = (TextView) findViewById(R.id.tv_rl_test_icon);
        tvIcon.setText(name);

        tvIcon.setOnClickListener(view -> {
            String newName = tvIcon.getText().toString();
            int lineCount = tvIcon.getLineCount();
            String singleLines = StringLengthsUtil.getSingleLines(tvIcon, 1);
            LogUtils.e(singleLines);
        });


//        Drawable drawable = ContextCompat.getDrawable(this,R.mipmap.female_icon);
//        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//        ImageSpan imgSpan = new ImageSpan(drawable);
//        SpannableString spannableString = new SpannableString(name);
//        spannableString.setSpan(imgSpan, name.length()-1 , name.length() , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        tvIcon.setText(spannableString);

    }
}

