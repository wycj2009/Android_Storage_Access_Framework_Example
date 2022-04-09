package com.example.android_storage_access_framework_example

import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android_storage_access_framework_example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val openDocumentLauncher = registerForActivityResult(ActivityResultContracts.OpenDocument()) {
        it?.let {
            Log.d("myLog", it.toString())
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.open.setOnClickListener {
            openDocumentLauncher.launch(arrayOf("text/*", "image/*"))
        }
    }

}