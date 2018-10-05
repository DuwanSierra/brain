package com.example.duwansierra.brain

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var fragmento1:Fragment
    lateinit var fragmento2:Fragment
    var nivel:nivelOne=nivelOne()
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
    public fun enviarMensaje1(texto: nivelOne){
        var fragment=getSupportFragmentManager().findFragmentById(R.id.fragmentPlayer1)
        if(fragment is fragmentPlayer1){
            var receptor=fragment
            receptor.enviarMensaje(texto)
        }
    }
    public fun enviarMensaje2(texto: nivelOne){
        var fragment=getSupportFragmentManager().findFragmentById(R.id.fragmentPlayer2)
        if(fragment is fragmentPlayer2){
            var receptor=fragment
            receptor.enviarMensaje(texto)
        }
    }
    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btnPlayerOne -> {

                enviarMensaje1(nivel)
            }
            R.id.btnPlayerTwo -> {

                enviarMensaje2(nivel)
            }
        }
    }



}
