package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
import br.com.projeto.model.Vendas;

import java.sql.Connection;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author geu_p
 */
public class VendasDAO {
    /*toda vez que chamar o atributo CON ele vai abrir uma conexao com o banco de dados*/
    private Connection con;

    public VendasDAO() {
        this.con = new ConnectionFactory().getConnection();
    }


    //Cadastrar venda
    public void cadastrarVenda(Vendas obj){
        try {

            String sql = "insert into tb_vendas (cliente_id, data_venda, total_venda, observacoes) values (?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1,obj.getCliente().getId());
            stmt.setString(2,obj.getData_venda());
            stmt.setDouble(3,obj.getTotal_venda());
            stmt.setString(4,obj.getObs());

            stmt.execute();
            stmt.close();

        }catch (Exception erro){
            JOptionPane.showMessageDialog(null,"Erro :" + erro);
        }
    }


    //Retorna a ultima venda

    public int retornaUltimaVenda(){
        try {
            int idvenda = 0;

            String sql = "select max(id) id from tb_vendas ";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Vendas p = new Vendas();

                p.setId(rs.getInt("id"));

                idvenda = p.getId();
            }

            return idvenda;

        }catch (SQLException sqlException){
            throw  new RuntimeException(sqlException);
        }
    }


}
