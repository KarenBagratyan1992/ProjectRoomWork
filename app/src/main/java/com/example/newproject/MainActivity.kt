package com.example.newproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.newproject.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    val context = this
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.setup?.setOnClickListener {
            add()
        }
    }


    fun add() {
        var email = binding?.email?.text.toString()
        var password = binding?.password?.text.toString()
        lifecycleScope.launch {
            val user = Personal(idEmpemando = 0, email = email, password = password)
            withContext(Dispatchers.IO) {
                val db = DatabaseDB.getInstance(context).personalDao().insert(user)
            }
        }
    }
}