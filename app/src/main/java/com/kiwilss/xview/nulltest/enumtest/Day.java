package com.kiwilss.xview.nulltest.enumtest;

/**
 * @author : Lss Administrator
 * @FileName: Day
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
enum Day {
    MONDAY("1"),TUESDAY("2"),
    WEDNESDAY("3"),THURSDAY("4"),
    FRIDAY("5"),SATURDAY("6"),SUNDAY("7");

   private String description;

    Day(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
