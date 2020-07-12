package com.example.lesson

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseViewHolder
import com.example.lesson.LessonAdapter.LessonViewHolder
import com.example.lesson.entity.Lesson
import java.util.*

class LessonAdapter : RecyclerView.Adapter<LessonViewHolder>() {
    private var list: List<Lesson> = ArrayList()
    internal fun updateAndNotify(list: List<Lesson>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonViewHolder {
        return LessonViewHolder.onCreate(parent)
    }

    override fun onBindViewHolder(holder: LessonViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    /**
     * 静态内部类
     */
    class LessonViewHolder internal constructor(itemView: View) : BaseViewHolder(itemView) {
        internal fun onBind(lesson: Lesson) {
//            var date = lesson.date
//            if (date == null) {
//                date = "日期待定"
//            }
            //lesson.date?:"日期待定" :lesson.date是空的吗 是 赋值冒号后面的
            setText(R.id.tv_date, lesson.date?:"日期待定")
            setText(R.id.tv_content, lesson.content!!)
            val state = lesson.state
            //不用再使用判空
            lesson.state?.let {     //run{this }
                setText(R.id.tv_state, it.stateName()!!)
                var colorRes = when (it) {//when可以有返回值
                    Lesson.State.PLAYBACK -> {

                        // 即使在 {} 中也是需要 break 的。
                        R.color.playback
                    }
                    Lesson.State.LIVE -> R.color.live
                    Lesson.State.WAIT -> R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<View>(R.id.tv_state).setBackgroundColor(backgroundColor)

            }
            if (state != null) {
                setText(R.id.tv_state, state.stateName()!!)
                var colorRes = when (state) {//when可以有返回值
                    Lesson.State.PLAYBACK -> {

                        // 即使在 {} 中也是需要 break 的。
                        R.color.playback
                    }
                    Lesson.State.LIVE -> R.color.live
                    Lesson.State.WAIT -> R.color.wait
                }
                val backgroundColor = itemView.context.getColor(colorRes)
                getView<View>(R.id.tv_state).setBackgroundColor(backgroundColor)
            }
        }

        companion object {
            fun onCreate(parent: ViewGroup): LessonViewHolder {
                return LessonViewHolder(LayoutInflater
                        .from(parent.context)
                        .inflate(R.layout.item_lesson, parent, false))
            }
        }
    }
}