package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.itesm.numeros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val numList = mutableListOf<Int>()
        initUI(numList)
    }

    private fun initUI(numList: MutableList<Int>){
        binding.buttonAgregar.setOnClickListener {
            addNumbers(numList)
        }
        binding.buttonPromedio.setOnClickListener {
            mean(numList)
        }
        binding.buttonMayor.setOnClickListener {
            max(numList)
        }
        binding.buttonPares.setOnClickListener {
            pairs(numList)
        }
    }

    private fun addNumbers(numList: MutableList<Int>){
        val number = binding.editTextNumberSigned.text.toString()
        val numberValue = number.toIntOrNull()
        if(numberValue == null){
            Toast.makeText(this, "Write at least one number", Toast.LENGTH_SHORT).show()
            return
        }
        numList.add(numberValue)
        binding.listaView.text = "$numList"
        binding.editTextNumberSigned.text.clear()
    }

    private fun mean(numList: MutableList<Int>){
        if(numList.isEmpty()){
            Toast.makeText(this, "Write at least one number", Toast.LENGTH_SHORT).show()
            return
        }
        val sumList = numList.sum()
        val meanList = sumList/numList.size
        binding.meanView.text = "$meanList"
    }

    private fun max(numList: MutableList<Int>){
        if(numList.isEmpty()){
            Toast.makeText(this, "Write at least one number", Toast.LENGTH_SHORT).show()
            return
        }
        val maxList = numList.maxOrNull()
        binding.maxView.text = "$maxList"
    }

    private fun pairs(numList: MutableList<Int>){
        if(numList.isEmpty()){
            Toast.makeText(this, "Write at least one number", Toast.LENGTH_SHORT).show()
            return
        }
        val pairsList = numList.filter { x -> x % 2 == 0 }
        binding.evenView.text = "$pairsList"
    }
}