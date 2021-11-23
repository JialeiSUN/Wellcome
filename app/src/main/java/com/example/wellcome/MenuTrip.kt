package com.example.wellcome
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_trip_menu.*
class MenuTrip : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trip_menu)
        setSupportActionBar(findViewById(R.id.trip_toolbar))
        launchSearchFragment()

        trip_bottom_navigation.setOnItemSelectedListener  { item ->
            when(item.itemId) {
                R.id.search_trip -> {
                    launchSearchFragment()
                    true
                }
                R.id.add_trip -> {
                    launchAddServicesFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun launchAddServicesFragment(){
        supportFragmentManager.
        beginTransaction().replace(R.id.trip_content,AddTripFragment()).commit()
    }
    private fun launchSearchFragment(){
        supportFragmentManager.
        beginTransaction().replace(R.id.trip_content, SearchTripFragment()).commit()
    }
}