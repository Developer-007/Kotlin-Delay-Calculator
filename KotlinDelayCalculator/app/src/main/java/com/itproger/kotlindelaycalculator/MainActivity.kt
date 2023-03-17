package com.itproger.kotlindelaycalculator

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eTempo: EditText = findViewById(R.id.tempoEnter)
        val delayTime: TextView = findViewById(R.id.delayCalc)
        val radioGroup: RadioGroup = findViewById(R.id.radioGroup)
        var whole: RadioButton = findViewById(R.id.whole)
        var half: RadioButton = findViewById(R.id.half)
        var quarter: RadioButton = findViewById(R.id.quarter)
        var eighth: RadioButton = findViewById(R.id.eighth)
        var sixteenth: RadioButton = findViewById(R.id.sixteenth)
        val calcButton: Button = findViewById(R.id.calc_button)

        try {
            calcButton.setOnClickListener {
                var tempo: Float = (eTempo.getText().toString()).toFloat()
                var delaytime: Float? = null
                val checkedButtonIndex = radioGroup.getCheckedRadioButtonId()

                when(checkedButtonIndex){
                    R.id.whole -> delaytime=240000/tempo/1
                    R.id.half -> delaytime=240000/tempo/2
                    R.id.quarter -> delaytime=240000/tempo/4
                    R.id.eighth -> delaytime=240000/tempo/8
                    R.id.sixteenth -> delaytime=240000/tempo/16
                }
                delayTime.setText(delaytime.toString())
            }
        } catch (e: KotlinNullPointerException) {
            showWarning()
        }
    }
    private fun showWarning(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Ошибка")
        builder.setMessage("Вы не ввели темп")
        builder.setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  })
        builder.show()
    }

}