package com.mo.dziennikocen.ui.students

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.mo.dziennikocen.R
import com.mo.dziennikocen.databinding.FragmentStudentsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StudentsFragment : Fragment() {

    private val studentsViewModel: StudentsViewModel by viewModel()
    private lateinit var binding: FragmentStudentsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_students,
            container,
            false
        )

        return binding.apply {
            viewModel = this@StudentsFragment.studentsViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_studentsFragment_to_menuFragment)
                }
            })

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_studentsFragment_to_createStudentFragment)
        }
    }
}