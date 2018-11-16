package com.example.lokew.moviereview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chkbxMyCheckBox.setOnClickListener(View.OnClickListener {
            if (chkbxMyCheckBox.isChecked == true) {
                chkbxCheckBox2.setVisibility(View.VISIBLE)
                chkbxCheckBox3.setVisibility(View.VISIBLE)
            }
            else {
                chkbxCheckBox2.setVisibility(View.INVISIBLE)
                chkbxCheckBox3.setVisibility(View.INVISIBLE)
            }
        })
    }


    fun RadioStore(v: View) {
        if (v is RadioButton) {
            val language: RadioButton = findViewById(R.id.langName)
            val checked = v.isChecked

            when (v.getId()) {R.id.rbtnButton1 ->
                if (checked) {
                    language.text = "English"
                }
                R.id.rbtnButton2 ->
                    if (checked) {
                        language.text = "Chinese"
                    }
                R.id.rbtnButton3 ->
                    if (checked) {
                        language.text = "Malay"
                    }
                R.id.rbtnButton4 ->
                    if (checked) {
                        language.text = "Tamil"
                    }
            }
        }
    }

    open fun CheckBoxClicked(v: View) {
        if (v is CheckBox) {
            val checked: Boolean = v.isChecked
            val chkboxViolence = findViewById(R.id.chkbxCheckBox2) as CheckBox
            val chkboxCoarse = findViewById(R.id.chkbxCheckBox3) as CheckBox
            val checkOG : CheckBox = findViewById(R.id.chkbxMyCheckBox)
            val checkViolence : CheckBox = findViewById(R.id.chkbxCheckBox2)
            val checkCoarse : CheckBox = findViewById(R.id.chkbxCheckBox3)

            when (v.id) {
                R.id.chkbxMyCheckBox -> {
                    if (checked) {
                        chkboxViolence.setVisibility(View.VISIBLE)
                        chkboxCoarse.setVisibility(View.VISIBLE)
                        checkOG.text = "Suitable for all ages = False" + "\n" + "Reason" + "\n"
                    }
                    else {
                        chkboxViolence.setVisibility(View.INVISIBLE)
                        chkboxCoarse.setVisibility(View.INVISIBLE)
                        checkOG.text = "Suitable for all ages = True"
                    }
                }

                R.id.chkbxCheckBox2 -> {
                    if (checked) {
                        checkViolence.text = "Violence"
                    }
                    else {
                        checkViolence.text = "    "
                    }
                }

                R.id.chkbxCheckBox3 -> {
                    if (checked) {
                        checkCoarse.text = "Bad Language"
                    }
                    else {
                        checkCoarse.text = "   "
                    }
                }
            }
        }
    }

    fun onBtnClick(v: View) {
        val name = findViewById(R.id.name) as EditText
        val overview = findViewById(R.id.desc) as EditText
        val relDate = findViewById(R.id.date) as EditText
        val language: RadioButton = findViewById(R.id.langName)
        val checkOG = findViewById(R.id.chkbxMyCheckBox) as CheckBox
        val chkboxViolence = findViewById(R.id.chkbxCheckBox2) as CheckBox
        val chkboxCoarse = findViewById(R.id.chkbxCheckBox3) as CheckBox

        if (TextUtils.isEmpty(name.getText()) or TextUtils.isEmpty(desc.getText()) or TextUtils.isEmpty(date.getText())) {

            name.setError("Required!");
            desc.setError("Required!");
            date.setError("Required!");
        } else {

            Toast.makeText(
                this,
                "Title = " + name.text
                        + "\n" + "Overview = " + overview.text
                        + "\n" + "Release Date = " + relDate.text
                        + "\n" + "Language = " + language.text
                        + "\n" + "Suitable for all ages: " + chkbxMyCheckBox.isChecked + "\n" + chkboxViolence.text + "\n" + chkboxCoarse.text,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
