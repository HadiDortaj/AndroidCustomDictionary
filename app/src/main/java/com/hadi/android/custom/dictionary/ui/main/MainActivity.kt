package com.hadi.android.custom.dictionary.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.ui.callbacks.ToolbarContentManipulator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ToolbarContentManipulator {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false);
    }

    override fun setTitle(title: String) {
        txtToolbarTitle.text = title
    }

    override fun setIcon(icon: Int) {
        imgToolbarIcon.setImageResource(icon)
    }

}