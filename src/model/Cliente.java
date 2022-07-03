/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author Usuario
 */
public class Cliente {
    private int id;
    private String nome;
    private String cpfcnpj;
    private String telefone;
    private String observacao;
    private Date datacadastro;

    public Cliente() {
    }

    public Cliente(int id, String nome, String cpfcnpj, String telefone, String observacao) {
        this.id = id;
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.telefone = telefone;
        this.observacao = observacao;
    }

    public Cliente(int id, String nome, String cpfcnpj, String telefone, String observacao, Date datacadastro) {
        this.id = id;
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.telefone = telefone;
        this.observacao = observacao;
        this.datacadastro = datacadastro;
    }
    
    
    public Cliente(String nome, String cpfcnpj, String telefone, String observacao) {
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.telefone = telefone;
        this.observacao = observacao;
    }
    
    public Cliente(String nome, String cpfcnpj, String telefone, String observacao, Date datacadastro) {
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.telefone = telefone;
        this.observacao = observacao;
        this.datacadastro = datacadastro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getDatacadastro() {
        return datacadastro;
    }

    public void setDatacadastro(Date datacadastro) {
        this.datacadastro = datacadastro;
    }

    
    
    
}
