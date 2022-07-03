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
import model.ProdutoCategoria;

/**
 *
 * @author Usuario
 */
public class ProdutoCategoriaDao {
    public int inserir(ProdutoCategoria p) throws Exception{
        int retorno;
        java.sql.Connection conexao = Conexao.getInstancia();
        String sql = "insert into produtocategoria(nome) values(?)";
                
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, p.getNome());
        
        retorno = ps.executeUpdate();
        ps.close();
        
        return retorno;
    }


        public int alterar(ProdutoCategoria p) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "update produtocategoria"
                    + "             set nome  =  ?"
                    + "   where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setInt(2, p.getId());

            
            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }
        

        public int excluir(ProdutoCategoria p) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "delete from produtocategoria where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, p.getId());
            

            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }

        
        public ProdutoCategoria buscarCategoria(int id) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from produtocategoria where id = ?";
            
            ProdutoCategoria p = null;
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setInt(1, id);
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    p = new ProdutoCategoria();
                    p.setId(id);
                    p.setNome(rs.getString("nome"));

                }
            } catch (Exception e) {
                throw e;
            }
            
            return p;
        }
        
        public List<ProdutoCategoria> buscarUsuario(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from produtocategoria where nome like ?";
            
            List<ProdutoCategoria> categorias = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%" + nome + "%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ProdutoCategoria u = new ProdutoCategoria(rs.getInt("id"), rs.getString("nome"));
                    categorias.add(u);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return categorias;
        }
        
        public List<ProdutoCategoria> buscarTodosNomes(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from produtocategoria where nome like ?";
            
            List<ProdutoCategoria> categorias = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    ProdutoCategoria u = new ProdutoCategoria(rs.getInt("id"), rs.getString("nome"));
                    categorias.add(u);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return categorias;
        }
}
