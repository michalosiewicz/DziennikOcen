package com.mo.dziennikocen.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mo.data.models.Student
import com.mo.dziennikocen.databinding.ItemStudentWithGradesBinding

class StudentsToSubjectAdapter(
    val onItemClick: (String) -> Unit,
    val grades: (String) -> List<Double>
) : RecyclerView.Adapter<StudentsToSubjectAdapter.ViewHolder>() {

    private val listStudents = mutableListOf<Student>()

    @SuppressLint("NotifyDataSetChanged")
    fun addNewItems(students: List<Student>) {
        listStudents.clear()
        listStudents.addAll(students)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemStudentWithGradesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(student: Student, grades: List<Double>) {
            val studentName = student.studentSecondName + " " + student.studentName
            val studentNumber = "Numer albumu : " + student.studentNumber
            var gradesString = ""
            grades.forEach { grade ->
                gradesString += "$grade, "
            }
            gradesString = gradesString.dropLast(2)
            binding.name.text = studentName
            binding.number.text = studentNumber
            binding.grades.text = gradesString
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemStudentWithGradesBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listStudents[position], grades(listStudents[position].studentNumber))

        holder.binding.addGradeButton.setOnClickListener {
            onItemClick(listStudents[position].studentNumber)
        }
    }

    override fun getItemCount(): Int = listStudents.size
}