package com.mo.dziennikocen.ui.subjects.create

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mo.dziennikocen.R
import com.mo.dziennikocen.databinding.FragmentCreateSubjectBinding

class CreateSubjectFragment : Fragment() {

    private lateinit var binding: FragmentCreateSubjectBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_create_subject, container, false
        )
        return binding.root
    }

}