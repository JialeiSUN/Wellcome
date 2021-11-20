package com.example.wellcome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_assistance_menu.*


class MenuAssistance : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_assistance_menu)
        setSupportActionBar(findViewById(R.id.assistance_toolbar))
        launchSearchFragment()

        assistance_bottom_navigation.setOnItemSelectedListener  { item ->
            when(item.itemId) {
                R.id.search_assistance -> {
                    launchSearchFragment()
                    true
                }
                R.id.add_assistance -> {
                    launchAddServicesFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun launchAddServicesFragment(){
        supportFragmentManager.
        beginTransaction().replace(R.id.assistance_content,AddAssistanceFragment()).commit()
    }
    private fun launchSearchFragment(){
        supportFragmentManager.
        beginTransaction().replace(R.id.assistance_content, SearchAssistanceFragment()).commit()
    }
}