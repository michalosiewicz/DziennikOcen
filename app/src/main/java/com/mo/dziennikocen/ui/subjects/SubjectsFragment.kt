package com.mo.dziennikocen.ui.subjects

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.mo.dziennikocen.R
import com.mo.dziennikocen.databinding.FragmentSubjectsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SubjectsFragment : Fragment() {

    private val subjectsViewModel: SubjectsViewModel by viewModel()
    private lateinit var binding: FragmentSubjectsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_subjects, container, false
        )
        return binding.apply {
            viewModel = this@SubjectsFragment.subjectsViewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addButton.setOnClickListener {
            findNavController().navigate(R.id.action_subjectsFragment_to_createSubjectFragment)
        }

        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    findNavController().navigate(R.id.action_subjectsFragment_to_menuFragment)
                }
            })
    }
}