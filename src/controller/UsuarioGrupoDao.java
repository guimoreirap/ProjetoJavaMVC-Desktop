/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.UsuarioGrupo;

/**
 *
 * @author aluno
 */
public class UsuarioGrupoDao {
    public int inserir(UsuarioGrupo u) throws Exception{
        int retorno;
        java.sql.Connection conexao = Conexao.getInstancia();
        String sql = "insert into usuariogrupo(nome) values(?)";
                
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, u.getNome());
        
        retorno = ps.executeUpdate();
        ps.close();
        
        return retorno;
    }
    
    public int alterar(UsuarioGrupo u) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "update usuariogrupo"
                    + "             set nome  =  ?"
                    + "   where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, u.getNome());
            ps.setInt(2, u.getId());
            
            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }
    
    public int excluir(UsuarioGrupo u) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "delete from usuariogrupo where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, u.getId());
            

            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }

    public UsuarioGrupo buscarUsuario(int id) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from usuariogrupo where id = ?";
            
            UsuarioGrupo u = null;
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setInt(1, id);
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    u = new UsuarioGrupo();
                    u.setId(id);
                    u.setNome(rs.getString("nome"));
                }
            } catch (Exception e) {
                throw e;
            }
            
            return u;
        }
    
    public List<UsuarioGrupo> buscarUsuario(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from usuariogrupo where nome like ?";
            
            List<UsuarioGrupo> usuarios = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%" + nome + "%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    UsuarioGrupo u = new UsuarioGrupo(rs.getInt("id"), rs.getString("nome"));
                    usuarios.add(u);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return usuarios;
        }
        
        public List<UsuarioGrupo> buscarTodosNomes(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from usuariogrupo where nome like ?";
            
            List<UsuarioGrupo> usuarios = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    UsuarioGrupo u = new UsuarioGrupo(rs.getInt("id"), rs.getString("nome"));
                    usuarios.add(u);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return usuarios;
        }
}
