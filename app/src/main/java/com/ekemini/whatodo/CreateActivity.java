package com.ekemini.whatodo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.ekemini.whatodo.adapter.TodosAdapter;
import com.ekemini.whatodo.todosmodel.Todos;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CreateActivity extends AppCompatActivity {

    private Todos todos;
    private List<Todos> todoList;
    public ArrayList<Todos> todoArrayList;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_function);

        final EditText taskSubject = findViewById(R.id.tasksubject);
        final EditText taskPlanning = findViewById(R.id.taskplanning);
        final EditText taskDate = findViewById(R.id.taskdating);
        Button createButton = findViewById(R.id.createbutton);
        final Button cancelButton = findViewById(R.id.cancelbutton);

        todoArrayList = new ArrayList<>();
        todos = new Todos();
        todoList = Todos.listAll(Todos.class);

        for(int i=0; i<todoList.size(); i++){
            todos = todoList.get(i);
            todoArrayList.add(todos);
        }


        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String task_subject = taskSubject.getText().toString().trim();
                String task_planning = taskPlanning.getText().toString().trim();
                String task_date = taskDate.getText().toString().trim();

                todos = new Todos();
                todos.setCreateTitle(task_subject);
                todos.setCreatePlanning(task_planning);
                todos.setCreateDate(task_date);
                todos.save();


                Intent intention = new Intent(CreateActivity.this, ReadActivity.class);
                startActivity(intention);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intention = new Intent(CreateActivity.this, ReadActivity.class);
                startActivity(intention);

            }
        });





    }
}
