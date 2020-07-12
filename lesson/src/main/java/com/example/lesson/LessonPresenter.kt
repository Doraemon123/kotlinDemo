package com.example.lesson

import com.example.core.http.EntityCallback
import com.example.core.http.HttpClient.get
import com.example.core.utils.Utils.toast
import com.example.lesson.entity.Lesson
import com.google.gson.reflect.TypeToken
import java.util.*

class LessonPresenter {
    companion object {
        private const val LESSON_PATH = "lessons" //const 编译器常量= static final
    }

    private var activity: LessonActivity? = null

    constructor(activity: LessonActivity) {
        this.activity = activity
    }

    private var lessons: List<Lesson> = ArrayList()

    private val type = object : TypeToken<List<Lesson?>?>() {}.type

    fun fetchData() {
        get(LESSON_PATH, type, object : EntityCallback<List<Lesson>> {
            override fun onSuccess(lessons: List<Lesson>) {
                this@LessonPresenter.lessons = lessons
                activity!!.runOnUiThread { activity!!.showResult(lessons) }
            }

            override fun onFailure(message: String?) {
                activity!!.runOnUiThread { toast(message!!) }
            }
        })
    }

    fun showPlayback() {
        val playbackLessons: MutableList<Lesson> = ArrayList()
//        for (lesson in lessons) { //in -- java中 for(lesson:lessons)
//            if (lesson.state === Lesson.State.PLAYBACK) {
//                playbackLessons.add(lesson)
//            }
//        }
        //1.
//        lessons.forEach({lesson->
//            if (lesson.state === Lesson.State.PLAYBACK) {
//                playbackLessons.add(lesson)
//            }
//        })
        //2.上面lambda简化写法
//        lessons.forEach {//只有一个参数时 参数也可以省略 默认it
//            if (it.state === Lesson.State.PLAYBACK) {
//                playbackLessons.add(it)
//            }
//        }
        //3.终极filter写法
        playbackLessons.addAll(lessons.filter { it.state === Lesson.State.PLAYBACK })

        activity!!.showResult(playbackLessons)
    }
}