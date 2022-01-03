package com.mo.dziennikocen.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mo.data.models.Student
import com.mo.dziennikocen.databinding.ItemRecylerViewBinding

class StudentsAdapter :
    RecyclerView.Adapter<StudentsAdapter.ViewHolder>() {

    private val listStudents = mutableListOf<Student>()

    @SuppressLint("NotifyDataSetChanged")
    fun addNewItems(students: List<Student>) {
        listStudents.clear()
        listStudents.addAll(students)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemRecylerViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student) {
            val studentName = student.studentSecondName + " " + student.studentName
            val studentNumber = "Numer albumu : " + student.studentNumber
            binding.firstText.text = studentName
            binding.secondText.text = studentNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemRecylerViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStudents[position])
    }

    override fun getItemCount(): Int = listStudents.size
}