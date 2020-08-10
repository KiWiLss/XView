package com.kiwilss.xview.utils.test

/**
 * @author : Lss Administrator
 * @FileName: BuilderTest
 * @e-mail : kiwilss@163.com
 * @time : 2020/8/10
 * @desc : {DESCRIPTION}
 */
class BuilderTest private constructor(builder: Builder) {
    private val name: String?
    private val age: Int

    class Builder {
         var name: String? = null
         var age = 0
        fun name(name: String?): Builder {
            this.name = name
            return this
        }

        fun age(age: Int): Builder {
            this.age = age
            return this
        }

        fun build(): BuilderTest {
            return BuilderTest(this)
        }
    }

    init {
        name = builder.name
        age = builder.age
    }
}