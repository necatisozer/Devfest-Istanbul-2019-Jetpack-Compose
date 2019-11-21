package com.necatisozer.devfestistanbul2019jetpackcompose.example.filteredlistview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.widget.EditText
import android.widget.FrameLayout
import androidx.recyclerview.widget.RecyclerView
import com.necatisozer.devfestistanbul2019jetpackcompose.R
import com.necatisozer.devfestistanbul2019jetpackcompose.example.Contact

class FilteredListView : FrameLayout {
    private var adapter =
        FilteredListAdapter()

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        inflate(context, R.layout.filtered_list_view, this)
        findViewById<RecyclerView>(R.id.recycler_view).adapter = this.adapter
        findViewById<EditText>(R.id.filter).addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                adapter.setFilterText(s.toString())
            }
        })
    }

    public fun setContacts(contacts: List<Contact>) {
        adapter.setContacts(contacts)
    }
}