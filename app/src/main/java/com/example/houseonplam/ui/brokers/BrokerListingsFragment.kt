package com.example.houseonplam.ui.brokers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.houseonplam.databinding.FragmentBrokerListingsBinding
import com.example.houseonplam.ui.brokers.BrokerListingsFragmentDirections
import com.example.houseonplam.models.Listing

class BrokerListingsFragment : Fragment() {

    private var _binding: FragmentBrokerListingsBinding? = null
    private val binding get() = _binding!!
    private lateinit var listingAdapter: ListingAdapter
    private lateinit var listingList: List<Listing>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBrokerListingsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 初始化listingList
        listingList = getListings() // 获取你的listing列表

        // 设置RecyclerView
        binding.listingsRecyclerView.layoutManager = LinearLayoutManager(context)
        listingAdapter = ListingAdapter(listingList) { listing ->
            val action = BrokerListingsFragmentDirections.actionBrokerListingsFragmentToHouseDetailFragment(
                housePrice = listing.price,
                houseAddress = listing.address
            )
            findNavController().navigate(action)
        }
        binding.listingsRecyclerView.adapter = listingAdapter

        return root
    }

    private fun getListings(): List<Listing> {
        // 获取listing数据的函数
        // 这里你可以从数据库或者API获取数据
        return listOf(
            Listing("https://example.com/image1.jpg", "750,000", "1288 Rue St-Antoine O. #3703, Central, Montréal, H3C0X6", 2, 2, 656.59, 2020),
            Listing("https://example.com/image2.jpg", "879,000", "69 Rue des Violettes, South, Blainville, J7C5R6", 5, 2, 13.0, 2000)
            // 添加更多listing数据
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
