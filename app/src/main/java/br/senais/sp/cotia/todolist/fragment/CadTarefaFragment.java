package br.senais.sp.cotia.todolist.fragment;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import java.util.Calendar;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.databinding.FragmentCadSubtarefaBinding;
import br.senais.sp.cotia.todolist.databinding.FragmentCadTarefaBinding;

public class CadTarefaFragment extends Fragment {
    private FragmentCadTarefaBinding binding;
    private DatePickerDialog datePicker;
    int year, month, day;
    Calendar dataAtual;
    String dataFormatada;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //instaciando o binding
        binding = FragmentCadTarefaBinding.inflate(getLayoutInflater(), container, false);

        //instaciando a data atual
        dataAtual = Calendar.getInstance();
        //obter ano, mes e dia, da data atual
        year = dataAtual.get(Calendar.YEAR);
        month = dataAtual.get(Calendar.MONTH);
        day = dataAtual.get(Calendar.DAY_OF_MONTH);

        //instaciar o datePicker
        datePicker = new DatePickerDialog(getContext(), (datePicker, ano, mes, dia) -> {
            //ao escolher uma data no datePicker, cai aqui
        }, year, month, day);

        binding.btData.setOnClickListener(v -> {
            datePicker.show();
        });
        return binding.getRoot();
    }
}