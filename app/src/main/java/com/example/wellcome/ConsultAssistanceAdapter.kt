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
import com.example.wellcome.models.Assistance


class ConsultAssistanceAdapter(val context: Context, private val dataSet: Assistance):
    RecyclerView.Adapter<ConsultAssistanceAdapter.ViewHolder>() {
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
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConsultAssistanceAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_consult_assistance_page, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 1;
    }

    override fun onBindViewHolder(v: ViewHolder, position: Int) {
        v.title.text = dataSet.title
        v.address.text = dataSet.address
        v.phone.text = dataSet.phone
        v.description.setText(dataSet.description)
        v.priority.setText(dataSet.priority)
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
    }


}