package com.alertpulse.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alertpulse.myapplication.R
import com.alertpulse.myapplication.adapters.DevicesAdapter
import com.alertpulse.myapplication.databinding.FragmentAsociateSelectReminderBinding


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AsociateSelectFragment : Fragment() {

    private var _binding: FragmentAsociateSelectReminderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var devicesAdapter: DevicesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAsociateSelectReminderBinding.inflate(inflater, container, false)


        val view = binding.root
        devicesAdapter = DevicesAdapter()
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.devicesRv
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = devicesAdapter

        binding.buttonCancelAsociate.setOnClickListener {
            findNavController().navigate(R.id.actionAsociateSelectFragmentToAsociateFragment)
        }

        binding.buttonAcceptAsociate.setOnClickListener {
            findNavController().navigate(R.id.actionAsociateSelectFragmentToAsociateFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}