package com.kiwilss.xview.ui.view.dialog.custom;

public class PersonThree {
    //固定不变的对象，一般变量需要声明为 final
    private final String mName;     //必选，final 类型需要在 构造器中初始化，不允许不初始化它的构造器存在
    private String mLocation;       //可选
    private String mJob;            //可选
    private String mHabit;          //可选


    /**
     * 构造方法的参数是它的 静态内部类，使用静态内部类的变量一一赋值
     * @param builder
     */
    public PersonThree(Builder builder) {
        this.mName = builder.mName;
        this.mLocation = builder.mLocation;
        this.mJob = builder.mJob;
        this.mHabit = builder.mHabit;
    }

    /**
     * PersonTree 的静态内部类，成员变量和 PersonTree 的一致
     */
    public static class Builder{
        private final String mName;     //必选，final 类型需要在 构造器中初始化，不允许不初始化它的构造器存在
        private String mLocation;       //可选
        private String mJob;            //可选
        private String mHabit;          //可选

        /**
         * 含必选参数的构造方法
         * @param name
         */
        public Builder(String name) {
            mName = name;
        }

        public Builder setLocation(String location) {
            mLocation = location;
            return this;
        }

        public Builder setJob(String job) {
            mJob = job;
            return this;
        }

        public Builder setHabit(String habit) {
            mHabit = habit;
            return this;
        }

        /**
         * 最终构建方法，返回一个 PersonTree 对象，参数是当前 Builder 对象
         * @return
         */
        public PersonThree build(){
            return new PersonThree(this);
        }
    }
}
