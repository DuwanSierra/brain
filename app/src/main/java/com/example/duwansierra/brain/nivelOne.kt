package com.example.duwansierra.brain


import android.content.Context
import android.os.AsyncTask
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import android.view.ViewParent
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView


class nivelOne(var contexto:Context):  AsyncTask<Void, Int, Void>() {
    lateinit var comunicador : Comunicador
    var tiempoInicial:Long= 0
    var tiempoFinal:Long=0
    var tiempoTotal:Long=0
    var ganador:String=""
    override fun onPreExecute() {
        super.onPreExecute()
        tiempoInicial=System.currentTimeMillis()
       comunicador = contexto as Comunicador
        Log.d("PreExecute","Entro"+comunicador)
    }

    override fun doInBackground(vararg params: Void?): Void? {
        for(i in 9 downTo  0){
            Thread.sleep(1000)
            publishProgress(i)
        }
        return null
    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        if(values[0]!! <=3){
            comunicador.enviar("?")
        }
        else{
            comunicador.enviar(""+values[0])
        }


    }

    override fun onCancelled() {
        super.onCancelled()
        tiempoFinal=System.currentTimeMillis()
        tiempoTotal=(tiempoFinal-tiempoInicial)
        if(tiempoTotal>9200 && tiempoTotal<9900){
            comunicador.enviar("Ganador: "+ganador+" "+((10)-((tiempoFinal-tiempoInicial).toFloat()/1000))+" segundos")
        }
        else{
            comunicador.enviar("Perdedor: "+ganador+" "+((10)-((tiempoFinal-tiempoInicial).toFloat()/1000))+" segundos")
        }


    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        comunicador.enviar("AMBOS PIERDEN, REINICIANDO!")

    }

    public interface Comunicador{
        public fun enviar(texto: String)
    }

}