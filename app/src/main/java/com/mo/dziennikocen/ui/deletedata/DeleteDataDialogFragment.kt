package com.mo.dziennikocen.ui.deletedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.mo.dziennikocen.R
import com.mo.dziennikocen.constants.Constants.CORRECT_DELETE_DATA
import com.mo.dziennikocen.databinding.FragmentDeleteDataDialogBinding
import com.mo.dziennikocen.providers.snackbar.SnackBarProvider
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class DeleteDataDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentDeleteDataDialogBinding
    private val viewModel: DeleteDataViewModel by viewModel()
    private val snackBarProvider: SnackBarProvider by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_delete_data_dialog,
            container,
            false
        )

        return binding.apply {
            viewModel = this@DeleteDataDialogFragment.viewModel
            lifecycleOwner = viewLifecycleOwner
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.deleteButton.setOnClickListener {
            viewModel.deleteData()
            activity?.let { activity ->
                snackBarProvider.successSnackBar(CORRECT_DELETE_DATA, activity)
            }
            findNavController().navigate(R.id.action_deleteDataDialogFragment_to_menuFragment)
        }
    }
}