package com.example.aplicativov5

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val contatoWhatsapp = "seu_contato_aqui" // Formato: "numero@c.us"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChamarPolicia: Button = findViewById(R.id.btn_chamar_policia)
        val btnChamarSamu: Button = findViewById(R.id.btn_chamar_samu)
        val btnEnviarLocalizacao: Button = findViewById(R.id.btn_enviar_localizacao)
        val btnLigarContato: Button = findViewById(R.id.btn_ligar_contato)

        btnChamarPolicia.setOnClickListener {
            chamarNumero("190")
        }

        btnChamarSamu.setOnClickListener {
            chamarNumero("192")
        }

        btnEnviarLocalizacao.setOnClickListener {
            enviarLocalizacao()
        }

        btnLigarContato.setOnClickListener {
            ligarParaContato(contatoWhatsapp)
        }
    }

    private fun chamarNumero(numero: String) {
        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$numero"))
        startActivity(intent)
    }

    private fun enviarLocalizacao() {
        val uri = Uri.parse("smsto:$contatoWhatsapp")
        val intent = Intent(Intent.ACTION_SENDTO, uri)
        intent.putExtra("sms_body", "Estou aqui: https://maps.google.com/?q=Minha_Localizacao")
        startActivity(intent)
    }

    private fun ligarParaContato(contato: String) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$contato"))
        startActivity(intent)
    }
}
