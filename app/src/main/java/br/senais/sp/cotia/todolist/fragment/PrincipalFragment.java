package br.senais.sp.cotia.todolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.adapter.TarefaAdapter;
import br.senais.sp.cotia.todolist.database.AppDatabase;
import br.senais.sp.cotia.todolist.databinding.FragmentPrincipalBinding;
import br.senais.sp.cotia.todolist.model.Tarefa;


public class PrincipalFragment extends Fragment {
    private FragmentPrincipalBinding binding;
    //variavel para a lista
    private List<Tarefa> tarefas;
    //variavel para o adapter
    private TarefaAdapter adapter;
    //varivael para a database
    private AppDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //instanciar o binding
        binding = FragmentPrincipalBinding.inflate(getLayoutInflater(), container, false);
        //Retorna a view rais (root) da binding
        binding.btNovaTarefa.setOnClickListener(v -> {
            NavHostFragment.findNavController(PrincipalFragment.this).navigate(R.id.action_principalFragment_to_cadTarefaFragment);
        });
        return binding.getRoot();
    }

    class ReadTarefa extends AsyncTask<Void, Void, List<Tarefa>> {

        @Override
        protected List<Tarefa> doInBackground(Void... voids) {
            return null;
        }

        @NonNull
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
}