package com.hadi.android.custom.dictionary.presenter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.presenter.fragment.AddCategoryDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object{
        const val TAG_ADD_CATEGORY_DIALOG = "TAG_ADD_CATEGORY_DIALOG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        getSupportActionBar()?.setDisplayShowTitleEnabled(false);

        val addCategoryDialog = AddCategoryDialog();
        addCategoryDialog.isCancelable = false
        addCategoryDialog.show(supportFragmentManager, TAG_ADD_CATEGORY_DIALOG)

    }

}