package com.vogt.sebastian.becalculator

class Helper() {
    companion object {
        fun decimalFormat(value: Double, places: Int): Double {
            return Math.round(value * Math.pow(10.0, places.toDouble())) / Math.pow(10.0, places.toDouble())
        }
    }
}