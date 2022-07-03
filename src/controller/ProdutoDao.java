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
import model.Produto;

/**
 *
 * @author Usuario
 */
public class ProdutoDao {
    public int inserir(Produto p) throws Exception{
        int retorno;
        java.sql.Connection conexao = Conexao.getInstancia();
        String sql = "insert into produto(nome, unidadeDeMedida) values(?, ?)";
                
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, p.getNome());
        ps.setString(2, p.getUnidadeDeMedida());
        retorno = ps.executeUpdate();
        ps.close();
        
        return retorno;
    }


        public int alterar(Produto p) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "update produto"
                    + "             set nome  =  ?,"
                    + "                 unidadeDeMedida = ?"
                    + "   where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, p.getNome());
            ps.setString(2, p.getUnidadeDeMedida());
            ps.setInt(3, p.getId());

            
            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }
        

        public int excluir(Produto p) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "delete from produto where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, p.getId());
            

            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }

        
        public Produto buscarProduto(int id) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from produto where id = ?";
            
            Produto p = null;
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setInt(1, id);
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    p = new Produto();
                    p.setId(id);
                    p.setNome(rs.getString("nome"));
                    p.setUnidadeDeMedida(rs.getString("unidadeDeMedida"));

                }
            } catch (Exception e) {
                throw e;
            }
            
            return p;
        }
        
        public List<Produto> buscarProduto(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from produto where nome like ?";
            
            List<Produto> produtos = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%" + nome + "%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Produto p = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("unidadeDeMedida"));
                    produtos.add(p);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return produtos;
        }
        
        public List<Produto> buscarTodosNomes(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from produto where nome like ?";
            
            List<Produto> produtos = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Produto u = new Produto(rs.getInt("id"), rs.getString("nome"), rs.getString("unidadeDeMedida"));
                    produtos.add(u);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return produtos;
        }
}
