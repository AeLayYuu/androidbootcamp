package mm.com.fairway.fourthapprecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aelayyuu.recyclerview.R
import com.aelayyuu.recyclerview.model.Person
import kotlinx.android.synthetic.main.item_person.view.*

class PersonAdapter(var personList:ArrayList<Person>) : RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {
    var clickListener :ClickListener ? = null
    fun setOnClickListener(clickListener: ClickListener){
        this.clickListener=clickListener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        var view=LayoutInflater.from(parent.context).inflate(R.layout.item_person,parent,false)
        return PersonViewHolder(view)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        holder.bindPerson(personList[position])
    }
    interface ClickListener{
        fun onClick(person: Person)
    }

    // ViewHolder
    inner class PersonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) ,View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        lateinit var person: Person
        fun bindPerson(person: Person) {
            this.person = person
            //to show data views at layout
            itemView.txtName.text = person.name
            itemView.txtOccupation.text = person.occupation

        }

        override fun onClick(v: View?) {
            clickListener?.onClick(person)
        }
    }
}