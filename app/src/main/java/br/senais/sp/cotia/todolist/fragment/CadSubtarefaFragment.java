package br.senais.sp.cotia.todolist.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.databinding.FragmentCadSubtarefaBinding;
import br.senais.sp.cotia.todolist.databinding.FragmentPrincipalBinding;
import br.senais.sp.cotia.todolist.model.Tarefa;

public class CadSubtarefaFragment extends Fragment {

    Tarefa tarefa;
    private AlertDialog dialog;
    private FragmentCadSubtarefaBinding binding;
    private AlertDialog.Builder builder;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCadSubtarefaBinding.inflate(getLayoutInflater(), container, false);
        if(getArguments() != null){
            tarefa = (Tarefa) getArguments().getSerializable("Tarefa");
            binding.tituloTv.setText(tarefa.getTitulo());
        }

        //habilita o menu
        setHasOptionsMenu(true);

        //instacia o dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.origem_imagem);
        String[] opcoes = {getString(R.string.camera),getString(R.string.galaria)};
        builder.setItems(opcoes, listenerDialog);
        dialog = builder.create();

        binding.imagemDialog.setOnClickListener(v -> {
            dialog.show();
        });

        return binding.getRoot();
    }

    private DialogInterface.OnClickListener listenerDialog = (dialog, i) -> {

    };

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_subtarefa, menu);
    }
}