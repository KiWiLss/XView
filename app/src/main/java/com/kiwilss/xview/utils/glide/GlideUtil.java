package com.kiwilss.xview.utils.glide;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.kiwilss.xview.R;

import java.io.File;

/**
 * @author : Lss kiwilss
 * @FileName: GlideUtil
 * @e-mail : kiwilss@163.com
 * @time : 2020/7/13
 * @desc : {DESCRIPTION}
 */
public class GlideUtil {

    /**
     *设置全局默认占位图,错位图
     */
    public static void loadImgDefault(Context context,String path,ImageView img,
                              boolean isCircle){
        if (context != null && img != null ){
            Glide.with(context).load(path).apply(initRequestOptions(initPlace(),initError(),isCircle)).into(img);
        }
    }
    public static void loadImgDefault(Context context,String path,ImageView img){
        if (context != null && img != null ){
            Glide.with(context).load(path).apply(initRequestOptions(initPlace(),initError(),false)).into(img);
        }
    }
    /**
     * 加载网络图片, 本地资源图片,本地文件
     * 设置占位图,错位图,圆形,圆角,
     * 是否跳过内存缓存,是否跳过磁盘缓存,一般使用默认的就可以了
     */
    public static void loadImg(Context context,String path,ImageView img,
                               int place, int error,boolean isCircle){
        if (context != null && img != null ){
            Glide.with(context).load(path).apply(initRequestOptions(place,error,isCircle)).into(img);
        }
    }
    /**
     * 不设置圆形
     */
    public static void loadImg(Context context,String path,ImageView img,
                               int place, int error){
        loadImg(context,path,img,place,error,false);
    }
    public static void loadImg(Context context,String path,ImageView img, int error){
        loadImg(context,path,img,0,error);
    }
    public static void loadImg(Context context,String path,ImageView img){
        loadImg(context,path,img,0);
    }

    /**
     * 加载本地资源图片
     */
    public static void loadImg(Context context,int path,ImageView img,
     int place, int error,boolean isCircle){
        if (context != null && img != null ){
            Glide.with(context).load(path).apply(initRequestOptions(place,error,isCircle)).into(img);
        }
    }
    public static void loadImg(Context context,int path,ImageView img,
                               int place, int error){
        loadImg(context,path,img,place,error,false);
    }
    public static void loadImg(Context context,int path,ImageView img,
                             int error){
        loadImg(context,path,img,0,error);
    }
    public static void loadImg(Context context,int path,ImageView img){
        loadImg(context,path,img,0);
    }
    /**
     * 加载本地文件
     */
    public static void loadImg(Context context, File path, ImageView img,
                               int place, int error, boolean isCircle){
        if (context != null && img != null ){
            Glide.with(context).load(path).apply(initRequestOptions(place,error,isCircle)).into(img);
        }
    }
    public static void loadImg(Context context,File path,ImageView img,
                               int place, int error){
        loadImg(context,path,img,place,error,false);
    }
    public static void loadImg(Context context,File path,ImageView img,
                               int error){
        loadImg(context,path,img,0,error);
    }
    public static void loadImg(Context context,File path,ImageView img){
        loadImg(context,path,img,0);
    }
    @SuppressLint("CheckResult")
    public static RequestOptions initRequestOptions(int place, int error, boolean isCircle){
        return initRequestOptions(place,error,isCircle,null);
    }

    public static RequestOptions initRequestOptions(int place, int error){
        return initRequestOptions(place,error,false);
    }

    public static RequestOptions initRequestOptions(int error){
        return initRequestOptions(0,error,false);
    }

    @SuppressLint("CheckResult")
    public static RequestOptions initRequestOptions(int place, int error, boolean isCircle,
                                                    Transformation<Bitmap> transformation){
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.centerCrop();
        if (isCircle){
            requestOptions.circleCrop();
        }
        if (place != 0){
            requestOptions.placeholder(place);
        }
        if (error != 0){
            requestOptions.error(error);
        }
        if (transformation != null){
            requestOptions.transform(transformation);
        }
        return requestOptions;
    }
    /**
     * 加载圆角图片,四个角都是圆角
     */
    public static void loadImg(Context context, String path, ImageView img,
                               int place, int error, int round){
        if (context != null && img != null ){
            MultiTransformation<Bitmap> transformation = new MultiTransformation<>(new CenterCrop(), new RoundedCorners(round));
            Glide.with(context).load(path).apply(initRequestOptions(place,error,false,transformation)).into(img);
        }
    }

    public static void loadImgRound(Context context, String path, ImageView img,
                              int error, int round){
        loadImg(context,path,img,0,error,round);
    }
    public static void loadImgRound(Context context, String path, ImageView img,
                                    int round){
        loadImgRound(context,path,img,0,round);
    }

    public static void loadImgDefault(Context context, String path, ImageView img,
                                int round){
        if (context != null && img != null ){
            MultiTransformation<Bitmap> transformation = new MultiTransformation<>(new CenterCrop(), new RoundedCorners(round));
            Glide.with(context).load(path).apply(initRequestOptions(initPlace(),initError(),false,transformation)).into(img);
        }
    }

    /**
     *加载本地资源图片圆角
     */
    public static void loadImg(Context context, int path, ImageView img,
                               int place, int error, int round){
        if (context != null && img != null ){
            MultiTransformation<Bitmap> transformation = new MultiTransformation<>(new CenterCrop(), new RoundedCorners(round));
            Glide.with(context).load(path).apply(initRequestOptions(place,error,false,transformation)).into(img);
        }
    }
    /**
     *加载本地文件图片圆角
     */
    public static void loadImg(Context context, File path, ImageView img,
                               int place, int error, int round){
        if (context != null && img != null ){
            MultiTransformation<Bitmap> transformation = new MultiTransformation<>(new CenterCrop(), new RoundedCorners(round));
            Glide.with(context).load(path).apply(initRequestOptions(place,error,false,transformation)).into(img);
        }
    }
    /**
     *初始化默认占位图
     */
    public static int initPlace(){
        return R.mipmap.ic_launcher;
    }
    public static int initError(){
        return R.mipmap.ic_launcher;
    }

    /**
     * 加载 gif 图
     */
    public static void loadGif(Context context, String path, ImageView img){
        Glide.with(context).asGif().load(path).into(img);
    }
    //跳过内存缓存
    public void loadImageViewCache(Context context, String path, ImageView img) {
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .skipMemoryCache(true);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    //设置下载优先级
    public void loadImageViewPriority(Context context, String path, ImageView img) {
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .priority(Priority.HIGH);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
    //设置缓存策略
    public void loadImageViewDiskCache(Context context, String path, ImageView img) {
        if (img!=null && !TextUtils.isEmpty(path)){
            RequestOptions requestOptions = new RequestOptions()
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context).load(path).apply(requestOptions).into(img);
        }
    }
//    public static String getCacheSize() {
////        try {
////            assert App.app != null;
////            return getFormatSize(getFolderSize(new File(App.app.getCacheDir() + "/" + GlideCatchConfig.GLIDE_CARCH_DIR)));
////        } catch (Exception e) {
////            e.printStackTrace();
////            return "获取失败";
////        }
//    }



    //设置缩略图支持
    public void loadImageViewThumbnail(Context mContext, String path, ImageView mImageView) {
        Glide.with(mContext).load(path).thumbnail(0.1f).into(mImageView);
    }
    //清理磁盘缓存
    public static void GuideClearDiskCache(Context mContext) {
        //理磁盘缓存 需要在子线程中执行
        Glide.get(mContext).clearDiskCache();
    }
    //清理内存缓存
    public static void GuideClearMemory(Context mContext) {
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(mContext).clearMemory();
    }

    /**
     * 清理所有缓存,在子线程中执行
     */
    public void clear(Context context){
        //理磁盘缓存 需要在子线程中执行
        Glide.get(context).clearDiskCache();
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(context).clearMemory();
    }


}
