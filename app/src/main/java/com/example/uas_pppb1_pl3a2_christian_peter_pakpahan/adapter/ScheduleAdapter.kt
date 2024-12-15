package com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.R
import com.example.uas_pppb1_pl3a2_christian_peter_pakpahan.models.TravelSchedule

class ScheduleAdapter(
    private val schedules: List<TravelSchedule>,
    private val onFavoriteClick: (TravelSchedule) -> Unit
) : RecyclerView.Adapter<ScheduleAdapter.ScheduleViewHolder>() {

    inner class ScheduleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvScheduleName: TextView = itemView.findViewById(R.id.tvScheduleName)
        val tvScheduleDate: TextView = itemView.findViewById(R.id.tvScheduleDate)
        val btnFavorite: Button = itemView.findViewById(R.id.btnFavorite)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ScheduleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false)
        return ScheduleViewHolder(view)
    }

    override fun onBindViewHolder(holder: ScheduleViewHolder, position: Int) {
        val schedule = schedules[position]
        holder.tvScheduleName.text = schedule.name
        holder.tvScheduleDate.text = schedule.date

        holder.btnFavorite.setOnClickListener {
            onFavoriteClick(schedule)
        }
    }

    override fun getItemCount(): Int = schedules.size
}