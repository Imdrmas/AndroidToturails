package com.issam.drmas.sharewishises.interfaces

import com.issam.drmas.sharewishises.models.HomeModel

interface IFirebaeCallbacks {

    fun showProgress()
    fun hideProgress()
    fun showMessage(message: String)
    fun firebaseData(firebaseData: MutableList<HomeModel>)

}