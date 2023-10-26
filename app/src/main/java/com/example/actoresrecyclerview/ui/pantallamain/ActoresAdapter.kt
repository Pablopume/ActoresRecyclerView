package com.example.actoresrecyclerview.ui.pantallamain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.actoresrecyclerview.domain.modelo.Actores
import com.example.recyclerview.R
import com.example.recyclerview.databinding.ItemActorBinding

class ActoresAdapter(
    private var actores: List<Actores>,
    private val onClickButton: (String) -> Unit)
    : RecyclerView.Adapter<ActoresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActoresViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ActoresViewHolder(layoutInflater.inflate(R.layout.item_actor, parent, false))
    }

    override fun onBindViewHolder(holder: ActoresViewHolder, position: Int) {
        holder.render(actores[position], onClickButton)
    }
    override fun getItemCount(): Int = actores.size


fun cambiarLista(lista: List<Actores>) {
    actores = lista
    notifyDataSetChanged()
}
}

class ActoresViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemActorBinding.bind(view)

    fun render(actor: Actores,
               onClickButton: (String) -> Unit) {

        with(binding){
            tvNombre.text = actor.nombre
            tvPelicula.text = actor.peliculaFamosa
        }
        view.findViewById<TextView>(R.id.button2).setOnClickListener {
            onClickButton(actor.nombre)
        }
    }
}

