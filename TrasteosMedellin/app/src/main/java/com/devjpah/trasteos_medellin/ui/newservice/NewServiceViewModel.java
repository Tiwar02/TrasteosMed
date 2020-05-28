package com.devjpah.trasteos_medellin.ui.newservice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewServiceViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NewServiceViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}