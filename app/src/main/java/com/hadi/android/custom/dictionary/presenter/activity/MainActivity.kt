package com.hadi.android.custom.dictionary.presenter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.hadi.android.custom.dictionary.R
import com.hadi.android.custom.dictionary.presenter.categorylist.CategoryListFragment
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

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.container,
            CategoryListFragment {
                Toast.makeText(this@MainActivity, "show add category", Toast.LENGTH_SHORT).show()
            })
        fragmentTransaction.commit()
    }

}