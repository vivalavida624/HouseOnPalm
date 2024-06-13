package com.example.houseonplam.ui.brokers

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.houseonplam.R
import com.example.houseonplam.databinding.FragmentBrokersBinding

class BrokersFragment : Fragment() {

    private var _binding: FragmentBrokersBinding? = null
    private val binding get() = _binding!!
    private lateinit var brokerAdapter: BrokerAdapter
    private lateinit var brokerList: List<Broker>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val brokersViewModel =
            ViewModelProvider(this).get(BrokersViewModel::class.java)

        _binding = FragmentBrokersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 初始化brokerList
        brokerList = getBrokers() // 获取你的broker列表

        // 设置RecyclerView
        binding.brokersRecyclerView.layoutManager = LinearLayoutManager(context)
        brokerAdapter = BrokerAdapter(brokerList) { broker ->
            val action = BrokersFragmentDirections.actionBrokersFragmentToBrokerDetailFragment(broker.name, "Broker Title Placeholder")
            findNavController().navigate(action)
        }
        binding.brokersRecyclerView.adapter = brokerAdapter

        // 设置搜索功能
        binding.searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterBrokers(s.toString())
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        return root
    }

    private fun filterBrokers(query: String) {
        val filteredList = brokerList.filter {
            it.name.contains(query, ignoreCase = true)
        }
        brokerAdapter.updateList(filteredList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getBrokers(): List<Broker> {
        // 获取broker数据的函数
        // 这里你可以从数据库或者API获取数据
        return listOf(
            Broker("Broker Name 1"),
            Broker("Broker Name 2"),
            Broker("Broker Name 3"),
            Broker("Broker Name 4")
            // 添加更多broker数据
        )
    }
}
