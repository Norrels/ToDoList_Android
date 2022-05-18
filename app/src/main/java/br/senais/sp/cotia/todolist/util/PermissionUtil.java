package br.senais.sp.cotia.todolist.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {
    public static boolean checarPermissão(Activity activity, int requestCode, String... permissoes){
        List<String> negadas = new ArrayList<>();
        //percorrer as permissoes em busca das permissoes negadas
        for (String permissao : permissoes){
            if (ContextCompat.checkSelfPermission(activity, permissao) != PackageManager.PERMISSION_GRANTED){
                negadas.add(permissao);
            }
        }
        //se a lista de negadas está vazia, retorna true
        if (negadas.isEmpty()){
            return true;
        }
        //converte a lista em vetor
        String[] permissoesNegadas = new String[negadas.size()];
        ActivityCompat.requestPermissions(activity, permissoesNegadas, requestCode);
        return false;
    };
}
