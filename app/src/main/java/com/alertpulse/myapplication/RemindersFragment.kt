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
import com.alertpulse.myapplication.adapters.RemindersAdapter
import com.alertpulse.myapplication.databinding.FragmentListReminderBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RemindersFragment : Fragment() {

    private var _binding: FragmentListReminderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView
    private lateinit var remindersAdapter: RemindersAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListReminderBinding.inflate(inflater, container, false)


        val view = binding.root
        remindersAdapter = RemindersAdapter()
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.remindersRv
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = remindersAdapter

        binding.addReminderIcon.setOnClickListener {
            findNavController().navigate(R.id.actionListFragmentToCreateFragment)
        }
        /*
        binding.buttonCancelAsociate.setOnClickListener {
            findNavController().navigate(R.id.action_AsociateSelectFragment_to_AsociateFragment)
        }

        binding.buttonAcceptAsociate.setOnClickListener {
            findNavController().navigate(R.id.action_AsociateSelectFragment_to_AsociateFragment)
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}