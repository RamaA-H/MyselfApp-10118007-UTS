package com.example.myselfapp.ui.home;
//Tanggal Pengerjaan : 25 Mei 2021
//NIM   : 10118007
//Nama  : Rama Al Halik
//Kelas : IF-1
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}