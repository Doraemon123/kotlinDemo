//@注解对象
@file:JvmName("KtUtil")

package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

val displayMetrics = Resources.getSystem().displayMetrics

//fun dp2px(dp: Float): Float {                      //包级方法
//    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
//}

//扩展函数 1.如与原类中的方法名重复 还以原方法执行
//如子类中扩展方法与父类的扩展方法相同 各执行各的 等于在声明处生成了静态方法 类型参数为扩展方法所属类
//
fun Float.dp2px() : Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, this, displayMetrics)
}

object Utils {
    //object 关键字修饰的 内部的方法似静态方法 其实是一个单例对象的方法 java中用 Utils.INSTANCE.toast("");调用
//    public fun toast(string: String) {
//        toast(string, Toast.LENGTH_SHORT)
//    }
    //参数默认值 只有一个参数 也可以使用 等于有一个单参的方法
    @JvmOverloads
    fun toast(string: String, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(BaseApplication.currentApplication, string, duration).show()
    }
}