package com.example.core

import android.app.Application
import android.content.Context

class BaseApplication: Application() {//定义静态方法 不可用object修饰的方法，因为会直接生成单例 使用companian object 伴生对象

    companion object{
//        private lateinit var currentApplication: Context

//         fun currentApplica tion():Context { //java中 BaseApplication.Companion.currentApplication() 调用
//            return currentApplication
//        }
        @JvmStatic
        @get:JvmName("currentApplication")
        lateinit var currentApplication: Context
        private set  //设置外部不可以改变

    }

    override fun onCreate() {
        super.onCreate()
        currentApplication = this
    }


}