package com.ekemini.whatodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.ekemini.whatodo.adapter.TodosAdapter;
import com.ekemini.whatodo.todosmodel.Todos;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class UpDeleteActivity extends AppCompatActivity {

    private Todos todos;
    private List<Todos> todoList;
    public ArrayList<Todos> todoArrayList;
    public TodosAdapter todoAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_delete_function);

        final EditText taskSubject = findViewById(R.id.tasksubject);
        final EditText taskPlanning = findViewById(R.id.taskplanning);
        final EditText taskDate = findViewById(R.id.taskdating);
        Button updateButton = findViewById(R.id.updatebutton);
        final Button deleteButton = findViewById(R.id.deletebutton);

        todoArrayList = new ArrayList<>();
        todos = new Todos();
        todoList = Todos.listAll(Todos.class);

        for(int i=0; i<todoList.size(); i++){
            todos = todoList.get(i);
            todoArrayList.add(todos);
        }

        todoAdapter = new TodosAdapter(UpDeleteActivity.this, todoArrayList);


        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intention = new Intent(UpDeleteActivity.this, ReadActivity.class);
                startActivity(intention);

            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intention = new Intent(UpDeleteActivity.this, ReadActivity.class);
                startActivity(intention);

                todos.delete();
                todoArrayList.add(todos);


            }
        });








    }
}
