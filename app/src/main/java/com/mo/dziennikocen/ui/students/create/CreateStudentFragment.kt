package com.mo.dziennikocen.ui.students.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.mo.dziennikocen.R
import com.mo.dziennikocen.databinding.FragmentCreateStudentBinding
import com.mo.dziennikocen.providers.snackbar.SnackBarProvider
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateStudentFragment : Fragment() {

    private val viewModel: CreateStudentViewModel by viewModel()
    private val snackBarProvider: SnackBarProvider by inject()
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.createStudentSuccess.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_createStudentFragment_to_studentsFragment)
            activity?.let { activity ->
                snackBarProvider.successSnackBar(it, activity)
            }
        }

        viewModel.createStudentError.observe(viewLifecycleOwner) {
            activity?.let { activity ->
                snackBarProvider.errorSnackBar(it, activity)
            }
        }
    }
}