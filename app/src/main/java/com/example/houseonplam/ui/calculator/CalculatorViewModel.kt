package com.example.houseonplam.ui.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class CalculatorViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Calculator Fragment"
    }
    val text: LiveData<String> = _text

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