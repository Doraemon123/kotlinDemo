package com.example.lesson.entity

internal class Lesson constructor(var date: String?, var content: String?, var state: State?) {//internal 当前模块可见

//    //    private var date: String? = null  //private 修饰的 不能自动生成public的 get/set
//    var date: String? = null  //会自动生成get/set 不需要再写
//    var content: String? = null
//    var state: State? = null

//    init {
//        this.date = date
//        this.content = content
//        this.state = state
//    }

    enum class State {
        PLAYBACK {
            override fun stateName(): String {
                return "有回放"
            }
        },
        LIVE {
            override fun stateName(): String {
                return "正在直播"
            }
        },
        WAIT {
            override fun stateName(): String {
                return "等待中"
            }
        };

        abstract fun stateName(): String?
    }


//    fun getState(): State? {
//        return state
//    }
//
//    fun setState(state: State?) {
//        this.state = state
//    }
//
//    fun getDate(): String? {
//        return date
//    }
//
//    fun setDate(date: String?) {
//        this.date = date
//    }
//
//    fun getContent(): String? {
//        return content
//    }
//
//    fun setContent(content: String?) {
//        this.content = content
//    }

}