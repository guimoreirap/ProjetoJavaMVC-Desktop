/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Teste;

import controller.UsuarioDao;
import model.Usuario;

/**
 *
 * @author aluno
 */
public class UsuarioAlterar {
    public static void main(String[] args) throws Exception{
        Usuario u = new Usuario();
        u.setId(2);
        u.setNome("Bomba Patch 100% atualizado");
        u.setEmail("BP@hotmail.com atualizado");
        
        UsuarioDao dao = new UsuarioDao();
        dao.alterar(u);
        
        System.out.println("Registro ALTERADO com sucesso");
        
        
    }
}
