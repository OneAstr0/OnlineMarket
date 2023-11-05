package com.app.onlinemarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_password_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "")
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, pass)

                if (isAuth) {
                    Toast.makeText(this, "Вход осуществлён!", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()
                }
                else
                    Toast.makeText(this, "Пользователь не найден", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userPass.text.clear()
            }

        }



        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}