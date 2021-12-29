package com.mo.dziennikocen.ui.students.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mo.dziennikocen.R
import com.mo.dziennikocen.databinding.FragmentCreateStudentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateStudentFragment : Fragment() {

    private val viewModel: CreateStudentViewModel by viewModel()
    private lateinit var binding: FragmentCreateStudentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_student, container, false
        )
        return binding.apply {
            viewModel = this@CreateStudentFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }
}