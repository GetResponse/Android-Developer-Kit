package com.getresponse.sampleapp;

import android.content.Context;
import android.widget.Toast;

import com.github.kubatatami.judonetworking.AsyncResult;
import com.github.kubatatami.judonetworking.CacheInfo;
import com.github.kubatatami.judonetworking.callbacks.Callback;
import com.github.kubatatami.judonetworking.exceptions.HttpException;
import com.github.kubatatami.judonetworking.exceptions.JudoException;

public class GRCallback<T> implements Callback<T> {

    private Context context;

    public GRCallback(Context context) {
        this.context = context;
    }

    @Override
    public void onStart(CacheInfo cacheInfo, AsyncResult asyncResult) {

    }

    @Override
    public void onProgress(int i) {

    }

    @Override
    public void onSuccess(T t) {

    }

    @Override
    public void onError(JudoException e) {
        Toast.makeText(context, ((HttpException) e).getBody(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFinish() {

    }
}
