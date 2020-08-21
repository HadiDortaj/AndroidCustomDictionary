package com.hadi.android.custom.dictionary.presenter

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.hadi.android.custom.dictionary.presenter.callback.OnToolbarContentChangeListener

abstract class BaseFragment : Fragment() {

    private var onToolbarContentChangeListener: OnToolbarContentChangeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnToolbarContentChangeListener) {
            onToolbarContentChangeListener = context
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        onToolbarContentChangeListener?.setToolbarTitle(getToolbarTitle())
        onToolbarContentChangeListener?.setToolbarIcon(getToolbarIcon())
    }

    abstract fun getToolbarTitle(): String
    abstract fun getToolbarIcon(): Int

}