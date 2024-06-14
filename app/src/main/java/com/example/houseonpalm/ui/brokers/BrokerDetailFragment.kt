package com.example.houseonpalm.ui.brokers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.houseonpalm.databinding.FragmentBrokerDetailBinding

class BrokerDetailFragment : Fragment() {

    private var _binding: FragmentBrokerDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBrokerDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val brokerName = arguments?.getString("brokerName") ?: "Unknown"
        val brokerTitle = arguments?.getString("brokerTitle") ?: "Unknown"

        binding.brokerNameTextView.text = brokerName
        binding.brokerTitleTextView.text = brokerTitle

        binding.marketListings.setOnClickListener {
            val action = BrokerDetailFragmentDirections.actionBrokerDetailFragmentToBrokerListingsFragment(brokerName)
            findNavController().navigate(action)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
