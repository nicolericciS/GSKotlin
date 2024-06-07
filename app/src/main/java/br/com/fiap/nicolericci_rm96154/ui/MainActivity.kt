package br.com.fiap.nicolericci_rm96154.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.fiap.nicolericci_rm96154.adapter.ListaPraiasAdapter
import br.com.fiap.nicolericci_rm96154.databinding.ActivityMainBinding
import br.com.fiap.nicolericci_rm96154.viewmodel.PraiasViewModel

class MainActivity : AppCompatActivity() {

    val viewModel: PraiasViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView2
        val praiasAdapter = ListaPraiasAdapter()

        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        recyclerView.adapter = praiasAdapter

        val button = binding.button3
        val edtNome = binding.edtNome
        val edtCidade = binding.edtCidade
        val edtEstado = binding.edtEstado

        button.setOnClickListener {
            /*if (edtNome.isEmpty()) {
                edtNome.error = "Preencha um valor "
                return@setOnClickListener
            } else if (edtCidade.isEmpty()) {
                edtCidade.error = "Preencha um valor "
                return@setOnClickListener
            } else if (edtEstado.isEmpty()) {
                edtEstado.error = "Preencha um valor"
                return@setOnClickListener
            }*/

            viewModel.addItem(edtNome.toString(), edtCidade.toString(), edtEstado.toString())
        }

        viewModel.itemsLiveData.observe(this) { praias ->
            praiasAdapter.updatePraias(praias)

        }


    }
}