package com.mo.dziennikocen.ui.subjects.create

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.mo.dziennikocen.R
import com.mo.dziennikocen.databinding.FragmentCreateSubjectBinding
import com.mo.dziennikocen.extensions.spinnerAdapter
import com.mo.dziennikocen.providers.snackbar.SnackBarProvider
import org.koin.android.ext.android.bind
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.core.content.ContextCompat.getSystemService

class CreateSubjectFragment : Fragment() {

    private lateinit var binding: FragmentCreateSubjectBinding
    private val viewModel: CreateSubjectViewModel by viewModel()
    private val snackBarProvider: SnackBarProvider by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_subject, container, false
        )
        return binding.apply {
            viewModel = this@CreateSubjectFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.timePickerStart.setIs24HourView(true)
        binding.timePickerEnd.setIs24HourView(true)

        binding.daysSpinner.adapter = requireActivity().spinnerAdapter(R.array.days_of_week)

        binding.subjectCreate.setOnClickListener {
            viewModel.addSubject(binding.daysSpinner.selectedItem.toString())
        }

        viewModel.createSubjectSuccess.observe(viewLifecycleOwner) {
            findNavController().navigate(R.id.action_createSubjectFragment_to_subjectsFragment)
            activity?.let { activity ->
                snackBarProvider.successSnackBar(it, activity)
            }
        }

        viewModel.createSubjectError.observe(viewLifecycleOwner) {
            activity?.let { activity ->
                snackBarProvider.errorSnackBar(it, activity)
            }
        }

        binding.subjectName.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                val imm: InputMethodManager =
                    activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0)
            }
        }
    }
}