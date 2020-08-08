package com.hadi.android.custom.dictionary.presenter.fragment

import android.app.ActionBar
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.PrecomputedText
import android.view.*
import android.widget.FrameLayout
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

}