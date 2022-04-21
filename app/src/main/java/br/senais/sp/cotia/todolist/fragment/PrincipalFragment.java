package br.senais.sp.cotia.todolist.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.databinding.FragmentPrincipalBinding;


public class PrincipalFragment extends Fragment {
    private FragmentPrincipalBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //instanciar o binding
        binding = FragmentPrincipalBinding.inflate(getLayoutInflater(), container, false);
        //Retorna a view rais (root) da binding
        return binding.getRoot();

    }
}