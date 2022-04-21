package br.senais.sp.cotia.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.databinding.FragmentDetalheTarefaBinding;

public class DetalheTarefaFragment extends Fragment {

    private FragmentDetalheTarefaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentDetalheTarefaBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}