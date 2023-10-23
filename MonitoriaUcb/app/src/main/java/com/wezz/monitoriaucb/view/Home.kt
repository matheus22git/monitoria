package com.wezz.monitoriaucb.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.wezz.monitoriaucb.R
import com.wezz.monitoriaucb.adapter.ServicosAdapter
import com.wezz.monitoriaucb.databinding.ActivityHomeBinding
import com.wezz.monitoriaucb.model.Servicos

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var servicosAdapter: ServicosAdapter
    private val listaServicos: MutableList<Servicos> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()
        val nome = intent.extras?.getString("nome")

        binding.txtNomeUsuario.text = "Bem-vindo(a), $nome"
        val recyclerViewServicos = binding.recyclerViewServicos
        recyclerViewServicos.layoutManager = GridLayoutManager(this, 2)
        servicosAdapter = ServicosAdapter(this,listaServicos)
        recyclerViewServicos.setHasFixedSize(true)
        recyclerViewServicos. adapter = servicosAdapter

        getServicos()
        binding.btAgendar.setOnClickListener {
            val intent = Intent(this,Agendamento::class.java)
            intent.putExtra("nome",nome)
            startActivity(intent)
        }

    }

    private fun getServicos(){


        val servico1 = Servicos(R.drawable.img1, "Monitores")
        listaServicos.add(servico1)

        val servico2 = Servicos(R.drawable.img2, "Livros")
        listaServicos.add(servico2)

        val servico3 = Servicos(R.drawable.img3, "Horários")
        listaServicos.add(servico3)

        val servico4 = Servicos(R.drawable.img4, "Chat")
        listaServicos.add(servico4)
    }

}