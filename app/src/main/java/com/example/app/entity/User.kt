package com.example.app.entity

class User :Any{//java继承Object  Kotlin继承Any
//    @JvmField
//    var username: String? = null 生成公开变量 不生成get/set
    var username: String? = null
    var password: String? = null
    var code: String? = null

    constructor()

    constructor(username: String?, password: String?,code: String?){
        this.username=username
        this.password=password
        this.code=code
    }
}