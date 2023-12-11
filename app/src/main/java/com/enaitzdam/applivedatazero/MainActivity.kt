package com.enaitzdam.applivedatazero

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.enaitzdam.applivedatazero.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val viewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.user.observe(this, Observer { user ->
            binding.userInfoTextView.text = "User Info: ${user.name}, ${user.age}"
        })

        binding.updateButton.setOnClickListener {
            val name = binding.userNameEditText.text.toString()
            val age = binding.userAgeEditText.text.toString().toIntOrNull() ?: 0
            viewModel.updateUser(name, age)
        }
    }
}