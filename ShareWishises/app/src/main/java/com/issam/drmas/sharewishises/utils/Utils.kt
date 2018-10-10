package com.issam.drmas.sharewishises.utils

import android.content.Context
import android.support.annotation.IntegerRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import android.widget.Toast
import com.issam.drmas.sharewishises.MainActivity

object Utils {

    fun openFragment(fragmentManager: FragmentManager, className: Class<out Fragment>, frameLayoutId: Int) {

        if(!isFragmentAlreadyAdded(fragmentManager, className)){

        val visibleFragment = visibleFragment(fragmentManager)
        val fragmentTransaction = fragmentManager.beginTransaction()

        if (visibleFragment != null)
            fragmentTransaction.hide(visibleFragment)

        val replacedFragment=className.newInstance()
        fragmentTransaction.add(frameLayoutId, replacedFragment, className::class.java.simpleName)
        fragmentTransaction.commit()

        } else {
            showFragment(fragmentManager, className)
        }
    }

    private fun showFragment(fragmentManager: FragmentManager, className: Class<out Fragment>) {

        val fragmentList = fragmentManager.fragments
        val fragmentTransaction=fragmentManager.beginTransaction()

        for (fragment in fragmentList){
            fragment.let {
                if (fragment.javaClass.simpleName == className.simpleName)
                    fragmentTransaction.show(fragment)
                else
                    fragmentTransaction.hide(fragment)
            }
        }
        fragmentTransaction.commit()
    }

    private fun isFragmentAlreadyAdded(fragmentManager: FragmentManager, className: Class<out Fragment>): Boolean {

        val fragmentList = fragmentManager.fragments

        return fragmentList.any { it != null && it.javaClass.simpleName == className.simpleName }
    }

    private fun visibleFragment(fragmentManager: FragmentManager): Fragment? {

       val fragmentList = fragmentManager.fragments

        return fragmentList.firstOrNull { it != null && it.isVisible }
    }
    fun parseIntValue(stringValue: String): Int{

        return try {
            Integer.parseInt(stringValue)
        }catch (exp: NumberFormatException){
            0
        }
    }

    fun showToastMessage(activity: Context?, message: String){
        if (activity != null){
            Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
        }
    }
}









