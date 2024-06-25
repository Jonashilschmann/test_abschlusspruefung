package com.example.test_abschlusspruefung.mainActivity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.test_abschlusspruefung.databinding.ActivityMainBinding
import com.example.test_abschlusspruefung.ui.viewModels.ListViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: ListViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        }
}