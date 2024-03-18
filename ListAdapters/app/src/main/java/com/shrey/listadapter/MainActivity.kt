package com.shrey.listadapter

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.shrey.listadapter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // Inflate layout using ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // Get reference to RecyclerView from layout
        val recyclerView = binding.programmingListRV

        // Create an instance of ProgrammingAdapter
        val adapter = ProgrammingAdapter()

        // Create some sample ProgrammingItems
        val p1 = ProgrammingItem(1, "K", "Kotlin")
        val p2 = ProgrammingItem(2, "A", "Android")
        val p3 = ProgrammingItem(3, "J", "Java")

        // Submit the initial list of items to the adapter
        adapter.submitList(listOf(p1, p2, p3))

        // Set up RecyclerView with LinearLayoutManager
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Set fixed size for RecyclerView
        recyclerView.setHasFixedSize(true)

        // Set adapter for RecyclerView
        recyclerView.adapter = adapter

        // Simulate updating data after a delay
        //Handler is a class which is used to run piece of code in main thread with some delay
        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            // Create additional ProgrammingItems
            val p4 = ProgrammingItem(3, "J", "Java")
            val p5 = ProgrammingItem(4, "R", "Rust")
            val p6 = ProgrammingItem(5, "G", "GoLang")
            val p7 = ProgrammingItem(6, "N", "NodeJS")

            // Submit the updated list of items to the adapter after delay
            adapter.submitList(listOf(p5, p7, p6, p4))
        }, 2000) // Delay for 2000 milliseconds (2 seconds)
    }
}
