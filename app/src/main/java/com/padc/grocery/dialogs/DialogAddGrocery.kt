package com.padc.grocery.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.padc.grocery.R
import kotlinx.android.synthetic.main.dialog_add_grocery.view.*

class GroceryDialogFragment : DialogFragment() {

    companion object {
        const val TAG_ADD_GROCERY_DIALOG = "TAG_ADD_GROCERY_DIALOG"

        fun newFragment(): GroceryDialogFragment {
            return GroceryDialogFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_add_grocery, container, false)
        view.btnAddGrocery.setOnClickListener {
            dismiss()
        }
        return view
    }
}