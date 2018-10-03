package com.example.duwansierra.brain

import android.content.Context
import android.os.Bundle
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
import kotlinx.android.synthetic.main.fragment_player_1.*
import kotlinx.android.synthetic.main.fragment_player_1.view.*


class fragmentPlayer1 : Fragment{

    public lateinit var texto:TextView
    public constructor(){

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =inflater!!.inflate(R.layout.fragment_player_1,container, false)
        texto=view.findViewById(R.id.textView)
        return view
    }


    public fun enviarMensaje(mensaje: String){
        texto.text="mensaje del activity:"+mensaje
     }





}
