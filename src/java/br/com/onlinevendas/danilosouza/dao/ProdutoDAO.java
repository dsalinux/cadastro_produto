package br.com.onlinevendas.danilosouza.dao;

import br.com.onlinevendas.danilosouza.entidade.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProdutoDAO {

    public Connection abrirConexao(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexao;
            conexao = DriverManager.getConnection("jdbc:mysql://localhost/provasubstitutiva", "root","root");
            return conexao;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void salvar(Produto p){
        try {
            PreparedStatement ps;
            ps = abrirConexao().prepareStatement("insert into produto (nome, valor) values (?,?)");
            ps.setString(1, p.getNome());
            ps.setFloat(2, p.getValor());
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Produto> buscar(){
        try {
            PreparedStatement ps;
            ps = abrirConexao().prepareStatement("select * from produto");
            ResultSet rs = ps.executeQuery();
            List<Produto> listaDosProdutos = new ArrayList<>();
            while(rs.next()){
                Produto p = new Produto();
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getFloat("valor"));
                listaDosProdutos.add(p);
            }
            return listaDosProdutos;
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
}
