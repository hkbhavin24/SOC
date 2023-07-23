package com.example.soc.Activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.soc.Fragment.CategoryFragment
import com.example.soc.Fragment.HomeFragment
import com.example.soc.R
import com.example.soc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        lateinit var binding: ActivityMainBinding

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)


        loadFragment(HomeFragment())
        runfragment()


        setContentView(binding.root)
    }

    fun runfragment() {

        binding.bottomnev.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }

                R.id.category -> {
                    loadFragment(CategoryFragment())
                    true
                }

                else -> {
                    loadFragment(HomeFragment())
                    true
                }
            }
        }
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragfram, fragment)
            .commit()
    }
}