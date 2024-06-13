package com.example.houseonplam.ui.calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatSeekBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.houseonplam.databinding.FragmentCalculatorBinding

class CalculatorFragment(): Fragment() {

    private var _binding: FragmentCalculatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val calculatorViewModel =
            ViewModelProvider(this).get(CalculatorViewModel::class.java)

        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val salePrice : TextView = binding.editTextSalePrice
        val downPayment: TextView = binding.editTextDownPayment
        val interestRate: TextView = binding.editTextInterestRate
        //val amortization: Int = binding.seekBarAmortization.toString().toInt()
        //val frequency: Int = binding.seekBarFrequency.toString().toInt()
        var monthly: TextView = binding.textMonthlyPaymentDisplay
        val buttonCalculate: Button = binding.buttonCalculate

        buttonCalculate.setOnClickListener {
            monthly.text = calculatorViewModel.calcMonthlyPayment(
                salePrice.text.toString().toDouble(),
                downPayment.text.toString().toDouble(),
                interestRate.text.toString().toDouble()
            ).toString()
        }


        /*
        calculatorViewModel.text.observe(viewLifecycleOwner) {
            monthly.text = it
        }

         */

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}