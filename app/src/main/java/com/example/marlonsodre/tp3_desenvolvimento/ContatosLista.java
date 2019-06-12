package com.example.marlonsodre.tp3_desenvolvimento;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static com.example.marlonsodre.tp3_desenvolvimento.NomesActivity.CONTATO_ID;

public class ContatosLista extends ArrayAdapter<Contatos> {
    private Activity context;
    private List<Contatos> contatosList;


    public ContatosLista(Activity context,List<Contatos> contatosList) {
        super(context, R.layout.list_view_nome, contatosList);
        this.contatosList = contatosList;
        this.context = context;

        final Intent intent = getIntent();
        String id = intent.getStringExtra(NomesActivity.CONTATO_ID);
        String name = intent.getStringExtra(NomesActivity.CONTATO_NOME);
        String senha = intent.getStringExtra(NomesActivity.CONTATO_SENHA);
        String email = intent.getStringExtra(NomesActivity.CONTATO_EMAIL);
        String telefone = intent.getStringExtra(NomesActivity.CONTATO_TELEFONE);
        String celular = intent.getStringExtra(NomesActivity.CONTATO_CELULAR);
        String cpf = intent.getStringExtra(NomesActivity.CONTATO_CPF);
        String cidade = intent.getStringExtra(NomesActivity.CONTATO_CIDADE);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_view_nome, null, true);
        TextView txtName = (TextView) listViewItem.findViewById(R.id.txtNome);
        Contatos contato = contatosList.get(position);
        txtName.setText(contato.getContatoNome());
        return listViewItem;


    }
}
