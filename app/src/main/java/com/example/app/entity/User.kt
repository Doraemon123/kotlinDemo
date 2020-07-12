package com.example.app.entity
//直接在构造器中声明成员变量 这样的构造器中如果没有var修饰 则只是构造方法的形参，只有成员变量可以访问，成员方法无法访问
//data class 会自动生成类似于继承object的一些方法 copy方法 以及解构方法
data class User constructor(var username: String?, var password: String?,var code: String?) {//java继承Object  Kotlin继承Any
//    @JvmField
//    var username: String? = null 生成公开变量 不生成get/set

//    var username: String? = null
//    var password: String? = null
//    var code: String? = null

//    constructor(username: String?, password: String?,code: String?) : this() {
//        this.username=username
//        this.password=password
//        this.code=code
//    }

    constructor():this(null,null,null)
}