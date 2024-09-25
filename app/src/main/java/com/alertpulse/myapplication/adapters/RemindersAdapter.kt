package com.alertpulse.myapplication.adapters
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.alertpulse.myapplication.R
import com.alertpulse.myapplication.RemindersFragmentDirections
import com.alertpulse.myapplication.databinding.ReminderItemBinding
import com.alertpulse.myapplication.models.Reminders

class RemindersAdapter : RecyclerView.Adapter<RemindersAdapter.RemindersViewHolder>(){

    private var reminders :List<Reminders> = listOf(
        Reminders(1, "26/09/2023","07:00 am", "Tomar medicamento", "Pulse"),
        Reminders(2, "26/09/2023","08:00 am", "Regar plantas", "Cry"),
        Reminders(3, "26/09/2023","11:00 am", "Tomar remedio", "Bell")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemindersViewHolder {
        val withDataBinding: ReminderItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            RemindersViewHolder.LAYOUT,
            parent,
            false)
        return RemindersViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: RemindersViewHolder, position: Int) {
        val reminder = reminders[position]
        holder.bind(reminder)

    }

    override fun getItemCount(): Int {
        return reminders.size
    }


    class RemindersViewHolder(val viewDataBinding: ReminderItemBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.reminder_item
        }

        fun bind(reminder: Reminders) {
            viewDataBinding.reminder = reminder
            viewDataBinding.executePendingBindings()

            // Button 1: Navigate to EditFragment with device.id
            viewDataBinding.editReminderIcon.setOnClickListener {
                val action = RemindersFragmentDirections.actionListFragmentToEditFragment(reminder.id)
                viewDataBinding.root.findNavController().navigate(action)
            }

            viewDataBinding.deleteReminderIcon.setOnClickListener {
                showAcceptCancelDialog(viewDataBinding.root.context)
            }

        }


        // Function to show an accept/cancel dialog
        private fun showAcceptCancelDialog(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Deseas eliminar el recordatorio?")
                .setCancelable(false)  // Prevents dialog from being dismissed on outside click
                .setPositiveButton("Aceptar") { dialog, id ->
                    dialog.dismiss()  // Close the dialog
                }
                .setNegativeButton("Cancelar") { dialog, id ->
                    // Action when "Cancel" is clicked
                    dialog.dismiss()  // Close the dialog
                }

            // Create and show the dialog
            val alert: AlertDialog = builder.create()
            alert.show()
        }

    }


}