package com.vogt.sebastian.becalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // logo in actionbar
/*        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.becalc_logo)
        supportActionBar?.setDisplayUseLogoEnabled(true)*/

        val myIntent = intent

        val bc: BECalculator = intent.getSerializableExtra("BC") as BECalculator

        amount_textView.text = "${bc.amount} g ${getString(R.string.amountContained)}"
        result_textView.text = "${Helper.decimalFormat(bc.result, 1)} ${bc.getMeasure()}"
        resultCarboHydrates_textView.text = "${Helper.decimalFormat(bc.carboHydrates, 1)} g ${getString(R.string.carbohydrate)}"

        Log.i("asd", "${bc.result.toString()} ${bc.getMeasure()}")
        Log.i("asd", "${bc.carboHydrates} g ${getString(R.string.carbohydrate)}")
    }
}
