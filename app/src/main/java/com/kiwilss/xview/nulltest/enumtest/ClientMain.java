package com.kiwilss.xview.nulltest.enumtest;

import androidx.annotation.Keep;

/**
 * @author : Lss Administrator
 * @FileName: ClientMain
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
public class ClientMain {
    public static void main(String[] args) {
        //提取方法实现
        System.out.println(test(1));
        //枚举实现
        System.out.println(StatusEnum.of(1).getStatusDesc());

        System.out.println(Day.MONDAY.getDescription());
        //表驱动法
        System.out.println(MapTest.init().get(2));
        //表驱动法2
        //System.out.println(MapTest.getMaps(3));

        //测试git相关,change to master

    }


    /**根据不同的状态返回不同的值
     * @param status
     */
    @Keep
    public static String test(int status){
        if (status == 0){
            return "status == 0";
        }else if (status == 1){
            return "status == 1";
        }else if (status == 2){
            return "status == 2";
        }else {
            return "status == other";
        }
    }
}

