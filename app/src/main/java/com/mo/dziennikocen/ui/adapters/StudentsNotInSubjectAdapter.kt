package com.mo.dziennikocen.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mo.data.models.Student
import com.mo.dziennikocen.databinding.ItemAddStudentToSubjectBinding

class StudentsNotInSubjectAdapter(
    val onItemClick: (List<String>) -> Unit
) :
    RecyclerView.Adapter<StudentsNotInSubjectAdapter.ViewHolder>() {

    private val listStudents = mutableListOf<Student>()
    private val studentsSelected = mutableListOf<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun addNewItems(students: List<Student>) {
        listStudents.clear()
        listStudents.addAll(students)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemAddStudentToSubjectBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student) {
            val studentName = student.studentSecondName + " " + student.studentName
            val studentNumber = "Numer albumu : " + student.studentNumber
            binding.firstText.text = studentName
            binding.secondText.text = studentNumber
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemAddStudentToSubjectBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStudents[position])

        holder.binding.root.setOnClickListener {
            holder.binding.checkBox.isChecked = !holder.binding.checkBox.isChecked
            onBindClick(holder.binding, position)
        }

        holder.binding.checkBox.setOnClickListener {
            onBindClick(holder.binding, position)
        }
    }

    override fun getItemCount(): Int = listStudents.size

    private fun onBindClick(binding: ItemAddStudentToSubjectBinding, position: Int) {
        if (binding.checkBox.isChecked) {
            studentsSelected.add(listStudents[position].studentNumber)
        } else {
            studentsSelected.remove(listStudents[position].studentNumber)
        }
        onItemClick(studentsSelected)
    }
}