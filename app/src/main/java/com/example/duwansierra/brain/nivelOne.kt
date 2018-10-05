package com.example.duwansierra.brain


import android.content.Context
import android.os.AsyncTask
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.widget.Button
import android.widget.TextView


class nivelOne(): AsyncTask<Void, Int, Void>() {

    override fun doInBackground(vararg params: Void?): Void? {
        for(i in 9.. 0){
            Thread.sleep(10000)
            publishProgress(i)
        }
        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }
}