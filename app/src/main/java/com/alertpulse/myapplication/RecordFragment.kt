package com.alertpulse.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController

import androidx.navigation.fragment.navArgs
import com.alertpulse.myapplication.R
import com.alertpulse.myapplication.databinding.FragmentRecordBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class RecordFragment : Fragment() {

    private var _binding: FragmentRecordBinding? = null
    private lateinit var recordWaveIcon: ImageView
    private lateinit var stopIcon: ImageView
    private lateinit var recordIcon2: ImageView
    private lateinit var pauseIcon3: ImageView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRecordBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args: com.alertpulse.myapplication.RecordFragmentArgs by navArgs()


        // Initialize the ImageViews
        recordWaveIcon = view.findViewById(R.id.recordWave)
        stopIcon = view.findViewById(R.id.iconStop)
        recordIcon2 = view.findViewById(R.id.iconRecord)
        pauseIcon3 = view.findViewById(R.id.iconPause)

        stopIcon.setOnClickListener {
            setWaveInactiveIcon()
        }
        recordIcon2.setOnClickListener {
            setWaveActiveIcon()
        }

        binding.buttonAcceptRecord.setOnClickListener{
            if(args.originArg ==1 ){
                findNavController().navigate(R.id.actionRecordFragmentToSignUpFragment)
            }
            if(args.originArg ==2 ){
                findNavController().navigate(R.id.actionRecordFragmentToLoginFragment)
            }
            if(args.originArg ==3 ){
                findNavController().navigate(R.id.actionRecordFragmentToEditFragment)
            }
            if(args.originArg ==4 ){
                findNavController().navigate(R.id.actionRecordFragmentToCreateFragment)
            }
        }

        binding.buttonCancelRecord.setOnClickListener{
            if(args.originArg ==1 ){
                findNavController().navigate(R.id.actionRecordFragmentToSignUpFragment)
            }
            if(args.originArg ==2 ){
                findNavController().navigate(R.id.actionRecordFragmentToLoginFragment)
            }
            if(args.originArg ==3 ){
                findNavController().navigate(R.id.actionRecordFragmentToEditFragment)
            }
            if(args.originArg ==4 ){
                findNavController().navigate(R.id.actionRecordFragmentToCreateFragment)
            }
        }
       /* binding.buttonRegister.setOnClickListener {
            findNavController().navigate(R.id.action_LoginFragment_to_RemindersFragment)
        }*/
    }

    private fun setWaveActiveIcon() {
        recordWaveIcon.setImageResource(R.drawable.wave_active)

    }
    private fun setWaveInactiveIcon() {
        recordWaveIcon.setImageResource(R.drawable.wave_no_sound)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}