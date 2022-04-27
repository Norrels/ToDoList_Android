package br.senais.sp.cotia.todolist.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import br.senais.sp.cotia.todolist.model.Tarefa;

@Database(entities = {Tarefa.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    //variavel para acessar a databse
    private static AppDatabase database;
    //método para a tarefaDao
    public abstract TarefaDao getTarefaDao();
    //métedo para intanciar a data base
    public static AppDatabase getDatabase(Context context){
        //verifica se a data base já existe
        if(database == null){
            database = Room.databaseBuilder(
                    context.getApplicationContext(), AppDatabase.class, "TodoList").build();
        }
        //retorna a database
        return database;
    }
}
