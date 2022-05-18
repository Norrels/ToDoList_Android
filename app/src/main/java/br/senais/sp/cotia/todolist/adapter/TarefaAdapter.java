package br.senais.sp.cotia.todolist.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

import br.senais.sp.cotia.todolist.R;
import br.senais.sp.cotia.todolist.model.Tarefa;

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.TarefaViewHolder>{
    //variavel para a lista de tarefas
    private List<Tarefa> tarefas;
    //varivel para o Context
    private Context context;
    //vairavel pro listener
    private OnTarefaClickLister listerTarefa;

    //construtor que recebe os paramentros para o adapter
    public TarefaAdapter(List<Tarefa> lista, Context contexto, OnTarefaClickLister listerTarefa){
        this.tarefas = lista;
        this.context = contexto;
        this.listerTarefa = listerTarefa;
    }

    @NonNull
    @Override
    public TarefaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //inflar a view do viewHolder
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_tarefas, parent, false);
        //retorna uma viewHolder
        return new TarefaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TarefaViewHolder holder, int position) {
        //obter a tarefa atraves da position
        Tarefa t = tarefas.get(position);
        //transporta a info da tarefa para viewHolder
        holder.tvTitulo.setText(t.getTitulo());
        // formatar a data e exibi no textView
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        holder.tvData.setText(formatador.format(t.getDataPrevista()));
        //verifica se está concluida
        if (t.isConcluido()){
            holder.tarefa.setBackgroundColor(context.getResources().getColor(R.color.concluida));
        }
        //implemntar o clique na tarefa
        holder.itemView.setOnClickListener(v -> {
            listerTarefa.onClick(v, t);
        });
    }

    @Override
    public int getItemCount() {
        if(tarefas != null){
            return tarefas.size();
        }
        return 0;
    }

    class TarefaViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvData, TvDescrição;
        LinearLayout tarefa;

        public TarefaViewHolder(View view){
            super(view);
            //Passar da view para os componentes
            tvTitulo = view.findViewById(R.id.tv_titulo);
            tvData = view.findViewById(R.id.tv_data);
            TvDescrição = view.findViewById(R.id.tv_descricao);
            tarefa = view.findViewById(R.id.linear_tarefa);
        }
    }
    //interface para o click na tarefa
    public interface OnTarefaClickLister{
        void onClick(View v, Tarefa t);

    }
}
