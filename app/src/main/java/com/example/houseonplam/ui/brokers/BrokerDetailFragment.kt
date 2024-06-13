package com.example.houseonplam.ui.brokers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.houseonplam.databinding.FragmentBrokerDetailBinding

class BrokerDetailFragment : Fragment() {

    private var _binding: FragmentBrokerDetailBinding? = null
    private val binding get() = _binding!!
    private val args: BrokerDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrokerDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 从Safe Args中获取数据
        val brokerName = args.brokerName
        val brokerTitle = args.brokerTitle

        // 绑定数据到视图
        binding.brokerNameTextView.text = brokerName
        binding.brokerTitleTextView.text = brokerTitle
        binding.marketListings.text = "On Market Listings"
        binding.informationRequest.text = "Information Request"
        binding.contact.text = "Contact"
        binding.email.text = "Email"

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
