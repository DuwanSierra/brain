package com.example.duwansierra.brain

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class fragmentPlayer2 : Fragment(){
    lateinit var layoutPrincipal:ConstraintLayout
    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.fragment_player_2, container, false)
        layoutPrincipal = view.findViewById(R.id.constraintLayout)
        return view
    }

    fun enviarMensaje(mensaje: nivelOne){
        var boton: Button = Button(context)
        var texto: TextView = TextView(context)
        boton.text= mensaje.status.toString()
        texto.text= mensaje.status.toString()
        layoutPrincipal.addView(boton)
        layoutPrincipal.addView(texto)
        val params = texto.layoutParams as ConstraintLayout.LayoutParams
        params.leftToRight = layoutPrincipal.id
        params.topToTop = layoutPrincipal.id
        params.bottomToBottom = layoutPrincipal.id
        texto.requestLayout()
    }
}