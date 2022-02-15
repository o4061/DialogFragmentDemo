package com.userfaltakas.dialogfragmentdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.userfaltakas.dialogfragmentdemo.databinding.DialogOneBinding
import com.userfaltakas.dialogfragmentdemo.databinding.DialogTwoBinding
import com.userfaltakas.dialogfragmentdemo.databinding.FragmentStartBinding

class StartFragment : Fragment() {
    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStartBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.firstBtn.setOnClickListener {
            val dialogBinding = DialogOneBinding.inflate(LayoutInflater.from(requireContext()))
            ContentViewDialog.Builder(requireContext())
                .setView(dialogBinding.root)
                .setIcon(dialogBinding.imageInfo, R.drawable.ic_info)
                .setTitle(
                    dialogBinding.title,
                    "Υπάρχει διαθέσιμη ενημέρωση της εφαρμογής. Παρακαλούμε συνδεθείτε σε wifi ή ethernet για να γίνει η λήψη της ενημέρωσης"
                )
                .setPositiveButton(dialogBinding.confirmButton) { dialog, _ ->
                    dialog.cancel()
                }.setNegativeButton(dialogBinding.cancelButton) { dialog, _ ->
                    dialog.cancel()
                }
                .setCancelable(false)
                .show()
        }

        binding.secondBtn.setOnClickListener {
            val dialogBinding = DialogTwoBinding.inflate(LayoutInflater.from(requireContext()))
            ContentViewDialog.Builder(requireContext())
                .setView(dialogBinding.root)
                .setIcon(dialogBinding.imageInfo, R.drawable.ic_info)
                .setTitle(dialogBinding.title, "Υπάρχει διαθέσιμη ενημέρωση")
                .setMessage(
                    dialogBinding.message,
                    "Παρακαλούμε συνδεθείτε σε wifi ή ethernet για να γίνει η λήψη της ενημέρωσης"
                )
                .setPositiveButton(dialogBinding.confirmButton, "ΝΑΙ") { dialog, _ ->
                    dialog.dismiss()
                }.setNegativeButton(dialogBinding.cancelButton, "ΟΧΙ") { dialog, _ ->
                    dialog.dismiss()
                }.setNeutralButton(dialogBinding.notesButton, "Release Notes") { dialog, _ ->
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
    }
}