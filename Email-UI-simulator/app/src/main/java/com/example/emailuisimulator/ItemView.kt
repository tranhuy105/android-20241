package com.example.emailuisimulator

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

public class ItemView:AppCompatActivity() {
    private val senderNameArray = arrayOf("Clove", "Lumine", "Faruzan", "Yoimiya", "Rappa", "Feixiao");
    private val contentArray = arrayOf("Hello, How you doing?",
        "Hey, Wanna play some games?",
        "I need your help",
        "Have you done with homework?",
        "Do we have a meeting tomorrow?",
        "Do you have any plans for the weekend?",
        "Do we have any new projects to work on?",
        "Do we have any home work for tomorrow?");
    private lateinit var senderName: TextView
    private lateinit var sendTime: TextView
    private lateinit var summary: TextView
    lateinit var avatar: TextView
    companion object {
        var sendTimeNum: Int = 1380
    }
    private val delayTime = 5;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.item_view)
        senderName = findViewById(R.id.SenderName)
        sendTime = findViewById(R.id.SendTime)
        summary = findViewById(R.id.Summary)
        avatar = findViewById(R.id.Avatar)
        senderName.text = senderNameArray[(0..senderNameArray.size).random()]
        sendTimeNum -= delayTime
        val hour = sendTimeNum / 60
        val minute = sendTimeNum % 60
        if (hour < 10){
            if (minute < 10){
                sendTime.text = "0$hour:0$minute"
            }else{
                sendTime.text = "0$hour:$minute"
            }
        }
        else{
            if (minute < 10){
                sendTime.text = "$hour:0$minute"
            }else{
                sendTime.text = "$hour:$minute"
            }
        }
        summary.text = contentArray[(0..senderNameArray.size).random()]
        avatar.text = senderName.text[0].toString()
    }
}


