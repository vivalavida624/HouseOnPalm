package com.example.houseonplam.ui.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.math.BigDecimal
import java.math.RoundingMode

class CalculatorViewModel: ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Calculator Fragment"
    }
    val text: LiveData<String> = _text

    fun calcMonthlyPayment(
        salePrice: Double,
        downPayment: Double,
        interestRate: Double,
        amortization: Double,
        frequency: Int
    ): BigDecimal? {
        // assuming 25 years for the loan and payments are monthly (12 per year)
        val interestRatePerc = interestRate / 100
        var freqYear = 0

        if(frequency == 1) {
            freqYear = 52
        } else if(frequency == 2) {
            freqYear = 24
        } else if(frequency == 3) {
            freqYear = 12
        } else if(frequency == 4) {
            freqYear = 6
        }

        val monthlyPay = ((salePrice - downPayment) * (interestRatePerc / freqYear)) / (1 - (1 / (Math.pow(1 + (interestRatePerc / freqYear), (freqYear * amortization)))))
        return BigDecimal(monthlyPay).setScale(2, RoundingMode.CEILING)
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