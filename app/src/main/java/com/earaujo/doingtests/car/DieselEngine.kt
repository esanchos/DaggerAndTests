package com.earaujo.doingtests.car

import android.util.Log
import javax.inject.Inject

class DieselEngine @Inject constructor(private val horsePower: Int): Engine {
    private val TAG = "Car"

    override fun start() {
        Log.d(TAG, "Diesel engine started. Horsepower: $horsePower")
    }
}