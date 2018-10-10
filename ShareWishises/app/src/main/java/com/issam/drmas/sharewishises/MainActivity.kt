package com.issam.drmas.sharewishises

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import com.issam.drmas.sharewishises.fragments.FavouriteFragment
import com.issam.drmas.sharewishises.fragments.HomeFragment
import com.issam.drmas.sharewishises.utils.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragmentToUi(HomeFragment::class.java)

        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener {

            if (it.itemId==R.id.navigation_home){

                if (frame_container.tag != null && frame_container.tag != HomeFragment::class.java.simpleName)
                {
                     addFragmentToUi(HomeFragment::class.java)
                }

                return@setOnNavigationItemSelectedListener true

            } else if (it.itemId==R.id.navigation_fav){

                if (frame_container.tag != null && frame_container.tag != FavouriteFragment::class.java.simpleName)
                {
                    addFragmentToUi(FavouriteFragment::class.java)
                }

                return@setOnNavigationItemSelectedListener true

                }

            return@setOnNavigationItemSelectedListener false
        }


    }

    private fun addFragmentToUi(className: Class<out Fragment>) {

        Utils.openFragment(supportFragmentManager, className,  R.id.frame_container)
        frame_container.setTag(className.simpleName)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return super.onCreateOptionsMenu(menu)
    }
}


