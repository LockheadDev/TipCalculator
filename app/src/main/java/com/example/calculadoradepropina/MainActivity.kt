package com.example.calculadoradepropina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.calculadoradepropina.databinding.ActivityMainBinding
import java.text.DecimalFormat
import kotlin.math.*

class MainActivity : AppCompatActivity() {
    var totalTip: Double = 0.0
    var totalAmount : Double =0.0

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Construimos interfaz gráfica
        setContentView(binding.root)
        initUI()
    }
private fun initUI()
{
    binding.button15.setOnClickListener{
        interfaceCalculateTip(0.15)
        showPercentageToast(15)
    }
    binding.button25.setOnClickListener{
        interfaceCalculateTip(0.25)
        showPercentageToast(25)
    }
    binding.button35.setOnClickListener{
        interfaceCalculateTip(0.35)
        showPercentageToast(35)
    }
    binding.buttonRound.setOnClickListener {
        roundResults()
    }
}

    private fun roundResults()
    {
            binding.totalTip.text = "$ ${round(totalTip).format(0)}"
            binding.totalAmount.text = "$ ${round(totalAmount).format(0)}"

    }
    private fun showPercentageToast(num: Int)
    {
        Toast.makeText(this,"Vas a dar una propina del $num%", Toast.LENGTH_LONG).show()
    }
    private fun interfaceCalculateTip(percentage : Double)
    {

        val amount = binding.inputAmount.text.toString()
        val amountValue = amount.toDoubleOrNull()

                if(amountValue != null && amountValue > 0)
                {
                    totalTip = (amountValue*percentage)
                    totalAmount = (amountValue*(1+percentage))

                    binding.totalTip.text = "$ ${totalTip.format(2)}"
                    binding.totalAmount.text = "$ ${totalAmount.format(2)}"
                }else
                {
                    Toast.makeText(this,"Error, número inválido", Toast.LENGTH_LONG).show()
                    binding.totalTip.text ="0.0"
                    binding.totalAmount.text ="0.0"
                    return
                }
    }
    private fun Double.format(digits: Int) = "%.${digits}f".format(this)
}