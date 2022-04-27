package br.senais.sp.cotia.todolist.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import br.senais.sp.cotia.todolist.model.Tarefa;

@Dao
public interface TarefaDao {
    @Insert
    void insert(Tarefa t);

    @Update
    void upate(Tarefa t);

    @Delete
    void delete(Tarefa t);

    @Query("select * from tarefa")
    List<Tarefa> getAll();
}
