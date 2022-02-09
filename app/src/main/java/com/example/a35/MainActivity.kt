package com.example.a35

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    private val dataModel: DataModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (dataModel.areSwapper.value == null)
            dataModel.areSwapper.value = false

        dataModel.areSwapper.observe(this, {
            if (dataModel.areSwapper.value == false) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.place_holder_1, RedFragment.newInstance())
                    .commit()
                setContentView(R.layout.activity_main)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.place_holder_2, BlueFragment.newInstance())
                    .commit()
            }
            else{
                supportFragmentManager.beginTransaction()
                    .replace(R.id.place_holder_2, RedFragment.newInstance())
                    .commit()
                setContentView(R.layout.activity_main)
                supportFragmentManager.beginTransaction()
                    .replace(R.id.place_holder_1, BlueFragment.newInstance())
                    .commit()
            }

        })
    }

    fun onClick(view: android.view.View) {
        dataModel.areSwapper.value = dataModel.areSwapper.value == false
    }
}