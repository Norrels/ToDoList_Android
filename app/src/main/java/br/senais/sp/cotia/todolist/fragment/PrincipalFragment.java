package br.senais.sp.cotia.todolist.fragment;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

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

        //Instancia a database
        database = AppDatabase.getDatabase(getContext());

        binding.recyclerTarefas.setLayoutManager(new LinearLayoutManager(getContext()));

        //executar a asyntask
        new ReadTarefa().execute();

        return binding.getRoot();
    }

    class ReadTarefa extends AsyncTask<Void, Void, List<Tarefa>> {

        @Override
        protected List<Tarefa> doInBackground(Void... voids) {
            // buscar as tarefas e guardar na variavel tarefas
            tarefas = database.getTarefaDao().getAll();
            return tarefas;
        }

        @Override
        protected void onPostExecute(List<Tarefa> tarefas) {
            //instancia o adapter
            adapter = new TarefaAdapter(tarefas, getContext(), listerClick);
            //aplica o adapter no recycler
            binding.recyclerTarefas.setAdapter(adapter);
        }
    }

    //Listener para click nas tarefas
    private TarefaAdapter.OnTarefaClickLister listerClick = (view, tarefa) -> {
      // variavel para "pendurar" a tarefa
      Bundle bundle = new Bundle();
      bundle.putSerializable("Tarefa", tarefa);
      // navega para o fragment de detalhes
        NavHostFragment.findNavController(PrincipalFragment.this).navigate(R.id.action_principalFragment_to_detalheTarefaFragment, bundle);
    };
}