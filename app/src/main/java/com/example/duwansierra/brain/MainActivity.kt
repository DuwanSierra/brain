package com.example.duwansierra.brain

import android.graphics.Color
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener,nivelOne.Comunicador,nivelTwo.Comunicador {
    override fun enviar2(texto: String) {
        enviarMensaje21(texto)
        enviarMensaje22(texto)
        if(texto == "AMBOS PIERDEN, REINICIANDO!"){
            btnPlayerOne.setTextColor(Color.BLACK)
            btnPlayerTwo.setTextColor(Color.BLACK)
            nivel= nivelOne(this)
            nivel.execute()
        }
    }

    override fun enviar(texto: String) {
        enviarMensaje11(texto)
        enviarMensaje12(texto)
        var pal=texto.split(":")
        if(pal[0].toString()=="Ganador"){
            nivel2.execute()
            btnPlayerOne.setTextColor(Color.BLACK)
            btnPlayerTwo.setTextColor(Color.BLACK)
        }
        if(pal[0].toString()=="Perdedor"){
            btnPlayerOne.setTextColor(Color.BLACK)
            btnPlayerTwo.setTextColor(Color.BLACK)
            nivel= nivelOne(this)
            nivel.execute()
        }
        if(texto == "AMBOS PIERDEN, REINICIANDO!"){
            btnPlayerOne.setTextColor(Color.BLACK)
            btnPlayerTwo.setTextColor(Color.BLACK)
            nivel= nivelOne(this)
            nivel.execute()
        }
    }
    var nivel = nivelOne(this)
    var nivel2 = nivelTwo(this)
    lateinit var fragmento1:Fragment
    lateinit var fragmento2:Fragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
        ShowFragmentPlayer1()
        ShowFragmentPlayer2()
        this.btnPlayerOne.setOnClickListener(this)
        this.btnPlayerTwo.setOnClickListener(this)
        nivel.execute()

    }
    fun ShowFragmentPlayer1(){
        val manager=supportFragmentManager
        val transactio= manager.beginTransaction()
        val fragment = fragmentPlayer1()
        fragmento1=fragment
        transactio.replace(R.id.fragmentPlayer1,fragment)
        transactio.addToBackStack(null)
        transactio.commit()

       }
    fun ShowFragmentPlayer2(){
        val manager=supportFragmentManager
        val transactio= manager.beginTransaction()
        val fragment = fragmentPlayer2()
        fragmento2=fragment
        transactio.replace(R.id.fragmentPlayer2,fragment)
        transactio.addToBackStack(null)
        transactio.commit()

    }
    fun enviarMensaje11(texto: String){
        var fragment=getSupportFragmentManager().findFragmentById(R.id.fragmentPlayer1)
        if(fragment is fragmentPlayer1){
            var receptor=fragment
            receptor.recibirMensaje(texto)
        }
    }
    fun enviarMensaje12(texto: String){
        var fragment=getSupportFragmentManager().findFragmentById(R.id.fragmentPlayer2)
        if(fragment is fragmentPlayer2){
            var receptor=fragment
            receptor.recibirMensaje(texto)
        }
    }
    fun enviarMensaje21(texto: String){
        var fragment=getSupportFragmentManager().findFragmentById(R.id.fragmentPlayer1)
        if(fragment is fragmentPlayer1){
            var receptor=fragment
            receptor.recibirMensaje2(texto)
        }
    }
    fun enviarMensaje22(texto: String){
        var fragment=getSupportFragmentManager().findFragmentById(R.id.fragmentPlayer2)
        if(fragment is fragmentPlayer2){
            var receptor=fragment
            receptor.recibirMensaje2(texto)
        }
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnPlayerOne -> {
                if(nivel.status == AsyncTask.Status.RUNNING){
                    nivel.ganador="Jugador uno"
                    nivel.cancel(true)
                    btnPlayerOne.setTextColor(Color.GREEN)
                    btnPlayerTwo.setTextColor(Color.RED)
                }
                else if(nivel2.status == AsyncTask.Status.RUNNING){
                    nivel2.ganador="Jugador uno"
                    nivel2.cancel(true)
                    btnPlayerOne.setTextColor(Color.GREEN)
                    btnPlayerTwo.setTextColor(Color.RED)
                }


            }
            R.id.btnPlayerTwo -> {
                if(nivel.status == AsyncTask.Status.RUNNING){
                    nivel.ganador="Jugador dos"
                    nivel.cancel(true)
                    btnPlayerTwo.setTextColor(Color.GREEN)
                    btnPlayerOne.setTextColor(Color.RED)
                }
                else if(nivel2.status == AsyncTask.Status.RUNNING){
                    nivel2.ganador="Jugador dos"
                    nivel2.cancel(true)
                    btnPlayerTwo.setTextColor(Color.GREEN)
                    btnPlayerOne.setTextColor(Color.RED)
                }
            }
        }
    }



}
