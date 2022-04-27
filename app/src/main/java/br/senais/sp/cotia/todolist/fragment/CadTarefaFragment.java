package br.senais.sp.cotia.todolist.fragment;

import android.app.DatePickerDialog;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.loader.content.AsyncTaskLoader;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.database.AppDatabase;
import br.senais.sp.cotia.todolist.databinding.FragmentCadSubtarefaBinding;
import br.senais.sp.cotia.todolist.databinding.FragmentCadTarefaBinding;
import br.senais.sp.cotia.todolist.model.Tarefa;

public class CadTarefaFragment extends Fragment {
    private FragmentCadTarefaBinding binding;
    private DatePickerDialog datePicker;
    int year, month, day;
    Calendar dataAtual;
    String dataFormatada;
    //Variável para a database
    AppDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //instaciando a database
        database = AppDatabase.getDatabase(getContext());

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
            year = ano;
            month = mes;
            day = dia;
            //formatar a data
            dataFormatada = String.format("%02d/%02d/%04d", day, month + 1, year);
            //aplicar a data formatada no botão
            binding.btData.setText(dataFormatada);
        }, year, month, day);

        binding.btData.setOnClickListener(v -> {
            datePicker.show();


        });
        //listener do botçao salvar
        binding.btSalvar.setOnClickListener(v -> {
            if (binding.edtTitulo.getText().toString().isEmpty()) {
                Snackbar.make(binding.btSalvar, "Informe um título", Snackbar.LENGTH_SHORT).show();
            } else if (binding.edtDescricao.getText().toString().isEmpty()) {
                Snackbar.make(binding.btSalvar, "Informe uma descrição", Snackbar.LENGTH_SHORT).show();
            } else if (dataFormatada == null) {
                Snackbar.make(binding.btSalvar, "Data Inválida", Snackbar.LENGTH_SHORT).show();
            } else {
                //cria uma tarefa
                Tarefa tarefa = new Tarefa();
                //popular o objeto
                tarefa.setTitulo(binding.edtTitulo.getText().toString());
                tarefa.setDescricao(binding.edtDescricao.getText().toString());
                tarefa.setDataCriacao(dataAtual.getTimeInMillis());
                //criar um calender
                Calendar dataPrevista = Calendar.getInstance();
                //muda a data para a data escolhida no datepicker
                dataPrevista.set(year, month, day);
                // passa os milisegundos da data para a dara prevista
                tarefa.setDataPrevista(dataPrevista.getTimeInMillis());
                //salvar a tarefa
                new insertTarefa().execute(tarefa);
            }
        });

        return binding.getRoot();
    }

        private class insertTarefa extends AsyncTask<Tarefa, Void, String> {

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(Tarefa... tarefas) {
                //pega a tarefa a partir do vetor
                Tarefa t = tarefas[0];
                try {
                    //chamar o metodo para salvar a tarefa
                    database.getTarefaDao().insert(t);
                    //retornar
                    return "ok";
                }catch (Exception erro){
                    erro.printStackTrace();
                    //retorna a menssagem de erro
                    return erro.getMessage();
                }
            }

            @Override
            protected void onProgressUpdate(Void... values) {
                super.onProgressUpdate(values);
            }
            //é aqui que voce informa o usuario que o processo foi concluido
            @Override
            protected void onPostExecute(String result) {
                if (result.equals("ok")){
                    Log.w("Result", "Passou, A tarefa foi inserida com sucesso");
                    Snackbar.make(binding.btSalvar, "A tarefa foi inserida com sucesso", Snackbar.LENGTH_SHORT).show();
                    //voltar ao fragment anterior, invoca o botao de volta (<)
                    getActivity().onBackPressed();
            }else {
                    Snackbar.make(binding.btSalvar, "Ocorreu um erro ao salvar a tarefa", Snackbar.LENGTH_SHORT).show();
            }
            }
        }
    }
