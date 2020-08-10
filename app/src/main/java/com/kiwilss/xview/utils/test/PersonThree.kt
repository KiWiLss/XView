package com.kiwilss.xview.utils.test

class PersonThree(val builder: Builder) {
    //固定不变的对象，一般变量需要声明为 final
    private val mName //必选，final 类型需要在 构造器中初始化，不允许不初始化它的构造器存在
            : String
    private val mLocation //可选
            : String?
    private val mJob //可选
            : String?
    private val mHabit //可选
            : String?

    /**
     * PersonTree 的静态内部类，成员变量和 PersonTree 的一致
     */
    class Builder
    /**
     * 含必选参数的构造方法
     * @param name
     */(//必选，final 类型需要在 构造器中初始化，不允许不初始化它的构造器存在
         val mName: String
    ) {
         var mLocation //可选
                : String? = null
         var mJob //可选
                : String? = null
         var mHabit //可选
                : String? = null

        fun setLocation(location: String?): Builder {
            mLocation = location
            return this
        }

        fun setJob(job: String?): Builder {
            mJob = job
            return this
        }

        fun setHabit(habit: String?): Builder {
            mHabit = habit
            return this
        }

        /**
         * 最终构建方法，返回一个 PersonTree 对象，参数是当前 Builder 对象
         * @return
         */
        fun build(): PersonThree {
            return PersonThree(this)
        }

    }

    /**
     * 构造方法的参数是它的 静态内部类，使用静态内部类的变量一一赋值
     * @param builder
     */
    init {
        mName = builder.mName
        mLocation = builder.mLocation
        mJob = builder.mJob
        mHabit = builder.mHabit
    }
}