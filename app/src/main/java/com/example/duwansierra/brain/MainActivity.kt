package com.example.duwansierra.brain

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

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

    }
    fun ShowFragmentPlayer1(){
        val manager=supportFragmentManager
        val transactio= manager.beginTransaction()
        val fragment = fragmentPlayer1()
        transactio.replace(R.id.fragmentPlayer1,fragment)
        transactio.addToBackStack(null)
        transactio.commit()


       }
    fun ShowFragmentPlayer2(){
        val manager=supportFragmentManager
        val transactio= manager.beginTransaction()
        val fragment = fragmentPlayer2()
        transactio.replace(R.id.fragmentPlayer2,fragment)
        transactio.addToBackStack(null)
        transactio.commit()

    }
}
