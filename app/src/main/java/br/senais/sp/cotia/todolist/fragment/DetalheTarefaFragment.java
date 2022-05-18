package br.senais.sp.cotia.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.databinding.FragmentDetalheTarefaBinding;
import br.senais.sp.cotia.todolist.model.Tarefa;

public class DetalheTarefaFragment extends Fragment {
    private FragmentDetalheTarefaBinding binding;
    //variavel para a tarefa
    Tarefa tarefa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //instaciar o binding
        binding = FragmentDetalheTarefaBinding.inflate(getLayoutInflater(), container, false);

        //verifica se foi passado algo no bundle
        if (getArguments() != null) {
            //recuperar a tarefa no bundle
            tarefa = (Tarefa) getArguments().getSerializable("Tarefa");
            binding.tituloTv.setText(tarefa.getTitulo());
            binding.descricaoTv.setText(tarefa.getDescricao());
            SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
            binding.dataTv.setText(formatador.format(tarefa.getDataPrevista()));

            binding.btNovaSubTarefa.setOnClickListener(view -> {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("Tarefa", tarefa);
                        NavHostFragment.findNavController(DetalheTarefaFragment.this).navigate(R.id.action_detalheTarefaFragment_to_cadSubtarefaFragment2, bundle);
                    }
            );
        }

        return binding.getRoot();
    }
}