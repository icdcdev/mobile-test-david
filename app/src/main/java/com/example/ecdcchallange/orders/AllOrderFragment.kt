package com.example.ecdcchallange.orders

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.ecdcchallange.R
import com.example.ecdcchallange.common.observe
import com.example.ecdcchallange.databinding.FragmentAllOrderBinding
import com.example.models.Order
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AllOrderFragment : Fragment() {

    private lateinit var binding: FragmentAllOrderBinding
    private val viewModel: OrderViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAllOrderBinding.bind(view)

        observe(viewModel.getViewStateOrder(), ::onViewState)
        viewModel.fetchOrders(false)
    }

    private fun onViewState(state: ViewSateOrder?) {
        when (state) {
            ViewSateOrder.Loading -> {

            }

            is ViewSateOrder.ItemOrder -> {
            }

            ViewSateOrder.NotFoundItems -> {
            }

            is ViewSateOrder.ErrorLoadingItems -> {
            }

            else -> {

            }
        }
    }

}