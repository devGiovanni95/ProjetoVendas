/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.ItemVenda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author geu_p
 */
public class ItemVendaDAO {
    
      private Connection con;

    public ItemVendaDAO() {
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo que cadastra itens
    public void cadastraItem(ItemVenda obj){
        try {
            
            String sql = "insert into tb_itensvendas(venda_id, produto_id, qtd, subtotal) values (?,?,?,?) ";
            
//2passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,obj.getVenda().getId());
            stmt.setInt(2,obj.getProduto().getId());
            stmt.setInt(3, obj.getQtd());
            stmt.setDouble(4, obj.getSubtotal());

            stmt.execute();
            stmt.close();

            /*Para nao aparecer a mensagem para cada item que adicionarmos mostrar uma mensagem por vez*/
            //JOptionPane.showMessageDialog(null, "Item Registrado com Sucesso");
            

            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Erro : " + e);
        }
    }
    
}
