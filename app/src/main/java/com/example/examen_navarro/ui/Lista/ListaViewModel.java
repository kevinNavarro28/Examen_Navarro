package com.example.examen_navarro.ui.Lista;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ListaViewModel extends AndroidViewModel {

    private ArrayList<Notas> notas;
    private MutableLiveData<ArrayList<Notas>> lista;

    public ListaViewModel(@NonNull Application application) {
        super(application);


    }

    public LiveData<ArrayList<Notas>> getLista() {
        if (this.lista == null) {
            this.lista = new MutableLiveData<>();
        }
        return lista;
    }

    public void cargarLista() {
        notas = new ArrayList<>();
        notas.add(new Notas("Pasear", "Pasear Al Perro por toda la ciudad"));
        notas.add(new Notas("Correr", "Correr desde la primera rotonda hasta la maternidad"));
        notas.add(new Notas("Compras", "ir de compras al vea para comprar comida para la semana"));
        notas.add(new Notas("Rendir", "Rendir examen parcial de Moviles"));
        notas.add(new Notas("Menditar", "Meditar durante una hora para sentirse a gusto"));
        lista.setValue(notas);
    }

    public void eliminarNota(int posicion) {
        if (notas != null && posicion >= 0 && posicion < notas.size()) {
            notas.remove(posicion);
            lista.setValue(notas);
        }
    }

}


