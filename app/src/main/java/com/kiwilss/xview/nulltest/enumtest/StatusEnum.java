package com.kiwilss.xview.nulltest.enumtest;

/**
 * @author : Lss Administrator
 * @FileName: StatusEnum
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/4
 * @desc : {DESCRIPTION}
 */
enum StatusEnum {
    ONE(1,"status == 1"),
    TWO(2,"status == 2")
    ;

    private int status;
    private String statusDesc;

    StatusEnum(int status, String statusDesc) {
        this.status = status;
        this.statusDesc = statusDesc;
    }

    static StatusEnum of(int status){
        for (StatusEnum statusEnum : StatusEnum.values()) {
            if (statusEnum.status == status){
                return statusEnum;
            }
        }
        return null;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }
}
