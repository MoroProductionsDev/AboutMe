package com.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingComponent
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding //  binding object (wil bind layout with activity main)
    lateinit var editText : EditText
    lateinit var nicknameTextview: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //findViewById<Button>(R.id.id_btn_done).setOnClickListener {
        //    addNickName(it)  // it is the btn_done
       //}
        binding.idBtnDone.setOnClickListener{
            addNickName(it)  // it is the btn_done
        }

        /*
        editText = findViewById(R.id.id_textfield_nickname)
        nicknameTextview = findViewById(R.id.id_textview_nickname)
        */
    }

    private fun addNickName(view : View) {
        // nicknameTextview.text = editText.text  // set nickname texfield.text nickname to textview.text
        // editText.visibility = View.GONE // nickname texfield
        // view.visibility = View.GONE  // done button
        // nicknameTextview.visibility = View.VISIBLE  // nickname textview
        binding.idTextviewNickname.text = editText.text
        binding.idTextfieldNickname.visibility = View.GONE
        binding.idBtnDone.visibility = View.GONE
        binding.idTextviewNickname.visibility = View.VISIBLE


        // hide the keyboard
        val board = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        board.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
