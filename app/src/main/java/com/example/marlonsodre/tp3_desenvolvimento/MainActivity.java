package com.example.marlonsodre.tp3_desenvolvimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseContatos;


    EditText edtNome, edtSenha, edtEmail, edtTelefone, edtCelular, edtCPF, edtCidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseContatos = FirebaseDatabase.getInstance().getReference("Contatos");

         edtNome = (EditText)findViewById(R.id.edtNome);
         edtSenha = findViewById(R.id.edtSenha);
         edtEmail = findViewById(R.id.edtEmail);
         edtTelefone = findViewById(R.id.edtTelefone);
         edtCelular = findViewById(R.id.edtCelular);
         edtCPF = findViewById(R.id.edtCPF);
         edtCidade = findViewById(R.id.edtCidade);


    }


    public void AddContatos(View view){
        final EditText edtNome = (EditText) findViewById(R.id.edtNome);
        final EditText edtSenha = (EditText) findViewById(R.id.edtSenha);
        final EditText edtEmail = (EditText) findViewById(R.id.edtEmail);
        final EditText edtTelefone = (EditText) findViewById(R.id.edtTelefone);
        final EditText edtCelular = (EditText) findViewById(R.id.edtCelular);
        final EditText edtCPF = (EditText) findViewById(R.id.edtCPF);
        final EditText edtCidade = (EditText) findViewById(R.id.edtCidade);

        String nome = edtNome.getText().toString().trim();
        String senha = edtSenha.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String telefone = edtTelefone.getText().toString().trim();
        String celular = edtCelular.getText().toString().trim();
        String cpf = edtCPF.getText().toString().trim();
        String cidade = edtCidade.getText().toString().trim();

        if(nome.isEmpty() || senha.isEmpty() || email.isEmpty() || telefone.isEmpty() || celular.isEmpty() || cpf.isEmpty() || cidade.isEmpty()) {
            Toast.makeText(getApplicationContext(),"Erro ao Salvar Contato", Toast.LENGTH_LONG).show();

        }else{
            String id = databaseContatos.push().getKey();
            Contatos contatos = new Contatos(id, nome, senha, email, telefone, celular, cpf, cidade);
            databaseContatos.child(id).setValue(contatos);

            edtNome.setText("");
            edtSenha.setText("");
            edtEmail.setText("");
            edtTelefone.setText("");
            edtCelular.setText("");
            edtCPF.setText("");
            edtCidade.setText("");
            //display
            Toast.makeText(getApplicationContext(), "Contato Salvo", Toast.LENGTH_LONG).show();
        }

    }

    public void limpar (View view){
        edtNome.setText("");
        edtSenha.setText("");
        edtEmail.setText("");
        edtTelefone.setText("");
        edtCelular.setText("");
        edtCPF.setText("");
        edtCidade.setText("");
    }

    public void irContatos (View view){
        Intent intent = new Intent(this, NomesActivity.class);
        startActivity(intent);
    }
}
