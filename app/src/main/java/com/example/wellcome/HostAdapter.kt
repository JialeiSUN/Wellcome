package com.example.wellcome
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.wellcome.R
import com.example.wellcome.models.Host


class HostAdapter(val context: Context,private val dataSet: List<Host>):
    RecyclerView.Adapter<HostAdapter.ViewHolder>()
{
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = itemView.findViewById(R.id.title_host)
        val address: TextView = itemView.findViewById(R.id.address_host)
        val phone: TextView = itemView.findViewById(R.id.phone_host)
        val tags: TextView = itemView.findViewById(R.id.tags_host)
        val nomberOfPeople: TextView = itemView.findViewById(R.id.nomber_people_host)
        val nomberOfPiece: TextView = itemView.findViewById(R.id.nomber_piece_host)
        val call_button: Button = itemView.findViewById(R.id.call_button_host)

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HostAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.host_card_view, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataSet[position].title
        viewHolder.phone.text = dataSet[position].phone
        viewHolder.address.text = dataSet[position].address
        viewHolder.tags.text = dataSet[position].tags.toString()
        viewHolder.nomberOfPeople.text = dataSet[position].nombrePersonne
        viewHolder.nomberOfPiece.text = dataSet[position].nombrePiece
        val tele = viewHolder.phone.text
        viewHolder.call_button.setOnClickListener {
            var intent = Intent()
              intent.action = Intent.ACTION_DIAL
              intent.data = Uri.parse("tel:$tele")
              context.startActivity(intent)
        }

    }

    override fun getItemCount() = dataSet.size
}