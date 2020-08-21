package com.hadi.android.custom.dictionary.presenter.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.presenter.callback.OnToolbarContentChangeListener
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnToolbarContentChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false);

    }


    override fun onToolbarTitleChanged(title: String) {
        txt_toolbar_title.text = title
    }

    override fun onToolbarIconChanged(icon: Int) {
        img_toolbar_icon.setImageResource(icon)
    }

}