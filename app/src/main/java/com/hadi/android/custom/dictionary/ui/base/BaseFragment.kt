package com.hadi.android.custom.dictionary.ui.base

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hadi.android.custom.dictionary.ui.callbacks.ToolbarContentManipulator

abstract class BaseFragment : Fragment() {

    companion object {
        const val ICON_NONE = 0
    }

    private var toolbarContentManipulator: ToolbarContentManipulator? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ToolbarContentManipulator) {
            toolbarContentManipulator = context
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        toolbarContentManipulator?.setTitle(getToolbarTitle())
        toolbarContentManipulator?.setIcon(getToolbarIcon())
    }

    abstract fun getToolbarTitle(): String
    abstract fun getToolbarIcon(): Int

}