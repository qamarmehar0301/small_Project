package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityBuyNowBinding

class Buy_Now : AppCompatActivity() {

    private lateinit var binding: ActivityBuyNowBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuyNowBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCheckout.setOnClickListener {
            if (validateInput()) {
                Toast.makeText(this, "Checkout successful", Toast.LENGTH_SHORT).show()
                // Proceed with checkout process
            }
        }
    }

    private fun validateInput(): Boolean {
        val name = binding.etName.text.toString().trim()
        val address = binding.etAddress.text.toString().trim()
        val cardNumber = binding.etCardNumber.text.toString().trim()
        val expiry = binding.etExpiry.text.toString().trim()
        val cvv = binding.etCvv.text.toString().trim()

        if (name.isEmpty()) {
            binding.etName.error = "Full name is required"
            binding.etName.requestFocus()
            return false
        }

        if (address.isEmpty()) {
            binding.etAddress.error = "Address is required"
            binding.etAddress.requestFocus()
            return false
        }

        if (cardNumber.isEmpty() || cardNumber.length != 16) {
            binding.etCardNumber.error = "Valid card number is required"
            binding.etCardNumber.requestFocus()
            return false
        }

        if (expiry.isEmpty() || !expiry.matches(Regex("(0[1-9]|1[0-2])/\\d{2}"))) {
            binding.etExpiry.error = "Valid expiry date is required"
            binding.etExpiry.requestFocus()
            return false
        }

        if (cvv.isEmpty() || cvv.length != 3) {
            binding.etCvv.error = "Valid CVV is required"
            binding.etCvv.requestFocus()
            return false
        }

        return true
    }
}