package com.example.examen_navarro.ui.Lista;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen_navarro.R;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class NotasAdapter extends RecyclerView.Adapter<NotasAdapter.ViewHolder> {
    private NavController navController;

    private ListaViewModel listaViewModel;
    private Context contexto;
    private List<Notas> notas;
    private LayoutInflater inflater;

    public NotasAdapter(Context contexto, List<Notas> notas, LayoutInflater inflater,ListaViewModel listaViewModel) {
        this.contexto = contexto;
        this.notas = notas;
        this.inflater = inflater;
        this.listaViewModel = listaViewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.item_view, parent, false);
        return new ViewHolder(root);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.TvNombre.setText(notas.get(position).getNombre());




        holder.BtDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("notas", notas.get(position));
                bundle.putInt("posicion", position);
                Navigation.findNavController(v).navigate(R.id.action_nav_lista_to_resultadoFragment,bundle);

            }
        });
        holder.btBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (position >= 0 && position < notas.size()) {


                    listaViewModel.eliminarNota(position);
                    // Notifica al adaptador de que se eliminó un elemento
                    notifyItemRemoved(position);


                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView TvNombre;

        Button BtDetalle;

        Button btBorrar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            TvNombre = itemView.findViewById(R.id.TvNombre);
            BtDetalle=itemView.findViewById(R.id.BtDetalle);
            btBorrar=itemView.findViewById(R.id.btBorrar);



        }
    }
}