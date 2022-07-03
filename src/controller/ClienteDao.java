package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Cliente;

public class ClienteDao {
    public int inserir(Cliente c) throws Exception{
        int retorno;
        java.sql.Connection conexao = Conexao.getInstancia();
        String sql = "insert into cliente(nome, cpfcnpj, telefone, observacao) values(?, ?, ?, ?)";
                
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, c.getNome());
        ps.setString(2, c.getCpfcnpj());
        ps.setString(3, c.getTelefone());
        ps.setString(4, c.getObservacao());
        
        retorno = ps.executeUpdate();
        ps.close();
        
        return retorno;
    }
    
        public int alterar(Cliente c) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "update cliente"
                    + "             set nome  =  ?,"
                    + "                 cpfcnpj = ?,"
                    + "                 telefone = ?,"
                    + "                 observacao = ?"
                    + "   where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, c.getNome());
            ps.setString(2, c.getCpfcnpj());
            ps.setString(3, c.getTelefone());
            ps.setString(4, c.getObservacao());
            ps.setInt(5, c.getId());
            
            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }
        
        public int excluir(Cliente c) throws Exception {
            int retorno;
            java.sql.Connection conexao = Conexao.getInstancia();
            String sql = "delete from cliente where id = ?";

            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, c.getId());
            

            retorno = ps.executeUpdate();
            ps.close();

            return retorno;
        }
        
        public Cliente buscarCliente(int id) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from cliente where id = ?";
            
            Cliente p = null;
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setInt(1, id);
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    p = new Cliente();
                    p.setId(id);
                    p.setNome(rs.getString("nome"));
                    p.setCpfcnpj(rs.getString("cpfcnpj"));
                    p.setTelefone(rs.getString("telefone"));
                    p.setObservacao(rs.getString("observacao"));

                }
            } catch (Exception e) {
                throw e;
            }
            
            return p;
        }
        
        public List<Cliente> buscarCliente(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from cliente where nome like ?";
            
            List<Cliente> produtos = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%" + nome + "%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Cliente p = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpfcnpj"), 
                            rs.getString("telefone"), rs.getString("observacao"));
                    produtos.add(p);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return produtos;
        }
        
        public List<Cliente> buscarTodosNomes(String nome) throws Exception{
            //PreparedStatement ps = null;
            Connection conexao = Conexao.getInstancia();
            
            String sql = "select * from cliente where nome like ?";
            
            List<Cliente> clientes = new ArrayList<>();
            
            //try catch com recurso - menos linhas de códigos
            //fecha a conexao, nao precisa chamar ps.close();
            try (PreparedStatement ps = conexao.prepareStatement(sql)){
                
                //Seta o id
                ps.setString(1, "%%");
                
                
                //Metodo 'executeQuery' serve para consultas
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    Cliente p = new Cliente(rs.getInt("id"), rs.getString("nome"), rs.getString("cpfcnpj"), 
                            rs.getString("telefone"), rs.getString("observacao"));
                    clientes.add(p);
                }
            } catch (Exception e) {
                throw e;
            }
            
            return clientes;
        }
}
