package br.com.fiap.nicolericci_rm96154.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.nicolericci_rm96154.Model.Praia

class PraiasViewModel : ViewModel() {
    private var praias = mutableListOf<Praia>()
    val itemsLiveData = MutableLiveData<List<Praia>>()

    fun addItem(nome: String, cidade: String, estado: String) {
        val praia =
            Praia( nome = nome, cidade = cidade, estado = estado, onRemove = ::removeItem)
        praias.add(praia)
        itemsLiveData.value = praias
    }

    private fun removeItem(praia: Praia) {
        praias.remove(praia)
        itemsLiveData.value = praias
    }
}