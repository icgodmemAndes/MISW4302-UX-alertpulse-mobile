package com.alertpulse.myapplication

import android.app.TimePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.EditText
import android.widget.TimePicker
import androidx.navigation.fragment.findNavController
import com.alertpulse.myapplication.R
import com.alertpulse.myapplication.databinding.FragmentCreateReminderBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CreateFragment : Fragment() {

    private var _binding: FragmentCreateReminderBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var dateEdt: EditText
    private lateinit var hourEdt: EditText
    private lateinit var listEdt: AutoCompleteTextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateReminderBinding.inflate(inflater, container, false)


        val c = Calendar.getInstance()
        val df = SimpleDateFormat("dd/MM/yyyy")
        val hf = SimpleDateFormat("h:mm a")
        var formattedHour: String = hf.format(c.time)
        val formattedDate: String = df.format(c.time)
        formattedHour = formattedHour.replace("AM","am",true)
        formattedHour = formattedHour.replace("PM","pm",true)
        dateEdt = binding.datePickerCreate
        dateEdt.setText(formattedDate)
        dateEdt.showSoftInputOnFocus = false
        dateEdt.setOnClickListener {

            val c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)
            showDatePicker()

            /*
            val datePickerDialog = DatePickerDialog(
                binding.root.context,
                { _, year, monthOfYear, dayOfMonth ->
                    val finalMonth= monthOfYear + 1
                    var month_text = ""
                    var day_text = ""
                    month_text = if (finalMonth < 10){
                        "0"+ finalMonth.toString()
                    } else{
                        finalMonth.toString()
                    }
                    day_text = if (dayOfMonth < 10){
                        "0"+ dayOfMonth.toString()
                    } else{
                        dayOfMonth.toString()
                    }
                    val dat = (day_text + "/" + month_text + "/" + year)
                    dateEdt.setText(dat)
                },
                year,
                month,
                day
            )
            datePickerDialog.show()*/
        }
        hourEdt = binding.hourPickerCreate
        hourEdt.setText(formattedHour)
        hourEdt.showSoftInputOnFocus = false
        hourEdt.setOnClickListener{
            val c = Calendar.getInstance()
            val hour = c.get(Calendar.HOUR)
            val minuteCal = c.get(Calendar.MINUTE)
            showTimePicker()
            /*val timePicker: TimePickerDialog = TimePickerDialog(
                // pass the Context
                binding.root.context,
                // listener to perform task
                // when time is picked
                { _, hourOfDay, minute ->
                    val formattedTime: String = when {
                        hourOfDay == 0 -> {
                            if (minute < 10) {
                                "${hourOfDay + 12}:0${minute} am"
                            } else {
                                "${hourOfDay + 12}:${minute} am"
                            }
                        }
                        hourOfDay > 12 -> {
                            if (minute < 10) {
                                "${hourOfDay - 12}:0${minute} pm"
                            } else {
                                "${hourOfDay - 12}:${minute} pm"
                            }
                        }
                        hourOfDay == 12 -> {
                            if (minute < 10) {
                                "${hourOfDay}:0${minute} pm"
                            } else {
                                "${hourOfDay}:${minute} pm"
                            }
                        }
                        else -> {
                            if (minute < 10) {
                                "${hourOfDay}:${minute} am"
                            } else {
                                "${hourOfDay}:${minute} am"
                            }
                        }
                    }
                    hourEdt.setText(formattedTime)
                },
                // default hour when the time picker
                // dialog is opened
                hour,
                // default minute when the time picker
                // dialog is opened
                minuteCal,
                // 24 hours time picker is
                // false (varies according to the region)
                false
            )

            // then after building the timepicker
            // dialog show the dialog to user
            timePicker.show()*/
        }
        return binding.root

    }

    private fun showDatePicker() {
        val datePicker = MaterialDatePicker.Builder.datePicker()
            .setTitleText("Selecciona la fecha")
            .build()

        datePicker.show(parentFragmentManager, "DATE_PICKER")

        datePicker.addOnPositiveButtonClickListener { selection ->
            // Format date to "dd/MM/yyyy"
            val simpleDateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val date = simpleDateFormat.format(Date(selection))
            dateEdt.setText(date)
        }
    }

    private fun showTimePicker() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePicker = MaterialTimePicker.Builder()
            .setTimeFormat(TimeFormat.CLOCK_12H)
            .setHour(hour)
            .setMinute(minute)
            .setTitleText("Selecciona una hora")
            .build()

        timePicker.show(parentFragmentManager, "TIME_PICKER")

        timePicker.addOnPositiveButtonClickListener {
            // Format hour to "h m a"

            val simpleDateFormat = SimpleDateFormat("h:mm a", Locale.getDefault())
            //val date = simpleDateFormat.format(Date(selection))
            var hourOfDay = timePicker.hour
            var minute = timePicker.minute
            val formattedTime: String = when {
                hourOfDay == 0 -> {
                    if (minute < 10) {
                        "${hourOfDay + 12}:0${minute} am"
                    } else {
                        "${hourOfDay + 12}:${minute} am"
                    }
                }
                hourOfDay > 12 -> {
                    if (minute < 10) {
                        "${hourOfDay - 12}:0${minute} pm"
                    } else {
                        "${hourOfDay - 12}:${minute} pm"
                    }
                }
                hourOfDay == 12 -> {
                    if (minute < 10) {
                        "${hourOfDay}:0${minute} pm"
                    } else {
                        "${hourOfDay}:${minute} pm"
                    }
                }
                else -> {
                    if (minute < 10) {
                        "${hourOfDay}:${minute} am"
                    } else {
                        "${hourOfDay}:${minute} am"
                    }
                }
            }
            hourEdt.setText(formattedTime)
        }


        /*val timePickerDialog = TimePickerDialog(requireContext(),
            { _: TimePicker, selectedHour: Int, selectedMinute: Int ->
                // Format time to "h:mm a" (12-hour format with AM/PM)
                val cal = Calendar.getInstance()
                cal.set(Calendar.HOUR_OF_DAY, selectedHour)
                cal.set(Calendar.MINUTE, selectedMinute)
                val simpleTimeFormat = SimpleDateFormat("hh:mm a", Locale.getDefault())
                val time = simpleTimeFormat.format(cal.time)
                hourEdt.setText(time)
            }, hour, minute, false) // 'false' for 12-hour format

        timePickerDialog.show()*/
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCancelCreate.setOnClickListener {
            findNavController().navigate(R.id.actionCreateFragmentToRemindersFragment)
        }
        binding.buttonAcceptCreate.setOnClickListener {
            findNavController().navigate(R.id.actionCreateFragmentToRemindersFragment)
        }
        binding.micCreate.setOnClickListener{
            val numberToSend = 4
            val action =
                com.alertpulse.myapplication.CreateFragmentDirections.actionCreateFragmentToRecordFragment(
                    numberToSend
                )
            findNavController().navigate(action)
        }

        // Array of items to show in the dropdown
        val items = listOf("Pulse", "Bell", "Cry")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        // Access TextInputLayout and AutoCompleteTextView
        val autoCompleteTextView = view.findViewById<AutoCompleteTextView>(R.id.autoCompleteTextViewCreate)
        // Set the adapter to the AutoCompleteTextView inside TextInputLayout
        autoCompleteTextView.setAdapter(adapter)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

private fun MaterialAutoCompleteTextView?.setSimpleItems(items: List<String>) {

}
