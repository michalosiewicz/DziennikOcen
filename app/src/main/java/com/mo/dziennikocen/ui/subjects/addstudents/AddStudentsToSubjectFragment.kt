package com.mo.dziennikocen.ui.subjects.addstudents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.mo.dziennikocen.R
import com.mo.dziennikocen.constants.Constants
import com.mo.dziennikocen.databinding.FragmentAddStudentsToSubjectBinding
import com.mo.dziennikocen.providers.snackbar.SnackBarProvider
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AddStudentsToSubjectFragment : Fragment() {

    private val addStudentsToSubjectViewModel: AddStudentsToSubjectViewModel by viewModel() {
        parametersOf(
            arguments?.getString("name") ?: Constants.EMPTY_STRING
        )
    }
    private val snackBarProvider: SnackBarProvider by inject()
    private lateinit var binding: FragmentAddStudentsToSubjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_add_students_to_subject, container, false
        )
        return binding.apply {
            viewModel = this@AddStudentsToSubjectFragment.addStudentsToSubjectViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        addStudentsToSubjectViewModel.addStudentSuccess.observe(viewLifecycleOwner) {
            activity?.let { activity ->
                snackBarProvider.successSnackBar(it, activity)
            }
            val bundle = bundleOf("name" to arguments?.getString("name"))
            findNavController().navigate(
                R.id.action_addStudentsToSubjectFragment_to_subjectDetailsFragment,
                bundle
            )
        }
    }
}