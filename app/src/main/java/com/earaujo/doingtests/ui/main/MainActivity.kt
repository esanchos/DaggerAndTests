package com.earaujo.doingtests.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.earaujo.doingtests.DoingTests
import com.earaujo.doingtests.R
import com.earaujo.doingtests.car.Car
import com.earaujo.doingtests.di.DaggerActivityComponent
//import com.earaujo.doingtests.di.DaggerCarComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var car1: Car

    @Inject
    lateinit var car2: Car

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnGo.setOnClickListener {
            tvOutput.text = etInput.text
        }

        DaggerActivityComponent.builder()
            .horsePower(100)
            .engineCapacity(1400)
            .appComponent((application as DoingTests).appComponent)
            .build()
            .inject(this)

        car1.drive()
        car2.drive()
    }
}
