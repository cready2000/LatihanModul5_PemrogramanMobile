package com.example.latihanmodul5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val list = ArrayList<Users>()
    val listUsers = arrayOf(
            "Alpha",
            "Bravo",
            "Charlie",
            "Delta",
            "Echo",
            "Foxtrot",
            "Golf",
            "Hotel",
            "India",
            "Juliet"
    )
    val halo = arrayOf(
            "halo"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerview = findViewById<RecyclerView>(R.id.mRecycleView)
        mRecycleView.setHasFixedSize(true)
        mRecycleView.layoutManager = LinearLayoutManager(this)
        for (i in 0 until listUsers.size) {
            list.add(Users(listUsers.get(i)))
            if (listUsers.size - 1 == i) {
                val adapter = Adapter(list)
                adapter.notifyDataSetChanged()
                mRecycleView.adapter = adapter
                adapter.setOnClickListener {
                    Toast.makeText(this, "Halo " +
                            listUsers[it], Toast.LENGTH_SHORT).show()
                }
            }
        }
        mRecycleView.scrollToPosition(halo.size -
                1);

    }
}
