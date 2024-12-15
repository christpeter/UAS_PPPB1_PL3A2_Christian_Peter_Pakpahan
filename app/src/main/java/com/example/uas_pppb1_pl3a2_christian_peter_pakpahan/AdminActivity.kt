package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.adapter.ScheduleAdapter
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.models.TravelSchedule
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.AddScheduleActivity

class AdminActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var scheduleAdapter: ScheduleAdapter
    private val scheduleList = mutableListOf<TravelSchedule>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        recyclerView = findViewById(R.id.rvSchedulesAdmin)
        recyclerView.layoutManager = LinearLayoutManager(this)

        scheduleAdapter = ScheduleAdapter(scheduleList) { schedule ->
        }
        recyclerView.adapter = scheduleAdapter


        findViewById<Button>(R.id.btnAddSchedule).setOnClickListener {
            startActivity(Intent(this, AddScheduleActivity::class.java))
        }
    }
}