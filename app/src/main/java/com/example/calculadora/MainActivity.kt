package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        val numeroUm = findViewById<TextView>(R.id.numero_um)
        val numeroDois = findViewById<TextView>(R.id.numero_dois)
        val numeroTres = findViewById<TextView>(R.id.numero_tres)
        val numeroQuatro = findViewById<TextView>(R.id.numero_quatro)
        val numeroCinco = findViewById<TextView>(R.id.numero_cinco)
        val numeroSeis = findViewById<TextView>(R.id.numero_seis)
        val numeroSete = findViewById<TextView>(R.id.numero_sete)
        val numeroOito = findViewById<TextView>(R.id.numero_oito)
        val numeroNove = findViewById<TextView>(R.id.numero_nove)
        val numeroZero = findViewById<TextView>(R.id.numero_zero)
        val subtracao = findViewById<TextView>(R.id.subtracao)
        val soma = findViewById<TextView>(R.id.soma)
        val multiplicacao = findViewById<TextView>(R.id.multiplicacao)
        val divisao = findViewById<TextView>(R.id.divisao)
        val limpar = findViewById<TextView>(R.id.limpar)
        val backspace = findViewById<ImageButton>(R.id.backspace)
        val ponto = findViewById<TextView>(R.id.ponto)

        //Eventos de Click

        numeroZero.setOnClickListener{AcrescentarUmaExpressao("0", limpar_dados = true)}
        numeroUm.setOnClickListener{AcrescentarUmaExpressao("1", limpar_dados = true)}
        numeroDois.setOnClickListener{AcrescentarUmaExpressao("2", limpar_dados = true)}
        numeroTres.setOnClickListener{AcrescentarUmaExpressao("3", limpar_dados = true)}
        numeroQuatro.setOnClickListener{AcrescentarUmaExpressao("4", limpar_dados = true)}
        numeroCinco.setOnClickListener{AcrescentarUmaExpressao("5", limpar_dados = true)}
        numeroSeis.setOnClickListener{AcrescentarUmaExpressao("6", limpar_dados = true)}
        numeroSete.setOnClickListener{AcrescentarUmaExpressao("7", limpar_dados = true)}
        numeroOito.setOnClickListener{AcrescentarUmaExpressao("8", limpar_dados = true)}
        numeroNove.setOnClickListener{AcrescentarUmaExpressao("9", limpar_dados = true)}
        ponto.setOnClickListener{AcrescentarUmaExpressao(".", limpar_dados = true)}

        //Operadores

        soma.setOnClickListener{AcrescentarUmaExpressao("+", limpar_dados = false)}
        subtracao.setOnClickListener{AcrescentarUmaExpressao("-", limpar_dados = false)}
        multiplicacao.setOnClickListener{AcrescentarUmaExpressao("*", limpar_dados = false)}
        divisao.setOnClickListener{AcrescentarUmaExpressao("/", limpar_dados = false)}

        val expressao = findViewById<TextView>(R.id.expressao)
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)
        val igual = findViewById<TextView>(R.id.igual)

        limpar.setOnClickListener{
            expressao.text = ""
            txt_resultado.text = ""
        }

        backspace.setOnClickListener{

            val string = expressao.text.toString()

            if (string.isNotBlank()){
                expressao.text = string.substring(0, string.length-1)
            }
            txt_resultado.text = ""
        }

        igual.setOnClickListener{

            try {
                //val expressao = ExpressionBuilder(expressao.text.toString())
                val expressao = ExpressionBuilder(expressao.text.toString())
                val resultado = expressao.build().evaluate()
                val longResult = resultado.toLong()

                if (resultado == longResult.toDouble())
                    txt_resultado.text = longResult.toString()
                else
                    txt_resultado.text = resultado.toString()

            }catch (e: Exception){
            }
        }

    }

    fun AcrescentarUmaExpressao(string: String, limpar_dados : Boolean){

        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)
        val expressao = findViewById<TextView>(R.id.expressao)

        if (txt_resultado.text.isNotEmpty()){
            expressao.text = ""
        }

        if (limpar_dados){
            txt_resultado.text = ""
            expressao.append(string)
        }else{
            expressao.append(txt_resultado.text)
            expressao.append(string)
            txt_resultado.text = ""
        }
    }


}