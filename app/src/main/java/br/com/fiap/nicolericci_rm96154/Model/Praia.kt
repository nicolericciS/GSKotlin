package br.com.fiap.nicolericci_rm96154.Model

import br.com.fiap.nicolericci_rm96154.viewmodel.PraiasViewModel

data class Praia(
    val nome: String,
    val cidade: String,
    val estado: String,
    val onRemove: (Praia) -> Unit
)
