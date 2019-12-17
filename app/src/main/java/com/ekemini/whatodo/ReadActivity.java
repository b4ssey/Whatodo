package com.ekemini.whatodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.ekemini.whatodo.adapter.TodosAdapter;
import com.ekemini.whatodo.todosmodel.Todos;

import java.util.ArrayList;
import java.util.List;


public class ReadActivity extends AppCompatActivity {

    private Todos todos;
    private List<Todos> todoList;
    public ArrayList<Todos> todoArrayList;
    public TodosAdapter todoAdapter;
    public  ListView todoFormat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.read_function);

        final Button buttonAddNew = (Button) findViewById(R.id.buttonaddnew);
        todoFormat =  findViewById(R.id.todoformat);

        final TextView toDoTitle = findViewById(R.id.todotitle);



        todoArrayList = new ArrayList<>();
        todos = new Todos();
        todoList = Todos.listAll(Todos.class);

        for(int i=0; i<todoList.size(); i++){
            todos = todoList.get(i);
            todoArrayList.add(todos);
        }

        todoAdapter = new TodosAdapter(ReadActivity.this, todoArrayList);
        todoFormat.setAdapter(todoAdapter);



        buttonAddNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intention = new Intent(ReadActivity.this, CreateActivity.class);
                startActivity(intention);

            }
        });

        toDoTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReadActivity.this, UpDeleteActivity.class);
                startActivity(intent);
            }
        });



    }
}
