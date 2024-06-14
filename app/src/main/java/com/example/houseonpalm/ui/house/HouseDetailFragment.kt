package com.example.houseonpalm.ui.house

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.houseonpalm.databinding.FragmentHouseDetailBinding

class HouseDetailFragment : Fragment() {

    private var _binding: FragmentHouseDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHouseDetailBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val args = HouseDetailFragmentArgs.fromBundle(requireArguments())
        binding.housePriceTextView.text = args.housePrice
        binding.houseAddressTextView.text = args.houseAddress

        // 设置其他视图

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
