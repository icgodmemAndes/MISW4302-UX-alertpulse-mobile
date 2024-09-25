package com.alertpulse.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.alertpulse.myapplication.R
import com.alertpulse.myapplication.databinding.FragmentAsociateReminderBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AsociateFragment : Fragment() {

    private var _binding: FragmentAsociateReminderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        _binding = FragmentAsociateReminderBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.watchIcon.setOnClickListener {
            findNavController().navigate(R.id.actionAsociateFragmentToAsociateSelectFragment)
        }

        binding.tabletIcon.setOnClickListener {
            findNavController().navigate(R.id.actionAsociateFragmentToAsociateSelectFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}