package com.example.houseonplam.ui.calculator

import org.junit.Assert
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorViewModelTest {

    private val calculation = CalculatorViewModel()

    @Test
    fun resultMustBeBiggerThanZero_ReturnsTrue(){
        val salePrice = 1000000.0
        val downPayment = 100000.0
        val interestRate = 5.0
        val amortization = 12.0
        val frequency = 3

        val result = calculation.calcMonthlyPayment(
            salePrice,
            downPayment,
            interestRate,
            amortization,
            frequency
        )
        Assert.assertTrue(result.toString().toDouble() >= 0.0)
    }

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun getText() {
    }

    @Test
    fun calcMonthlyPayment() {
    }
}