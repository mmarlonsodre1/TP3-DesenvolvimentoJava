package com.example.marlonsodre.tp3_desenvolvimento;

public class Contatos {
    String contatoNome;
    String contatoSenha;
    String contatoEmail;
    String contatoTelefone;
    String contatoCelular;
    String contatoCpf;
    String contatoCidade;
    String contatoId;

    public  Contatos(){}

    public Contatos( String contatoId, String contatoNome, String contatoSenha, String contatoEmail, String contatoTelefone, String contatoCelular, String contatoCpf, String contatoCidade) {
        this.contatoNome = contatoNome;
        this.contatoSenha = contatoSenha;
        this.contatoEmail = contatoEmail;
        this.contatoTelefone = contatoTelefone;
        this.contatoCelular = contatoCelular;
        this.contatoCpf = contatoCpf;
        this.contatoCidade = contatoCidade;
        this.contatoId = contatoId;
    }

    public String getContatoNome() {
        return contatoNome;
    }

    public String getContatoSenha() {
        return contatoSenha;
    }

    public String getContatoEmail() {
        return contatoEmail;
    }

    public String getContatoTelefone() {
        return contatoTelefone;
    }

    public String getContatoCelular() {
        return contatoCelular;
    }

    public String getContatoCpf() {
        return contatoCpf;
    }

    public String getContatoCidade() {
        return contatoCidade;
    }

    public String getContatoId() {
        return contatoId;
    }
}
