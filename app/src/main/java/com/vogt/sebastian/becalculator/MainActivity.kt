package com.vogt.sebastian.becalculator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val bc: BECalculator = BECalculator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        referenceValue_editText.requestFocus()



        be_switch.setOnCheckedChangeListener { buttonView, isChecked ->
            bc.be = isChecked
        }



        compute_button.setOnClickListener {
            if(checkFields()) {
                bc.referenceValue = referenceValue_editText.text.toString().toInt()
                bc.carboHydrateReferenceValue = carboHydrateReferenceValue_editText.text.toString().toDouble()
                bc.amount = amount_editText.text.toString().toInt()
                bc.compute()


                //Toast.makeText(this, "${Helper.decimalFormat(bc.result, 1)} ${bc.getMeasure()}", Toast.LENGTH_SHORT).show()


                val resultIntent: Intent = Intent(this, ResultActivity::class.java)
                resultIntent.putExtra("BC", bc)

                startActivity(resultIntent)
            }
        }
    }


    private fun checkFields(): Boolean {
        var ret: Boolean = true
        var fields: List<EditText> = listOf(
            referenceValue_editText,
            carboHydrateReferenceValue_editText,
            amount_editText
        )

        for(item in fields) {
            if(item.text.toString() == "") {
                item.error = getString(R.string.ErrorFillIn)
                ret = false
            }
        }
        return ret
    }
}
