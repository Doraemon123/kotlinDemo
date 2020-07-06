package com.example.app

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.app.entity.User
import com.example.app.widget.CodeView
import com.example.core.utils.CacheUtils
import com.example.core.utils.Utils
import com.example.lesson.LessonActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private val usernameKey: String = "username"
    private val passwordKey: String = "password"//不可空类型 无？

//    private var et_username: EditText? = null//空安全设计 可空类型
//    private var et_password: EditText? = null

    private lateinit var et_username: EditText//延迟初始化
    private lateinit var et_password: EditText//延迟初始化
    private lateinit var et_code: EditText//延迟初始化

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et_username = findViewById(R.id.et_username)
        et_password = findViewById(R.id.et_password)
        et_code = findViewById(R.id.et_code)
//        et_username.setText("qewr")//可空类型时 报错
//        et_username!!.setText("qewr")//强行调用 会报空
//        et_username?.setText("qwer")//安全调用 判断是否为空不为空再执行 不报错
        et_username.setText(CacheUtils.get(usernameKey))//延迟初始化 可直接使用
        et_password.setText(CacheUtils.get(passwordKey))

//        val btn_login:Button?= findViewById<Button?>(R.id.btn_login)
        //其他平台类 平台类型 未声明是否可空
        val btn_login = findViewById<Button>(R.id.btn_login)
//        val findViewById = getDelegate().findViewById<Button>(R.id.btn_login)
        val img_code = findViewById<CodeView>(R.id.code_view)
        btn_login.setOnClickListener(this)
        img_code.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v is CodeView) {//负责判断和转型 只能转换
//            val codeView:CodeView=v as CodeView//不需要再次转换
            v.updateCode()
        } else if (v is Button) {
            login()
        }
    }

    private fun login() {
//        et_username.text = Editable.Factory.getInstance().newEditable("hahha")
//        val username:String = et_username.getText().toString()
        val username: String = et_username.text.toString()//其实还是调用getText()
        val password: String = et_password.text.toString()
        val code: String = et_code.text.toString()
        //没有new
        val user = User(username, password, code)
        if (verify(user)) {
            CacheUtils.save(usernameKey, username)
            CacheUtils.save(passwordKey, password)
            startActivity(Intent(this, LessonActivity::class.java))
        }
    }

    private fun verify(user: User): Boolean {
        if (user.username == null || user.username!!.length < 4) {//报错解决
            Utils.toast("用户名不合法")
            return false
        }
        if (user.password == null || user.password!!.length < 4) {//报错解决
            Utils.toast("密码不合法")
            return false
        }
        return true
    }

}