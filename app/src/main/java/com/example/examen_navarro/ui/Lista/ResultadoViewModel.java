package com.example.examen_navarro.ui.Lista;

import android.os.Bundle;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResultadoViewModel extends ViewModel {
    private MutableLiveData<Notas> mResultado;

    public LiveData<Notas> getMResultado(){
        if(mResultado==null){
            mResultado=new MutableLiveData<>();
        }
        return mResultado;

    }

    private MutableLiveData<Integer> mBorra;

    public LiveData<Integer> getmBorra(){
        if(mBorra==null){
            mBorra=new MutableLiveData<>();
        }
        return mBorra;

    }


    public void obtenerResultado(Bundle bundle){

       Notas notas = (Notas)bundle.getSerializable("notas");
        mResultado.setValue(notas);
    }

    public void borrar(Bundle bundle){
        int posi = bundle.getInt("posicion",-1);
        mBorra.setValue(posi);

    }
}