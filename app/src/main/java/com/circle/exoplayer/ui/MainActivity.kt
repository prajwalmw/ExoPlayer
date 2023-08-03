package com.circle.exoplayer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.circle.exoplayer.R
import com.circle.exoplayer.data.FirstViewModel
import com.circle.exoplayer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var viewmodel : FirstViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewmodel = ViewModelProvider(this).get(FirstViewModel::class.java)

        binding.vm = viewmodel
        binding.lifecycleOwner = this
    }
}