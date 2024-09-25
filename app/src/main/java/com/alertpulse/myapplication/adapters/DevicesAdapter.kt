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
import com.alertpulse.myapplication.databinding.FragmentDevicesListBinding
import com.alertpulse.myapplication.models.Devices
import com.alertpulse.myapplication.models.Reminders

class DevicesAdapter : RecyclerView.Adapter<DevicesAdapter.DevicesViewHolder>(){

    var devices :List<Devices> = listOf(
        Devices(1, "Mi Band 6"),
        Devices(2, "Huawei band"),
        Devices(3, "IBand")
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevicesViewHolder {
        val withDataBinding: FragmentDevicesListBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            DevicesViewHolder.LAYOUT,
            parent,
            false)
        return DevicesViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: DevicesViewHolder, position: Int) {
        val device = devices[position]
        holder.bind(device)

    }

    override fun getItemCount(): Int {
        return devices.size
    }


    class DevicesViewHolder(val viewDataBinding: FragmentDevicesListBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.fragment_devices_list
        }

        fun bind(device: Devices) {
            viewDataBinding.device = device
            viewDataBinding.executePendingBindings()

            viewDataBinding.deleteAsociateIcon.setOnClickListener {
                showAcceptCancelDialog(viewDataBinding.root.context)
            }

        }

        // Function to show an accept/cancel dialog
        private fun showAcceptCancelDialog(context: Context) {
            val builder = AlertDialog.Builder(context)
            builder.setMessage("Deseas desvincular el dispositivo?")
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