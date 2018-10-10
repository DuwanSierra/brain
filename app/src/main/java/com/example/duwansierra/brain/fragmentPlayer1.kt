package com.example.duwansierra.brain

import android.content.Context
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.Constraints
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.LoaderManager
import android.support.v4.content.AsyncTaskLoader
import android.support.v4.content.Loader
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView


class fragmentPlayer1 : Fragment{

    public lateinit var layoutPrincipal:ConstraintLayout

    public constructor(){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_player_1, container, false)
        layoutPrincipal = view.findViewById(R.id.constraintLayout)
        return view

    }

     fun recibirMensaje(mensaje: String){
             layoutPrincipal.removeAllViewsInLayout()
             var texto: TextView = TextView(context)
             texto.text=mensaje
             texto.textSize= 32F
             texto.tag="TextView1"
             layoutPrincipal.addView(texto)
             val params = texto.layoutParams as ConstraintLayout.LayoutParams
             params.leftToRight = layoutPrincipal.id
             params.topToTop = layoutPrincipal.id
             params.bottomToBottom = layoutPrincipal.id
             params.leftToLeft=layoutPrincipal.id
             texto.requestLayout()

     }
    fun recibirMensaje2(mensaje: String){
        layoutPrincipal.removeAllViewsInLayout()
        var datos=mensaje.split(",")
        var texto=TextView(this.context)
        texto.text=datos[0]
        texto.setTextColor(datos[1].toInt())
        texto.textSize= 32F
        layoutPrincipal.addView(texto)
        val params = texto.layoutParams as ConstraintLayout.LayoutParams
        params.leftToRight = layoutPrincipal.id
        params.topToTop = layoutPrincipal.id
        params.bottomToBottom = layoutPrincipal.id
        params.leftToLeft=layoutPrincipal.id
        texto.requestLayout()
    }
}
