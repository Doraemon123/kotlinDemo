package com.example.core

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.recyclerview.widget.RecyclerView

/**
 * 无abstract关键字修饰的类 不可以被继承 默认都是final
 * abs
 */
abstract class BaseViewHolder : RecyclerView.ViewHolder {
    constructor(itemView: View) : super(itemView)

    @SuppressLint("UseSparseArrays")
    private val viewHashMap: MutableMap<Int, View> = HashMap()

    @SuppressWarnings("unchecked")
    protected fun <T : View> getView(@IdRes id: Int): T {
        var view: View? = viewHashMap.get(id)
        if (view == null) {
            view = itemView.findViewById(id)
            viewHashMap.put(id, view)
        }
        return view as T
    }

    protected fun setText(@IdRes id: Int, @Nullable text: String) {
        ((getView(id)) as TextView).text = text

    }
}