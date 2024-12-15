package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.adapter.ScheduleAdapter
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.models.TravelSchedule
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.network.RetrofitClient
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var scheduleAdapter: ScheduleAdapter
    private val scheduleList = mutableListOf<TravelSchedule>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        recyclerView = findViewById(R.id.rvSchedules)
        recyclerView.layoutManager = LinearLayoutManager(this)

        scheduleAdapter = ScheduleAdapter(scheduleList) { schedule ->
            addToWishlist(schedule)
        }
        recyclerView.adapter = scheduleAdapter

        fetchSchedules()
    }

    private fun fetchSchedules() {
        val apiService = RetrofitClient.instance.create(ApiService::class.java)
        apiService.getAllSchedules("MbRc10", "schedules")
            .enqueue(object : Callback<List<TravelSchedule>> {
                override fun onResponse(
                    call: Call<List<TravelSchedule>>,
                    response: Response<List<TravelSchedule>>
                ) {
                    if (response.isSuccessful) {
                        scheduleList.clear()
                        response.body()?.let { scheduleList.addAll(it) }
                        scheduleAdapter.notifyDataSetChanged()
                    }
                }

                override fun onFailure(call: Call<List<TravelSchedule>>, t: Throwable) {
                }
            })
    }

    private fun addToWishlist(schedule: TravelSchedule) {
    }
}