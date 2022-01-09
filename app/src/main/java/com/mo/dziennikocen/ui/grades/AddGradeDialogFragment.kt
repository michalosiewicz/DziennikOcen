package com.mo.dziennikocen.ui.grades

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.mo.dziennikocen.R
import com.mo.dziennikocen.constants.Constants.EMPTY_STRING
import com.mo.dziennikocen.databinding.DialogFragmentAddGradeBinding
import com.mo.dziennikocen.extensions.spinnerAdapter
import com.mo.dziennikocen.providers.snackbar.SnackBarProvider
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class AddGradeDialogFragment : DialogFragment() {

    private lateinit var binding: DialogFragmentAddGradeBinding
    private val viewModel: AddGradeDialogViewModel by viewModel() {
        parametersOf(
            arguments?.getString("studentNumber") ?: EMPTY_STRING,
            arguments?.getString("subjectName") ?: EMPTY_STRING
        )
    }
    private val snackBarProvider: SnackBarProvider by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.dialog_fragment_add_grade, container, false
        )
        return binding.apply {
            viewModel = this@AddGradeDialogFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.gradesSpinner.adapter = requireActivity().spinnerAdapter(R.array.grades)

        binding.addGrade.setOnClickListener {
            viewModel.addGrade(binding.gradesSpinner.selectedItem.toString())
        }

        viewModel.addGradeSuccess.observe(viewLifecycleOwner) {
            activity?.let { activity ->
                snackBarProvider.successSnackBar(it, activity)
            }
            val bundle = bundleOf("name" to arguments?.getString("subjectName"))
            findNavController().navigate(
                R.id.action_addGradeFragment_to_subjectDetailsFragment, bundle
            )
        }
    }
}