package com.mo.dziennikocen.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mo.data.models.Subject
import com.mo.dziennikocen.databinding.ItemRecylerViewBinding
import com.mo.dziennikocen.mappers.DayOfWeekToStringMapperImpl

class SubjectsAdapter(val onItemClick: (String) -> Unit) :
    RecyclerView.Adapter<SubjectsAdapter.ViewHolder>() {

    private val listSubjects = mutableListOf<Subject>()

    @SuppressLint("NotifyDataSetChanged")
    fun addNewItems(subjects: List<Subject>) {
        listSubjects.clear()
        listSubjects.addAll(subjects)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemRecylerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        private val dayOfWeekToStringMapper = DayOfWeekToStringMapperImpl()

        fun bind(subject: Subject) {
            val name = subject.name
            val date =
                dayOfWeekToStringMapper.map(subject.dayOfWeek) +
                        " " + subject.timeStart + " - " + subject.timeEnd
            binding.firstText.text = name
            binding.secondText.text = date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecylerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listSubjects[position])

        holder.binding.root.setOnClickListener {
            onItemClick(listSubjects[position].name)
        }
    }

    override fun getItemCount(): Int = listSubjects.size
}