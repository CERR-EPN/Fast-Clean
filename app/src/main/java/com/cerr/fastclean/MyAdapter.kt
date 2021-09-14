package com.cerr.fastclean

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val listEmpresas : ArrayList<Empresas>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener{
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: onItemClickListener){
        mListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.empresas_item,
            parent,false)
        return MyViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = listEmpresas[position]
        holder.nombreEmpresa.text = currentitem.empresa
        holder.descripcion.text = currentitem.descriocion
        holder.precio.text = currentitem.precio
    }

    override fun getItemCount(): Int {
        return listEmpresas.size
    }

    class MyViewHolder(itemView : View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val nombreEmpresa : TextView = itemView.findViewById(R.id.tvnombreEmpresa)
        val descripcion : TextView = itemView.findViewById(R.id.tvdescripcion)
        val precio : TextView = itemView.findViewById(R.id.tvprecio)
        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }
}