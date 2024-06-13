package com.example.houseonplam.ui.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CalculatorViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Calculator Fragment"
    }
    val text: LiveData<String> = _text

    fun calcMonthlyPayment(salePrice: Double, downPayment: Double, interestRate: Double): Double {
        // assuming 25 years for the loan and payments are monthly (12 per year)
        return ((salePrice - downPayment) * (interestRate / 1200)) / (1 - (1 / (Math.pow(1 + (interestRate / 1200), 300.0))))
    }

    /*

    val salePrice : Int = 0
    val downPayment: Int = 0
    val interestRate: Double = 0.0
    val amortization: Int = 0
    val frequency: Int = 0
    var monthly: Double = 0.0

    // this is the formula for the mortgage
    fun calcMonthlyPayment() {

        monthly = ((salePrice - downPayment) * (interestRate / 12) * (1 + (interestRate / 12))) / ((1 + (interestRate / 12)) - 1)

    }
     */

}