package com.example.houseonplam.ui.brokers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.houseonplam.databinding.FragmentBrokerDetailBinding

class BrokerDetailFragment : Fragment() {

    private var _binding: FragmentBrokerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrokerDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 从Safe Args中获取数据
        val brokerId = arguments?.getString("brokerId") ?: "Unknown"
        binding.brokerNameTextView.text = brokerId

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
