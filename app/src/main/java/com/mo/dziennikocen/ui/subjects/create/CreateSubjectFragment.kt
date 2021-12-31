package com.mo.dziennikocen.ui.subjects.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import com.mo.dziennikocen.R
import com.mo.dziennikocen.databinding.FragmentCreateSubjectBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CreateSubjectFragment : Fragment() {

    private lateinit var binding: FragmentCreateSubjectBinding
    private val viewModel: CreateSubjectViewModel by viewModel()

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

        val adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.days_of_week,
            android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.daysSpinner.adapter = adapter
    }
}