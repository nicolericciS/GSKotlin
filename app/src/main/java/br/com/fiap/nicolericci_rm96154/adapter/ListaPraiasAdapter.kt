package br.com.fiap.nicolericci_rm96154.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.nicolericci_rm96154.Model.Praia
import br.com.fiap.nicolericci_rm96154.R

class ListaPraiasAdapter: RecyclerView.Adapter<ListaPraiasAdapter.PraiaViewHolder>() {

    private var praias = listOf<Praia>()

    class PraiaViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvNome = view.findViewById<TextView>(R.id.tvNome)
        val tvCidade = view.findViewById<TextView>(R.id.tvCidade)
        val tvEstado = view.findViewById<TextView>(R.id.tvEstado)
        val btnDelete = view.findViewById<ImageButton>(R.id.imgBtnDelete)

        fun bind(praia: Praia){
            tvNome.text = praia.nome
            tvCidade.text = praia.cidade
            tvEstado.text = praia.estado
            btnDelete.setOnClickListener {
                praia.onRemove(praia)
            }
        }
    }

    fun updatePraias(novaPraia: List<Praia>){
        praias = novaPraia
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaPraiasAdapter.PraiaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_praia, parent, false)
        return PraiaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListaPraiasAdapter.PraiaViewHolder, position: Int) {
        val praia = praias[position]
        holder.bind(praia)
    }

    override fun getItemCount(): Int = praias.size
}