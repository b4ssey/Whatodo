package com.ekemini.whatodo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.ekemini.whatodo.R;
import com.ekemini.whatodo.TodoClickListener;
import com.ekemini.whatodo.todosmodel.Todos;

import java.util.ArrayList;

public class TodosAdapter extends BaseAdapter {



    private Context context;
    private ArrayList<Todos> todoList;
    TodoClickListener todoClickListener;

    public TodosAdapter(Context context, ArrayList<Todos> todoList, TodoClickListener myTodoClickListener) {
        this.context = context;
        this.todoList = todoList;
        this.todoClickListener = myTodoClickListener;
    }

    @Override
    public int getCount() {
        return todoList.size();
    }

    @Override
    public Object getItem(int position) {
        return todoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if(convertView == null){
            convertView = View.inflate(context, R.layout.to_dos, null);
        }

        TextView todoTitle = (TextView) convertView.findViewById(R.id.todotitle);
        TextView todoDescription = (TextView) convertView.findViewById(R.id.tododescription);
        TextView todoDate = (TextView) convertView.findViewById(R.id.tododate);

        Todos todos = todoList.get(position);

        todoTitle.setText(todos.getCreateTitle());
        todoDescription.setText(todos.getCreatePlanning());
        todoDate.setText(todos.getCreateDate());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                todoClickListener.click(position + 1);
            }
        });









        return convertView;
    }


}
