package ir.m3.rahmani.leitner

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import ir.m3.rahmani.leitner.databinding.ActivityMainBinding
import ir.m3.rahmani.leitner.feature.home.HomeFragment

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)
    ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
      val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      insets
    }


    // Go to Home fragment
    val fragmentHome = HomeFragment()
    binding.flMain.apply {
      supportFragmentManager.beginTransaction()
        .replace(binding.flMain.id, fragmentHome)
        .commit()
    }

  }
}