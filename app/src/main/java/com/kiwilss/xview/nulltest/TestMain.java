package com.kiwilss.xview.nulltest;

import java.text.DecimalFormat;

/**
 * @author : Lss Administrator
 * @FileName: TestMain
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
public class TestMain {

    public static void main(String[] args) {
        System.out.println("-----------");
//        JavaNullTest javaNullTest = null;
//        System.out.println(NullFactory.get(null).getName());
//        javaNullTest = new JavaNullTest();
//        javaNullTest.setName("kity");
//        System.out.println(NullFactory.get(javaNullTest).getName());

        int num1 = 1290265;
        int num2 = 1023680;

        System.out.println(num1 /10000);
        System.out.println(num2 * 1.00 /10000);
        double v = num2 * 1.00 / 10000;
        System.out.println(String.format("%.2f",v));
        System.out.println(String.format("%.1f",v));
//        System.out.println(doubleToString2(v));
//        System.out.println(calculateProfit(v));
    }

    public static String doubleToString2(double value){
        DecimalFormat df = new DecimalFormat("#####0.00");
        return df.format(value);
    }

    /**
     * 保留double类型小数后两位，不四舍五入，直接取小数后两位 比如：10.1269 返回：10.12
     *
     * @param doubleValue
     * @return
     */
    public static String calculateProfit(double doubleValue) {
        // 保留4位小数
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.0000");
        String result = df.format(doubleValue);

        // 截取第一位
        String index = result.substring(0, 1);

        if (".".equals(index)) {
            result = "0" + result;
        }

        // 获取小数 . 号第一次出现的位置
        int inde = firstIndexOf(result, ".");

        // 字符串截断
        return result.substring(0, inde + 3);
    }

    /**
     * 查找字符串pattern在str中第一次出现的位置
     *
     * @param str
     * @param pattern
     * @return
     */
    public static int firstIndexOf(String str, String pattern) {
        for (int i = 0; i < (str.length() - pattern.length()); i++) {
            int j = 0;
            while (j < pattern.length()) {
                if (str.charAt(i + j) != pattern.charAt(j))
                    break;
                j++;
            }
            if (j == pattern.length())
                return i;
        }
        return -1;
    }

}

