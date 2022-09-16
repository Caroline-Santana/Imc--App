package br.senai.sp.jandira.imc20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.imc20.databinding.ActivityCalculateBinding
import br.senai.sp.jandira.imc20.utils.getBmi
import br.senai.sp.jandira.imc20.utils.getStatus

class CalculateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setContentView(binding.root)

        supportActionBar!!.hide()

        loadProfile()



        binding.buttonCalcular.setOnClickListener {
            bmiCalculate()
        }

    }


    private fun bmiCalculate() {
        val openResult = Intent(this, ResultActivity::class.java)
        val dados = getSharedPreferences("dados", MODE_PRIVATE)
        var edit = dados.edit()
        var height = 0.0f

        if (valiteDados()) {
            if (binding.editTextHeight2.text.isEmpty()) {
                height = dados.getFloat("height", 0.0f)
            } else {
                height = binding.editTextHeight2.text.toString().toFloat()
            }
            var weight = binding.editTextWeight2.text.toString().toInt()

            var bmi = getBmi(weight, height).toDouble()
            var statusBmi = getStatus(bmi, this)

            edit.putFloat("height", height)
            edit.putInt("weight", weight)
            edit.commit()

            openResult.putExtra("bmi", bmi)
            openResult.putExtra("statusBmi", statusBmi)

            startActivity(openResult)
        } else {
            Toast.makeText(this, "Invalid datas", Toast.LENGTH_SHORT).show()
        }
    }

    private fun valiteDados(): Boolean {
        if (binding.editTextWeight2.text.isEmpty()) {
            binding.editTextWeight2.error = "Required field!"
            return false
        } else {
            return true
        }
    }

    private fun loadProfile() {
        //Abrir o arquivo SharedPreferences
        val dados = getSharedPreferences("dados", MODE_PRIVATE)

        binding.textViewUser.text = dados.getString("name", "")
        binding.textViewEmail.text = dados.getString("email", "")
        binding.textViewWeight.text = "${resources.getText(R.string.weight)} ${dados.getInt("weight", 0)} Kg"
        binding.textViewHeight.text = "${resources.getText(R.string.height)} ${dados.getFloat("height", 0.0f)}"
    }
}



