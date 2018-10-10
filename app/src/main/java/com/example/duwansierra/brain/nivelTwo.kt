package com.example.duwansierra.brain


import android.content.Context
import android.os.AsyncTask
import android.util.Log


class nivelTwo(var contexto: Context):  AsyncTask<Void, String, Void>() {
    lateinit var comunicador : Comunicador
    val palabrasCorrectas= arrayOfNulls<String>(5)
    val palabrasIncorrectas= arrayOfNulls<String>(5)
    var ganador:String=""
    var palabra:String=""
    override fun onPreExecute() {
        super.onPreExecute()
        cargarPalabras()
        comunicador = contexto as Comunicador
        Log.d("PreExecuted","Entro 2")
    }

    override fun doInBackground(vararg params: Void?): Void? {
        for(i in 0..4){
            Thread.sleep(2000)
            palabra=palabrasIncorrectas.get(i).toString()
            publishProgress(palabrasIncorrectas.get(i).toString())
        }
        return null
    }

    override fun onProgressUpdate(vararg values: String?) {
        super.onProgressUpdate(*values)
        comunicador.enviar2(values[0].toString())
    }

    override fun onCancelled() {
        super.onCancelled()
        var final=palabra.split(",")
        if(final[2].toInt()==1){
            comunicador.enviar2("Ganador:"+ganador+",-1")
        }
        else{
            comunicador.enviar2("Perdedor:"+ganador+",-1")
        }
    }

    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
        comunicador.enviar2("AMBOS PIERDEN, REINICIANDO!")
    }
    fun cargarPalabras(){
        palabrasCorrectas.set(0,"BLANCO,-1,1")
        palabrasCorrectas.set(1,"GRIS,-7829368,1")
        palabrasCorrectas.set(2,"AZUL,-16776961,1")
        palabrasCorrectas.set(3,"AMARILLO,-256,1")
        palabrasCorrectas.set(4,"GREEN,-16711936,1")
        palabrasIncorrectas.set(0,"BLANCO,-16776961,0")
        palabrasIncorrectas.set(1,"GRIS,-16711936,0")
        palabrasIncorrectas.set(2,"AZUL,-256,0")
        palabrasIncorrectas.set(3,"AMARILLO,-1,0")
        palabrasIncorrectas.set(4,"GREEN,-7829368,0")
        var ran=(Math.random()*5).toInt()
        palabrasIncorrectas.set(ran,palabrasCorrectas.get(ran))
    }
    public interface Comunicador{
        public fun enviar2(texto: String)
    }

}