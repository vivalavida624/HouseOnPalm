package com.example.houseonplam.ui.brokers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.houseonplam.databinding.FragmentBrokerListingsBinding

class BrokerListingsFragment : Fragment() {

    private var _binding: FragmentBrokerListingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrokerListingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 初始化视图和数据
        binding.textView.text = "This is the broker's listings page."

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
