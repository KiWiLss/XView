package com.kiwilss.xview.utils.test

import com.kiwilss.xview.R
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

/**
 *@FileName: OpertorTest
 *@author : Lss Administrator
 * @e-mail : kiwilss@163.com
 * @time   : 2020/12/1
 * @desc   : {DESCRIPTION}
 */
object OperatorTest {
    @JvmStatic
    fun main(args: Array<String>) {
        letTest()
        println("-------------------")
        withTest()
        println("-------------------")
        runTest()
        println("-------------------")
        applyTest()
        println("-------------------")
        alsoTest()


    }

   private fun letTest(){
       val str = "boss"
       val result = str.let {
           println(this)
           println(it)
            69
       }
       println(result)
   }

    fun withTest(){
        val str = "boss"
        val result = with(str){
            println(this)
            99
        }
        println(result)
    }

    private fun runTest(){
        val str = "boss"
        val result = str.run {
            println(this)
            66
        }
        println(result)
    }
    fun runTest2(){
        val str = "boss"
        kotlin.run {
            println(this)
            44
        }
    }

    private fun applyTest(){
        val str = "boss"
        val result = str.apply {
            println(this)
        }.length
        println(result)
    }

    private fun alsoTest(){
        val str = "boss"
        val result = str.also {
            println(it)
        }.length
        println(result)
    }
}

