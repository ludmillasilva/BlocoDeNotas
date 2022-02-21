package com.ludmilla.blocodenotas

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import android.widget.Toast
import com.ludmilla.blocodenotas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val preferencia = PreferenciaAnotacao(applicationContext)
        val botaoSalvar = binding.fab

        botaoSalvar.setOnClickListener {

            val anotacaoRecuperado = binding.edtContainer.edtAnotacao.text.toString()

            if(anotacaoRecuperado == ""){
                Toast.makeText(this, "Digite alguma coisa.", Toast.LENGTH_SHORT).show()
            }else{
                preferencia.salvarAnotacao(anotacaoRecuperado)
                Toast.makeText(this, "Anotação foi salva com sucesso!",Toast.LENGTH_SHORT).show()
            }
        }
        val anotacao = preferencia.recuperarAnotacao()
        if(anotacao!=""){
            binding.edtContainer.edtAnotacao.setText(anotacao)

        }

    }
}