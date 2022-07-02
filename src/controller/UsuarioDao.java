package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;

public class UsuarioDao {
    
    public int inserir(Usuario u) throws Exception{
        int retorno;
        java.sql.Connection conexao = Conexao.getInstancia();
        String sql = "insert into usuario(nome, email, senha) values(?, ?, ?)";
                
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, u.getNome());
        ps.setString(2, u.getEmail());
        ps.setString(3, u.getSenha());
        
        retorno = ps.executeUpdate();
        ps.close();
        
        return retorno;
        
//        try {
//            ps = conexao.prepareStatement(sql);
//            ps.setString(1, u.getNome());
//            ps.setString(2, u.getEmail());
//            ps.setString(3, u.getSenha());
//            ps.executeUpdate();
//            
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            ps.close();
//        }
    }


        public int alterar(Usuario u) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "update usuario"
                    + "             set nome  =  ?,"
                    + "                 email = ?"
                    + "   where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setInt(3, u.getId());
            
            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }
        
        public int alterarSenha(Usuario u) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "update usuario"
                    + "             set nome  =  ?,"
                    + "                 email = ?,"
                    + "                 senha = ?"
                    + "   where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setString(2, u.getEmail());
            ps.setString(3, u.getSenha());
            ps.setInt(4, u.getId());
            
            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }

        
        public int excluir(Usuario u) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "delete from usuario where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, u.getId());
            

            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }
        
        public boolean existeUsuario(String email, String senha) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from usuario where email = ? and senha = ?";
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o email
                ps.setString(1, email);
                //Seta a senha
                ps.setString(2, senha);
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                return rs.next();
            } catch (Exception e) {
                throw new Exception("Erro ao verificar o login do usuario" +
                     e.getMessage());
            }
            
            /*
            try {
                //Prepara a conexao
                ps = conexao.prepareStatement(sql);
                //Seta o email
                ps.setString(1, email);
                //Seta a senha
                ps.setString(2, senha);
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                return rs.next();
                
            } catch (Exception e) {
                throw new Exception("Erro ao verificar o login do usuario" +
                         e.getMessage());
            } finally{
                ps.close();
            }*/
            
        }
        
        public Usuario buscarUsuario(int id) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from usuario where id = ?";
            
            Usuario u = null;
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setInt(1, id);
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    u = new Usuario();
                    u.setId(id);
                    u.setNome(rs.getString("nome"));
                    u.setEmail(rs.getString("email"));
                }
            } catch (Exception e) {
                throw e;
            }
            
            return u;
        }
        
        public List<Usuario> buscarUsuario(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from usuario where nome like ?";
            
            List<Usuario> usuarios = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%" + nome + "%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Usuario u = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                    usuarios.add(u);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return usuarios;
        }
        
        public List<Usuario> buscarTodosNomes(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from usuario where nome like ?";
            
            List<Usuario> usuarios = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Usuario u = new Usuario(rs.getInt("id"), rs.getString("nome"), rs.getString("email"));
                    usuarios.add(u);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return usuarios;
        }

    
}
