package com.example.nacjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Ex1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex1);
    }
    public void  pesquisar(View v) {

        EditText txtId = findViewById(R.id.txtId);
        TextView txtTitle = findViewById(R.id.txtTitle);
        TextView txtCompleted = findViewById(R.id.txtCompleted);

        txtTitle.setText("");
        txtCompleted.setText("");

        String url = "https://jsonplaceholder.typicode.com/todos/" + txtId.getText().toString();

        new DataGetter(txtTitle, txtCompleted).execute(url);
    }
}