package com.example.houseonplam.ui.calculator

import android.annotation.SuppressLint
import android.icu.text.DecimalFormat
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.houseonplam.databinding.FragmentCalculatorBinding
import org.jetbrains.annotations.TestOnly

class CalculatorFragment(): Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    
    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calculatorViewModel =
            ViewModelProvider(this).get(CalculatorViewModel::class.java)

        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // variables to calculate from editText
        val salePrice : TextView = binding.editTextSalePrice
        val downPayment: TextView = binding.editTextDownPayment
        val interestRate: TextView = binding.editTextInterestRate

        /*
        if(salePrice.text.toString().toDouble() < downPayment.text.toString().toDouble() || interestRate.text.toString().toDouble() != 0.0) {
            Toast.makeText(this, "Input incorrect", Toast.LENGTH_SHORT).show()
        }

         */

        val salePriceNum: Double = salePrice.text.toString().toDouble()
        val downPaymentNum: Double = downPayment.text.toString().toDouble()
        val interestRateNum: Double = interestRate.text.toString().toDouble()

        /*
        Tried to change the display while user was typing but failed
        salePrice.text = "$ " + DecimalFormat("#,###.##").format(salePriceNum)
        downPayment.text = "$ " + DecimalFormat("#,###.##").format(downPaymentNum)
        interestRate.text = "% " + DecimalFormat("#.##").format(interestRateNum)
         */

        // progress circle bar
        //val progress: ProgressBar = binding.progressBar

        // seek bar amortization
        val amortization: SeekBar = binding.seekBarAmortization
        val amortizationDisplay: TextView = binding.textAmortizationDisplay
        var startPointAmort = 0
        var endPointAmort = 0
        var amort = 25

        // seek bar frequency
        val frequency: SeekBar = binding.seekBarFrequency
        val frequencyDisplay: TextView = binding.textFrequencyDisplay
        var startPointFreq = 0
        var endPointFreq = 0
        var freq = 3

        // Monthly Display
        var monthly: TextView = binding.textMonthlyPaymentDisplay

        // Button
        val buttonCalculate: Button = binding.buttonCalculate
        val buttonRestart: Button = binding.buttonRestart

        /*
        fun formatter(n: Double) {
            DecimalFormat("#,###.##").format(n)
        }

         */


        amortization.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onProgressChanged(
                    seekBar: SeekBar,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    amort = progress
                    amortizationDisplay.text = "$amort years"
                }

                override fun onStartTrackingTouch(seekBar: SeekBar) {
                    startPointAmort = seekBar.progress
                }

                override fun onStopTrackingTouch(seekBar: SeekBar) {
                    endPointAmort = seekBar.progress
                }
            }
        )

        frequency.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(
                seekBar: SeekBar,
                progress: Int,
                fromUser: Boolean
            ) {
                freq = progress
                if (freq == 1) {
                    frequencyDisplay.text = "Weekly"
                } else if (freq == 2) {
                    frequencyDisplay.text = "Bi-Weekly"
                } else if (freq == 3) {
                    frequencyDisplay.text = "Monthly"
                } else if (freq == 4) {
                    frequencyDisplay.text = "Every 2 months"
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                startPointFreq = seekBar.progress
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                endPointFreq = seekBar.progress
            }

        })

        buttonCalculate.setOnClickListener {
            var monthlyPay = calculatorViewModel.calcMonthlyPayment(
                salePriceNum,
                downPaymentNum,
                interestRateNum,
                amort.toString().toDouble(),
                freq.toString().toInt()
            ).toString()

            monthly.text = "$ " + DecimalFormat("#,###.##").format(monthlyPay.toDouble()).toString()
        }

        buttonRestart.setOnClickListener {
            salePrice.text = ""
            downPayment.text = ""
            interestRate.text = ""
            amortization.progress = 25
            frequency.progress = 3
            monthly.text = "$ 0"
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}