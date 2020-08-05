package com.example.createcreativity.MainLayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.createcreativity.MainLayout.adapter.LayoutsCategoryAdapter
import com.example.createcreativity.MainLayout.adapter.common.ItemClickListener
import com.example.createcreativity.MainLayout.entity.Layouts
import com.example.createcreativity.MainLayout.entity.LayoutsCategory
import com.example.createcreativity.R
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        val layoutsCatagoryAdapter = LayoutsCategoryAdapter(object : ItemClickListener<Layouts> {
            override fun onClickListener(item: Layouts) {
                Toast.makeText(baseContext, "You click ${item.title}", Toast.LENGTH_LONG).show()
            }
        })

        layoutsCatagoryAdapter.submitList(getData())
        outerRecyclerView.adapter = layoutsCatagoryAdapter
    }

}
fun getData(): ArrayList<LayoutsCategory> {
    val bookCategory = arrayListOf<LayoutsCategory>()
    for (a in 1..5) {
        val bookList = arrayListOf<Layouts>()
        for(b in 1..5) {
            val book = Layouts("$b", "Layouts Title $b", R.drawable.ic_launcher_background)
            bookList += book
        }

        bookCategory += LayoutsCategory("$a", "Category title $a", bookList)
    }

    return bookCategory
}



