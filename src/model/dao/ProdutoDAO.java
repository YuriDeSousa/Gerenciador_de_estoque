/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Produto;

/**
 *
 * @author ys660
 */
public class ProdutoDAO {
    public void create(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO produto (nome, valor, qtd)VALUES(?,?,?)");
            stmt.setString(1,p.getNome() );
            stmt.setDouble(2,p.getValor());
            stmt.setInt(3, p.getQtd());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao salvar" + ex);

        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public ArrayList<Produto> read(){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM produto ORDER BY nome ASC");
            rs = stmt.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCod(rs.getInt("cod"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                produto.setQtd(rs.getInt("qtd"));
                produtos.add(produto);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    public ArrayList<Produto> search(String nome){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Produto> produtos = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
            stmt.setString(1, "%"+nome+"%");
            rs = stmt.executeQuery();
            while(rs.next()){
                Produto produto = new Produto();
                produto.setCod(rs.getInt("cod"));
                produto.setNome(rs.getString("nome"));
                produto.setValor(rs.getDouble("valor"));
                produto.setQtd(rs.getInt("qtd"));
                produtos.add(produto);

            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        return produtos;
    }
    public void update(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE produto SET nome = ?, valor = ? , qtd = ? WHERE cod = ?");
            stmt.setString(1,p.getNome() );
            stmt.setDouble(2,p.getValor());
            stmt.setInt(3, p.getQtd());
            stmt.setInt(4, p.getCod());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);

        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void upCompra(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE produto SET qtd = ? WHERE cod = ?");
            
            stmt.setInt(1, p.getQtd() - p.getQtd_venda());
            stmt.setInt(2, p.getCod());
            
            stmt.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar" + ex);

        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
   
    
    public void delete(Produto p){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM produto WHERE cod = ?");
            stmt.setInt(1, p.getCod());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ProdutoDAO.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir" + ex);

        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
