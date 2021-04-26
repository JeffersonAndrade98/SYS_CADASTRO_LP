    package controller;

import java.sql.*;

import model.CadastroModel;
import javax.swing.JOptionPane;



public class CadastroController {
    
    Conexao cone = new Conexao();
    CadastroModel user = new CadastroModel();
    
    
    public void salvar(CadastroModel user) {
        
        cone.conectar();
        
        try{
            
            PreparedStatement pst = cone.con.prepareStatement ("INSERT INTO cadastro (quant, nome, telefone, cidade_origem, "
                    + "cidade_destino, status, valorpg, valortotal, data_viagem) VALUES(?,?,?,?,?,?,?,?,?)");
                    
                    pst.setString(1, user.getQuant());
                    pst.setString(2, user.getNome());
                    pst.setString(3, user.getTelefone());
                    pst.setString(4, user.getCidade_origem());
                    pst.setString(5, user.getCidade_destino());
                    pst.setString(6, user.getStatus());
                    pst.setFloat(7, user.getValorPg());
                    pst.setFloat(8, user.getValortotal());
                    pst.setDate(9,(Date) new Date (user.getData_viagem().getTime()));
                    
                    
                    pst.execute();
                    
                    JOptionPane.showMessageDialog(null, "Reserva feita com sucesso!");
            
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(null, "ERRO AO SALVAR!!!\n Erro: " +ex);
                    
        }
    }
    
    public void editar(CadastroModel user){
        cone.conectar();
        
        try{
            PreparedStatement pst = cone.con.prepareStatement("UPDATE cadastro SET quant=?, nome=?, telefone=?, cidade_origem=?, cidade_destino=?, status=?, valorpg=?, valortotal=?, data_viagem=? WHERE id=? ");
            
            pst.setString(1, user.getQuant());
            pst.setString(2, user.getNome());
            pst.setString(3, user.getTelefone());
            pst.setString(4, user.getCidade_origem());
            pst.setString(5, user.getCidade_destino());
            pst.setString(6, user.getStatus());
            pst.setFloat(7, user.getValorPg());
            pst.setFloat(8, user.getValortotal());
            pst.setDate(9,(Date) new Date (user.getData_viagem().getTime()));
            pst.setInt(10, user.getId());
            pst.execute();
            
            JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
            
        }catch(SQLException ex){
            //JOptionPane.showMessageDialog(null, "Erro na alteração dos dados!!!"+ex);
        }
        cone.desconectarBanco();
    }
    
    public CadastroModel buscaUsuario(CadastroModel user){
    cone.conectar();
    cone.executeSql("SELECT *FROM cadastro WHERE NOME LIKE '%"+user.getPesquisa()+"%'");
    try {
        cone.rs.first();
        user.setQuant(cone.rs.getString("quant"));
        user.setNome(cone.rs.getString("nome"));
        user.setTelefone(cone.rs.getString("telefone"));
        user.setCidade_origem(cone.rs.getString("cidade_origem"));
        user.setCidade_destino(cone.rs.getString("cidade_destino"));
        user.setStatus(cone.rs.getString("status"));
        user.setValorPg(cone.rs.getFloat("valorpg"));
        user.setValortotal(cone.rs.getFloat("valortotal"));
        user.setData_viagem(cone.rs.getDate("data_viagem"));
        
    } catch (SQLException e) {
        //JOptionPane.showMessageDialog(null, "USUARIO NÃO ENCONTRADO!");
        
    }
    cone.desconectarBanco();
    return user;
}
    public CadastroModel filtrarRegistro(CadastroModel user){
    cone.conectar();
    cone.executeSql("SELECT *FROM cadastro WHERE data_viagem >= '"+user.getPesquisa()+"'");
    try {
        cone.rs.first();
        user.setQuant(cone.rs.getString("quant"));
        user.setNome(cone.rs.getString("nome"));
        user.setTelefone(cone.rs.getString("telefone"));
        user.setCidade_origem(cone.rs.getString("cidade_origem"));
        user.setCidade_destino(cone.rs.getString("cidade_destino"));
        user.setStatus(cone.rs.getString("status"));
        user.setValorPg(cone.rs.getFloat("valorpg"));
        user.setValortotal(cone.rs.getFloat("valortotal"));
        user.setData_viagem(cone.rs.getDate("data_viagem"));
        
    } catch (SQLException e) {
        //JOptionPane.showMessageDialog(null, "USUARIO NÃO ENCONTRADO!");
        
    }
    cone.desconectarBanco();
    return user;
}
    
    public void delete(CadastroModel usuario) {
        cone.conectar();
        
        int resp1=JOptionPane.showConfirmDialog(null, "Deseja excluir este cadastro?");
        
        if(resp1 == JOptionPane.YES_NO_OPTION){
        try {
            PreparedStatement ps = cone.con.prepareStatement("DELETE FROM cadastro WHERE id = ?");
            ps.setInt(1, usuario.getId());
            ps.execute();   
            JOptionPane.showMessageDialog(null, "Cadastro excluido!");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!!!");
        }
        }
        cone.desconectarBanco();
    }
    
    public void delete_all(CadastroModel user){
        cone.conectar();
        
        int resp=JOptionPane.showConfirmDialog(null,"Todos os dados serão excluidos! Confirmar?");
        
        if(resp == JOptionPane.YES_OPTION){
         try{
           PreparedStatement ps = cone.con.prepareStatement("delete from cadastro");
           ps.execute();
           JOptionPane.showMessageDialog(null, "Todos os dados foram excluidos");
           
        }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Erro ao excluir dados da tabela!");
        }
        cone.desconectarBanco();
        }
    }
}