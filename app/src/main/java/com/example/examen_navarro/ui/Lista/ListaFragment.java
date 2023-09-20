package com.example.examen_navarro.ui.Lista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.examen_navarro.databinding.FragmentListaBinding;
import com.example.examen_navarro.databinding.FragmentSalirBinding;

import java.util.ArrayList;

public class ListaFragment extends Fragment {

    private FragmentListaBinding binding;

    private ListaViewModel mv;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListaViewModel homeViewModel =
              mv =  new ViewModelProvider(this).get(ListaViewModel.class);

        binding = FragmentListaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        mv.getLista().observe(getViewLifecycleOwner(), new Observer<ArrayList<Notas>>() {
            @Override
            public void onChanged(ArrayList<Notas> notas) {
                RecyclerView rv = binding.RvLista;

                GridLayoutManager grilla = new GridLayoutManager(requireContext(), 5, GridLayoutManager.HORIZONTAL, false);
                rv.setLayoutManager(grilla);

                NotasAdapter adapter = new NotasAdapter((requireContext()), notas, getLayoutInflater(),mv);
                rv.setAdapter(adapter);
            }
        });
        mv.cargarLista();



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}