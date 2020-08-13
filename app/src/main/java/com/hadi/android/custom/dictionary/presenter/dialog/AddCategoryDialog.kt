package com.hadi.android.custom.dictionary.presenter.fragment

import android.app.ActionBar
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.PrecomputedText
import android.view.*
import android.widget.FrameLayout
import android.widget.Toast
import androidx.core.view.marginLeft
import androidx.fragment.app.DialogFragment
import androidx.navigation.navGraphViewModels
import com.hadi.android.custom.dictionary.R
import kotlinx.android.synthetic.main.dialog_add_category.*
import kotlin.concurrent.fixedRateTimer

class AddCategoryDialog : DialogFragment() {

    override fun onStart() {
        super.onStart()
        //to make full screen width
        val a = dialog?.apply {
            window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val content = inflater.inflate(R.layout.dialog_add_category, container, false)
        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        return content
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btn_cancel.setOnClickListener{
            dismiss()
        }
        btn_save.setOnClickListener{
            if(edt_category_title.text.isEmpty()){
                edt_category_title.setError(getString(R.string.error_category_title_could_not_be_empty))
            } else {
                Toast.makeText(context, "category title: ${edt_category_title.text.toString()} saved", Toast.LENGTH_SHORT).show()
                dismiss()
            }

        }
    }

}