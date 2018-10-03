package com.example.duwansierra.brain


import android.os.AsyncTask



class nivelOne(var fragmen:fragmentPlayer1): AsyncTask<Void, Int, Void>() {
    var fragmento: fragmentPlayer1=fragmen
    override fun doInBackground(vararg params: Void?): Void? {
        for(i in 9.. 0){
            Thread.sleep(1000)
            publishProgress(i)
        }
        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
    }
}