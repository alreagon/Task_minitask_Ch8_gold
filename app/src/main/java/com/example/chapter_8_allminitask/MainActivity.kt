package com.example.chapter_8_allminitask

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.chapter_8_allminitask.databinding.ActivityMainBinding
import com.example.chapter_8_allminitask.philippcourse.MainPhilippCourse
import com.example.chapter_8_allminitask.tutorlogin.MainCompose

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(R.color.biruMantep)


        binding.apply {
            JPCompSimplifiedCoding.setOnClickListener {
                val intent = Intent(this@MainActivity, JPCompNyoba::class.java)
                startActivity(intent)
            }
            JPCompSimplifiedCoding.setOnLongClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "JPCompose from Simplified Coding yt",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

            jpcLoginTutor.setOnClickListener {
                val intent = Intent(this@MainActivity, MainCompose::class.java)
                startActivity(intent)
            }
            jpcLoginTutor.setOnLongClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "JPCompose LoginUi from Hoodlab yt",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }
            jpcompPhilippLackner.setOnClickListener {
                val intent = Intent(this@MainActivity, MainPhilippCourse::class.java)
                startActivity(intent)
            }
            jpcompPhilippLackner.setOnLongClickListener {
                Toast.makeText(
                    this@MainActivity,
                    "JPCompose course from Philipp Lacker yt",
                    Toast.LENGTH_SHORT
                ).show()
                true
            }

        }


    }
}
