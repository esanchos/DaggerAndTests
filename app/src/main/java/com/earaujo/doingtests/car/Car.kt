package com.earaujo.doingtests.car

import android.util.Log
import com.earaujo.doingtests.di.PerActivity
import javax.inject.Inject

@PerActivity
class Car @Inject constructor(
    private val engine: Engine,
    private val wheels: Wheels,
    private val driver: Driver) {
    private val TAG = "Car"

    @Inject
    fun enableRemote(remote: Remote) {
        remote.setListener(this)
    }

    fun drive() {
        this.engine.start()
        Log.d(TAG, "$driver drives $this")
    }
}