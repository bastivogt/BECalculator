package com.vogt.sebastian.becalculator

import java.io.Serializable

class BECalculator(referenceValue: Int = 100, carboHydrateReference: Double = 0.0, amount: Int = 0, be: Boolean = true) : Serializable {
    var referenceValue: Int = referenceValue
    var carboHydrateReferenceValue : Double = carboHydrateReference
    var amount: Int = amount

    var result:Double = 0.0
        private set

    var be: Boolean = be

    var carboHydrates: Double = 0.0
        private set



    init {

        //divide = if(be) BE else KHE
    }


    companion object {
        const val BE = 12
        const val KHE = 10

        const val MEASURE_BE = "BE"
        const val MEASURE_KHE = "KHE"
    }

    fun getDivider(): Int {
        return if(be) BE else KHE
    }

    fun getMeasure(): String {
        return if(be) MEASURE_BE else MEASURE_KHE
    }



    fun compute(): Double {
        carboHydrates = amount * carboHydrateReferenceValue / referenceValue
        result = carboHydrates / getDivider()
        return result
    }
}