package com.alertpulse.myapplication

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ClickableSpan
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.alertpulse.myapplication.R
import com.alertpulse.myapplication.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val textView = binding.noTeEncue

        // Complete text
        val fullText = "No estas registrado? Registrate accediendo a este enlace Aqui."

        // Create a SpannableString
        val spannableString = SpannableString(fullText)

        // Apply color to the "Aqui." part
        val startIndex = fullText.indexOf("Aqui.")
        val endIndex = startIndex + "Aqui.".length

        // Set color for "Aqui."
        val blueColor = ContextCompat.getColor(requireContext(), R.color.schemesOnPrimary)
        spannableString.setSpan(
            ForegroundColorSpan(blueColor),
            startIndex, endIndex,
            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )

        // Make "Aqui." clickable
        val clickableSpan = object : ClickableSpan() {
            override fun onClick(widget: View) {
                // Navigate to the desired screen using FragmentDirections
                val action =
                    com.alertpulse.myapplication.LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
                findNavController().navigate(action)
            }
        }

        // Attach clickable span to "Aqui."
        spannableString.setSpan(clickableSpan, startIndex, endIndex, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        // Set the styled text in TextView
        textView.text = spannableString

        // Make sure the TextView handles clicks
        textView.movementMethod = android.text.method.LinkMovementMethod.getInstance()

        binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.actionLoginFragmentToRemindersFragment)
        }

        binding.micLogin.setOnClickListener{
            val numberToSend = 2
            val action =
                com.alertpulse.myapplication.LoginFragmentDirections.actionLoginFragmentToRecordFragment(
                    numberToSend
                )
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}