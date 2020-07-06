@file:JvmName("KtUtil")

package com.example.core.utils

import android.content.res.Resources
import android.util.TypedValue
import android.widget.Toast
import com.example.core.BaseApplication

val displayMetrics = Resources.getSystem().displayMetrics

fun dp2px(dp: Float): Float {                      //包级方法
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics)
}

object Utils {//object 关键字修饰的 内部的方法似静态方法 其实是一个单例对象的方法 java中用 Utils.INSTANCE.toast("");调用
    public fun toast(string: String) {
        toast(string, Toast.LENGTH_SHORT)
    }

    public fun toast(string: String, duration: Int) {
        Toast.makeText(BaseApplication.currentApplication(), string, duration).show()
    }
}