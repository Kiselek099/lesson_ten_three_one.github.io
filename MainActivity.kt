package com.example.project_num_tenfour

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var textET:EditText
    lateinit var textTV:TextView
    lateinit var saveBTN:Button
    lateinit var deleteBTN:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textET=findViewById(R.id.textET)
        textTV=findViewById(R.id.textTV)
        saveBTN=findViewById(R.id.saveBTN)
        deleteBTN=findViewById(R.id.deleteBTN)
        saveBTN.setOnClickListener { view->
            textTV.text=textET.text
        }
        deleteBTN.setOnClickListener { view->
            Snackbar.make(view,"Подтвердите удаление",
                Snackbar.LENGTH_LONG).setAction("Удалить"){
                    textTV.text=""
                Snackbar.make(view,"Данные удалены",Snackbar.LENGTH_SHORT).show()
            }.show()
        }
    }
}