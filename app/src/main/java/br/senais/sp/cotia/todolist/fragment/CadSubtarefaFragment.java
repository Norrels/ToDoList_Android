package br.senais.sp.cotia.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.databinding.FragmentCadSubtarefaBinding;
import br.senais.sp.cotia.todolist.databinding.FragmentPrincipalBinding;

public class CadSubtarefaFragment extends Fragment {
    private FragmentCadSubtarefaBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCadSubtarefaBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }
}