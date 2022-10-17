package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_calculate){
            calculate()
        }
    }

    private fun isValidationOk(): Boolean {
        return (binding.editDistance.text.toString() != ""
                &&binding.editDistance.text.isNotEmpty()

                &&binding.editPrice.text.toString() != ""
                &&binding.editPrice.text.isNotEmpty()

                &&binding.editAutonomy.text.toString() != ""
                &&binding.editAutonomy.text.isNotEmpty()
                &&binding.editAutonomy.text.toString().toFloat() != 0f)
    }

    private fun calculate()  {

        if (isValidationOk()){

            try {
                val distance = binding.editDistance.text.toString().toFloat()
                val price = binding.editPrice.text.toString().toFloat()
                val autonomy = binding.editAutonomy.text.toString().toFloat()

                val totalValue = (distance * price) / autonomy

                binding.textValue.text = "R$: ${"%.2f".format(totalValue)}"
            }
            catch (e :NumberFormatException){
                Toast.makeText( this,
                    R.string.button_error,
                    Toast.LENGTH_SHORT).show()
            }
            catch (e :Exception){
                Toast.makeText( this,
                    R.string.button_error,
                    Toast.LENGTH_SHORT).show()
            }
        }
        else

            Toast.makeText( this,
            R.string.button_error,
            Toast.LENGTH_SHORT).show()
    }
}