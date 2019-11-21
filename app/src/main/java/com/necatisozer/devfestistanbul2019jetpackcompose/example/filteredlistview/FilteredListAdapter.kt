package com.necatisozer.devfestistanbul2019jetpackcompose.example.filteredlistview

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.necatisozer.devfestistanbul2019jetpackcompose.R
import com.necatisozer.devfestistanbul2019jetpackcompose.example.Contact

class FilteredListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var filterText = ""
    private var unfilteredContacts = ArrayList<Contact>()
    private var filteredContacts = ArrayList<Contact>()

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val child = holder.itemView
        val contact = filteredContacts[position]
        child.findViewById<TextView>(R.id.name).text = contact.name
        child.findViewById<ImageView>(R.id.name).setImageResource(contact.photo)
    }

    override fun getItemCount(): Int {
        return filteredContacts.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val child = inflater.inflate(R.layout.contact_item, null)
        return object : RecyclerView.ViewHolder(child) {}
    }

    fun setFilterText(filterText: String) {
        this.filterText = filterText
        onChange()
    }

    fun setContacts(contacts: List<Contact>) {
        this.unfilteredContacts = ArrayList(contacts)
        onChange()
    }

    private fun onChange() {
        var position = 0
        while (position < filteredContacts.size) {
            val contact = filteredContacts[position]
            if (unfilteredContacts.contains(contact) &&
                contact.name.toLowerCase().contains(filterText.toLowerCase())
            ) {
                position++
                continue
            }
            filteredContacts.removeAt(position)
            notifyItemRemoved(position)
            position++
        }

        position = 0
        for (contact in unfilteredContacts) {
            if (filteredContacts.size > position && contact == filteredContacts[position]) {
                position++
                continue
            }
            if (!contact.name.toLowerCase().contains(filterText.toLowerCase())) continue
            filteredContacts.add(position, contact)
            notifyItemInserted(position)
            position++
        }
    }
}