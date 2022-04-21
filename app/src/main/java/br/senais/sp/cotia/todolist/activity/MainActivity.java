package br.senais.sp.cotia.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //instaciar o binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //seta na contentview a raiz (root) do binding
        setContentView(binding.getRoot());
    }
}