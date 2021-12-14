package com.example.wellcome
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.wellcome.db.Lesson

class LessonAdapter(private val dataSet: List<Lesson>):
    RecyclerView.Adapter<LessonAdapter.ViewHolder>()
{
    private lateinit var context:Context

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = itemView.findViewById(R.id.title_cours)
        val address: TextView = itemView.findViewById(R.id.address_cours)
        val phone: TextView = itemView.findViewById(R.id.phone_cours)
      //  val tags: TextView = itemView.findViewById(R.id.tags_cours)
       // val sessionDuration: TextView = itemView.findViewById(R.id.sessionDuration_cours)
        val callButton: Button = itemView.findViewById(R.id.call_button_cours)
        val consultButton: Button = itemView.findViewById(R.id.consulter_button_cours)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cours_card_view, parent, false)

        context = parent.context

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.title.text = dataSet[position].title
        viewHolder.phone.text = dataSet[position].phone
        viewHolder.address.text = dataSet[position].address.toString()
      //  viewHolder.tags.text = dataSet[position].tags.toString()
       // viewHolder.sessionDuration.text = dataSet[position].sessionDuration
        val tele = viewHolder.phone.text

        viewHolder.callButton.setOnClickListener {
            var intent = Intent()
            intent.action = Intent.ACTION_DIAL
            intent.data = Uri.parse("tel:$tele")
            context.startActivity(intent)
        }

        viewHolder.consultButton.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("id",dataSet[position].id)
            val intent = Intent(context,ActivityConsultLesson::class.java)
            intent.putExtras(bundle)
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = dataSet.size
}