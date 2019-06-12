package com.example.marlonsodre.tp3_desenvolvimento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class NomesActivity extends AppCompatActivity {
    DatabaseReference databaseContatos;
    ListView listViewContatos;
    List<Contatos> contatos;

    public static final String CONTATO_ID = "contatoid";
    public static final String CONTATO_NOME = "contatonome";
    public static final String CONTATO_SENHA = "contatosenha";
    public static final String CONTATO_EMAIL = "contatoemail";
    public static final String CONTATO_TELEFONE = "contatotelefone";
    public static final String CONTATO_CELULAR = "contatocelular";
    public static final String CONTATO_CPF = "contatocpf";
    public static final String CONTATO_CIDADE = "contatocidade";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nomes);

        listViewContatos = (ListView) findViewById(R.id.listContatos);
        contatos = new ArrayList<>();
        databaseContatos = FirebaseDatabase.getInstance().getReference("Contatos");

        listViewContatos.setOnItemSelectedListener(mostrarInformacoes);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseContatos.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //aparecer os artistas
                contatos.clear();
                for(DataSnapshot contatosSnapshot: dataSnapshot.getChildren()){
                    Contatos contato = contatosSnapshot.getValue(Contatos.class);

                    contatos.add(contato);
                }
                //Crear o adapter da Array
                ContatosLista adapter = new ContatosLista(NomesActivity.this, contatos);
                listViewContatos.setAdapter(adapter);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private AdapterView.OnItemSelectedListener mostrarInformacoes = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            Contatos contato = contatos.get(position);
            Intent intent = new Intent(getApplicationContext(), ContatosActivity.class);
            intent.putExtra(CONTATO_ID , contato.getContatoId());
            intent.putExtra(CONTATO_NOME, contato.getContatoNome());
            intent.putExtra(CONTATO_SENHA, contato.getContatoSenha());
            intent.putExtra(CONTATO_EMAIL, contato.getContatoEmail());
            intent.putExtra(CONTATO_TELEFONE, contato.getContatoTelefone());
            intent.putExtra(CONTATO_CELULAR, contato.getContatoCelular());
            intent.putExtra(CONTATO_CPF, contato.getContatoCpf());
            intent.putExtra(CONTATO_CIDADE, contato.getContatoCidade());
            startActivity(intent);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
