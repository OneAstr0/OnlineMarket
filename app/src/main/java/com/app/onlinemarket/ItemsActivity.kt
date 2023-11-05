package com.app.onlinemarket

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val ItemsList: RecyclerView = findViewById(R.id.items_list)
        val items = arrayListOf<Item>() // array based on the Item class

        items.add(Item(1, "sofa", "Диван", "Коротко о диване", "Полное описание дивана", 100))
        items.add(Item(2, "light", "Свет", "Коротко о свете", "Полное описание света", 40))
        items.add(Item(3, "chair", "Кресло", "Коротко о кресле", "Полное описание кресла", 50))

        ItemsList.layoutManager = LinearLayoutManager(this) // Select format for ItemsList
        ItemsList.adapter = ItemsAdapter(items, this)
    }
}