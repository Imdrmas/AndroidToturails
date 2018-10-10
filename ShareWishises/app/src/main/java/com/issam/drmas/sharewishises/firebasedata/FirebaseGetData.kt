package com.issam.drmas.sharewishises.firebasedata

import android.util.Log
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.issam.drmas.sharewishises.interfaces.IFirebaeCallbacks
import com.issam.drmas.sharewishises.models.HomeModel
import com.issam.drmas.sharewishises.utils.Utils.parseIntValue

class FirebaseGetData private constructor(){

    var db = FirebaseFirestore.getInstance()
    var iFirebaseCallbacks: IFirebaeCallbacks? = null

    object Holder{
        val value = synchronized(FirebaseGetData::class.java){FirebaseGetData()}
    }
    companion object {
        val instance: FirebaseGetData by lazy {Holder.value}
    }

    @Suppress("UNCHECKED_CAST")
    fun getQuotesFromFireStore(){
        db.collection(FirebaseConstans.COLLECTION_PARENT)
                .get()
                .addOnCompleteListener(object : OnCompleteListener<QuerySnapshot>{
                    override fun onComplete(task: Task<QuerySnapshot>) {

                        if (task.isSuccessful){

                            for (document in task.result){
                                if (document.id == FirebaseConstans.DOCUMENT_PARENT){
                                    prepareData(document.data[FirebaseConstans.FILED_CONTENT] as
                                            List<HashMap<String, String>>)
                                }
                            }
                          //  Log.d(TAG, document.id + " => " + document.data)

                        }else{

                        }

                    }

                    private fun prepareData(list: List<HashMap<String, String>>) {
                           val homeData= mutableListOf<HomeModel>()

                        for (data in list){
                            val contentType = (parseIntValue(data[FirebaseConstans.FILED_CONTENT_TYPE]?:"0"))
                            if (contentType != 0){
                                val homeModel = HomeModel(contentType, data[FirebaseConstans.FILED_CONTENT]?:"")
                                homeData.add(homeModel)

                            }
                        }
                        if (iFirebaseCallbacks != null){
                            iFirebaseCallbacks?.firebaseData(homeData)
                        }
                    }
                })
    }


    fun initializeFirebaseCallback(iFirebaeCallbacks: IFirebaeCallbacks) {
          this.iFirebaseCallbacks= iFirebaeCallbacks
    }

}