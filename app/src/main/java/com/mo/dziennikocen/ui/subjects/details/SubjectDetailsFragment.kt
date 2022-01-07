package com.mo.dziennikocen.ui.subjects.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.mo.dziennikocen.R
import com.mo.dziennikocen.constants.Constants.EMPTY_STRING
import com.mo.dziennikocen.databinding.FragmentSubjectDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class SubjectDetailsFragment : Fragment() {

    private lateinit var binding: FragmentSubjectDetailsBinding
    private val subjectDetailsViewModel: SubjectDetailsViewModel by viewModel() {
        parametersOf(
            arguments?.getString("name") ?: EMPTY_STRING
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_subject_details, container, false
        )
        return binding.apply {
            viewModel = this@SubjectDetailsFragment.subjectDetailsViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            val bundle = bundleOf("name" to arguments?.getString("name"))
            findNavController().navigate(
                R.id.action_subjectDetailsFragment_to_addStudentsToSubjectFragment,
                bundle
            )
        }
    }
}