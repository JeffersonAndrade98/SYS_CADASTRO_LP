/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author JeffersonAndrade
 */
public class Conexao {
    
    public Statement stm;
    
    public ResultSet rs;
    
    private String driver="org.mysql.Driver";
    
    private String caminho="jdbc:mysql://s3lkt7lynu0uthj8.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/annrbfl4d7nvtm41";
    
    private String usuario="bh3hupbcax157e22";
    
    private String senha="lv861lh2dhp55jt9";
    
    public Connection con;
    
    public void conectar(){
        try{
            System.setProperty("jdbc.Drivers", driver);
            con=DriverManager.getConnection(caminho, usuario, senha);
            
            //JOptionPane.showMessageDialog(null, "Conexão realizada com sucesso : )");
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERRO! SISTEMA OFFLINE\n"+ex.getMessage());
        }
    }
    public static void main(String[] args) {
        Conexao conecta = new Conexao();
        conecta.conectar();
    }
    
    public void executeSql(String sql){
        try{
            stm=con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs=stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO! NÃO FOI POSSÍVEL ACESSAR O BANCO DE DADOS");
        }
    }
         public void desconectarBanco(){
            try{
                con.close();
            }catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERRO AO FECHAR O BANCO");
            }
        }
    
}

