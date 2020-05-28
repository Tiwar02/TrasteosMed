package com.devjpah.trasteos_medellin.ui.activeservices;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ActiveServicesViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ActiveServicesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}