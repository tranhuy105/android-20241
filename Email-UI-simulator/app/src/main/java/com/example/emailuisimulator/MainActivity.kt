package com.example.emailuisimulator

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var studentID: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Initialize the RecyclerView
        studentID = findViewById(R.id.StudentID)
        studentID.text = "20225860"
        val recyclerView: RecyclerView = findViewById(R.id.itemRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Generate a list of random items
        val items = generateRandomItems()

        // Set the adapter with the generated items
        val adapter = ItemAdapter(items)
        recyclerView.adapter = adapter
        studentID.text = "20225860"
    }

    private fun generateRandomItems(): List<ItemData> {
        val items = mutableListOf<ItemData>()
        val itemCount = Random.nextInt(20, 60)

        for (i in 0 until itemCount) {
            // Generate random sender name, summary, and time
            val senderName = senderNameArray.random()
            val summary = contentArray.random()

            sendTimeNum -= delayTime
            val hour = sendTimeNum / 60
            val minute = sendTimeNum % 60
            val sendTime = String.format("%02d:%02d", hour, minute)

            items.add(ItemData(senderName, sendTime, summary))
        }
        studentID.text = "20225860"
        return items
    }

    companion object {
        private val senderNameArray = arrayOf("Huy", "Tran", "Quang", "Tran Quang Huy", "Tran Huy")
        private val contentArray = arrayOf(
            "Hello, How you doing?",
            "Hey, Wanna play some games?",
            "I need your help",
            "Have you done with homework?",
            "Do we have a meeting tomorrow?",
            "Do you have any plans for the weekend?",
            "Do we have any new projects to work on?",
            "Do we have any homework for tomorrow?"
        )
        var sendTimeNum: Int = 1380
        private const val delayTime = 5
    }
}
