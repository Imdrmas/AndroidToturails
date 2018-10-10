package com.issam.drmas.sharewishises.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.issam.drmas.sharewishises.R
import com.issam.drmas.sharewishises.adapter.HomeAdapter
import com.issam.drmas.sharewishises.firebasedata.FirebaseGetData
import com.issam.drmas.sharewishises.models.HomeModel
import kotlinx.android.synthetic.main.include_recyclerview.*
import com.issam.drmas.sharewishises.interfaces.IFirebaeCallbacks
import com.issam.drmas.sharewishises.utils.Utils
import java.util.*

class HomeFragment : Fragment(), IFirebaeCallbacks {

    lateinit var homeAdapter: HomeAdapter
    lateinit var homeDate: MutableList<HomeModel>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_homefragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rv_content.layoutManager = LinearLayoutManager(context)

        homeDate = mutableListOf()
        homeAdapter = HomeAdapter(homeDate)
        rv_content.adapter = homeAdapter

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        FirebaseGetData.instance.initializeFirebaseCallback(this)
        FirebaseGetData.instance.getQuotesFromFireStore()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
       progressBar.visibility = View.GONE
    }

    override fun showMessage(message: String) {
        Utils.showToastMessage(context, message)
    }

    override fun firebaseData(firebaseData: MutableList<HomeModel>) {
        homeDate.addAll(firebaseData)
        homeAdapter.notifyDataSetChanged()
    }
}