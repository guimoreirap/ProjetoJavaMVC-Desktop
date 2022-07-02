package Teste;

import controller.UsuarioDao;
import model.Usuario;

public class UsuarioExcluir {
    public static void main(String[] args) throws Exception{
        UsuarioDao dao = new UsuarioDao();
        Usuario u = new Usuario();
        u.setId(1);
        dao.excluir(u);
        
        System.out.println("Registro excluido com sucesso");
        
        
    }
}
