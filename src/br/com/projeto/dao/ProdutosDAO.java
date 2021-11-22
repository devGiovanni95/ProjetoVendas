/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Produtos;
import java.sql.Connection;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geu_p
 */
public class ProdutosDAO {

    /*toda vez que chamar o atributo CON ele vai abrir uma conexao com o banco de dados*/
    private Connection con;

    public ProdutosDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo Cadastrar Produtos
    public void cadastrar(Produtos obj) {
        try {

            // 1 passo Comando SQL
            String sql = "insert into tb_produtos(descricao, preco, qtd_estoque,for_id) values(?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescrição());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());
            stmt.setInt(4, obj.getFornecedor().getId());//tranforma o objeto em um numeto no caso do id;

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

}
