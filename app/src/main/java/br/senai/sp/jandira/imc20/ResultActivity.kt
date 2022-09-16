package br.senai.sp.jandira.imc20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.senai.sp.jandira.imc20.databinding.ActivityResultBinding
import br.senai.sp.jandira.imc20.utils.getBmi


class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar!!.hide()


        //Recuperar valores que estão na Intent

        val bmi = "%.2f".format(intent.getDoubleExtra("bmi", 0.0))
        val statusBmi = intent.getStringExtra("statusBmi")

        binding.textViewResult.text = bmi.toString()
        binding.textViewStatus.text = statusBmi


    }
}
