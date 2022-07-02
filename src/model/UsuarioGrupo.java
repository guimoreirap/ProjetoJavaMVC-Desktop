/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author aluno
 */
public class UsuarioGrupo {
    private int id;
    public String nome;
    
    public UsuarioGrupo(){
        
    }
    
    public UsuarioGrupo(String nome){
        this.nome = nome;
    }

    public UsuarioGrupo(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
        
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
