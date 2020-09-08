package com.example.nacjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex2 extends AppCompatActivity {

    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        this.path = getApplicationContext().getFilesDir().getPath().toString();
    }
    public void Salvar(View v) {
        EditText txtNome = findViewById(R.id.txtNome);
        EditText txtNota = findViewById(R.id.txtNota);

        String nome = txtNome.getText().toString();
        String nota = txtNota.getText().toString();
        String nomeNota = this.path + "/" + nome + ".txt";

            try {

                OutputStreamWriter saida = new OutputStreamWriter(new FileOutputStream(nomeNota), "UTF-8");
                saida.write(nota);
                saida.close();

            } catch (FileNotFoundException e) {
                Toast.makeText(this, "Arquivo não encontrado ...", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public void Recuperar(View v) {
        EditText txtNome = findViewById(R.id.txtNome);
        EditText txtNota = findViewById(R.id.txtNota);
        String nome = txtNome.getText().toString();
        String nomeNota = this.path + "/" + nome + ".txt";

        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(nomeNota), "UTF-8"));
            StringBuilder output = new StringBuilder();

            String linha = bf.readLine();

            while(linha != null) {
                output.append(linha);
                output.append("\n");
                linha = bf.readLine();
            }

            txtNota.setText(output.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Limpar(View view) {
        EditText nota = findViewById(R.id.txtNota);
        nota.setText("");
    }
}