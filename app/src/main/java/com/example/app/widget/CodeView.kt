package com.example.app.widget

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView
import com.example.app.R
import com.example.core.utils.Utils
import com.example.core.utils.dp2px
import java.util.*

class CodeView constructor(context: Context, attrs: AttributeSet? = null) : AppCompatTextView(context, attrs) {
    private val paint: Paint = Paint().apply {//apply 谁调用返回谁 let{it：}
        setAntiAlias(true)
        setStyle(Paint.Style.STROKE)
        setColor(getContext().getColor(R.color.colorAccent));
        setStrokeWidth(6f.dp2px()) //包级方法 直接调用 方法直接写在文件中 //java调用方法:UtilsKt.dp2px

    }

//    constructor(context:Context) :this(context,null)

    init {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, 18f)
        gravity = Gravity.CENTER
        setBackgroundColor(getContext().getColor(R.color.colorPrimary))
        setTextColor(Color.WHITE)

        // 或者 声明文件后 @file:JvmName("KtUtil") KtUtil.dp2px 防止方法名相同不知道正确的是哪一个
        updateCode()
    }


    //arrayof对基本类型会装箱 基本类型应使用 intArrayOf
    //Java:int float double long
    //Kotlin:Int Float Double Long

    //Java:Integer Float...
    //Kotlin:Int? Float?...
    private var codeList = arrayOf("kotlin",
            "android",
            "java",
            "http",
            "https",
            "okhttp",
            "retrofit",
            "tcp/ip")

    fun updateCode() {
        val random: Int = Random().nextInt(codeList.size)//数组长度不再是length
        val code = codeList[random]
        text = code
    }

    override fun onDraw(canvas: Canvas?) {
        canvas?.drawLine(0f, height.toFloat(), getWidth().toFloat(), 0f, paint);
        super.onDraw(canvas)
    }
}
