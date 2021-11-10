package com.example.wellcome

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.wellcome.utils.db.Address
import com.example.wellcome.utils.db.AppDatabase
import com.example.wellcome.utils.db.Assistance
import com.example.wellcome.utils.searchAddress
import java.lang.StringBuilder


class ConsultAssistanceAdapter(val context: Context, private val dataSet: Assistance):
    RecyclerView.Adapter<ConsultAssistanceAdapter.ViewHolder>() {

    lateinit var db: AppDatabase

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = itemView.findViewById(R.id.title_assisstance_con)
        val address: TextView = itemView.findViewById(R.id.address_assistance_con)
        val phone: TextView = itemView.findViewById(R.id.phone_assistance_con)
        val callButton: Button = itemView.findViewById(R.id.call_button_assistance_con)
        val description: EditText = itemView.findViewById(R.id.assistance_description_con)
        val priority: EditText = itemView.findViewById(R.id.assistance_priority_con)
        val checkbox1: CheckBox = itemView.findViewById(R.id.checkbox1_assistance_con)
        val checkbox2: CheckBox = itemView.findViewById(R.id.checkbox2_assistance_con)
        val checkbox3: CheckBox = itemView.findViewById(R.id.checkbox3_assistance_con)
        val reserve: Button = itemView.findViewById(R.id.reserve)
        val addressButton: Button = itemView.findViewById(R.id.search_address)
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConsultAssistanceAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_consult_assistance_page, parent, false)

        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "wellcome"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1;
    }

    override fun onBindViewHolder(v: ViewHolder, position: Int) {
        v.title.text = dataSet.title
        v.address.text = getAddressRepresentation(dataSet.address)
        v.phone.text = dataSet.phone
        v.description.setText(dataSet.description)
        v.priority.setText(dataSet.priority.toString())
        if(dataSet.tags.toString().contains(v.checkbox1.text)){
            v.checkbox1.isChecked
        }
        if(dataSet.tags.toString().contains(v.checkbox2.text)){
            v.checkbox2.isChecked
        }
        if(dataSet.tags.toString().contains(v.checkbox3.text)){
            v.checkbox3.isChecked
        }
        val tele = v.phone.text
        v.callButton.setOnClickListener {
            var intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = Uri.parse("tel:$tele")
            context.startActivity(intent)
        }

        v.reserve.isEnabled = dataSet.isAvailable

        v.reserve.setOnClickListener {
            db.lessonDao().update(!v.reserve.isEnabled, dataSet.id)
            v.reserve.isEnabled = false
        }

        v.addressButton.setOnClickListener {
            context.searchAddress(getAddressRepresentation(dataSet.address))
        }
    }

    private fun getAddressRepresentation(address: Address): String{
        val sb = StringBuilder()
        sb.append(address.country?.addressLine + "\n")
        sb.append(address.country?.administrativeArea?.locality?.addressLine + "\n")
        sb.append(address.country?.administrativeArea?.locality?.thoroughfare?.addressLine)
        return sb.toString()
    }
}