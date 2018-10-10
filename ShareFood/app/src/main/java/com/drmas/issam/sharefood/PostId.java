package com.drmas.issam.sharefood;

import android.support.annotation.NonNull;

import com.google.firebase.firestore.Exclude;

/**
 * Created by drmas on 02/04/2018.
 */

public class PostId {

    @Exclude
    public String PostId;

    public <T extends PostId> T withid(@NonNull final String id){
        this.PostId = id;
        return (T) this;
    }
}






















