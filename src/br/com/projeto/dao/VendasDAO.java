package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Clientes;
import br.com.projeto.model.Fornecedores;
import br.com.projeto.model.Produtos;
import br.com.projeto.model.Vendas;

import java.sql.Connection;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
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
    
    //Método que filtra Vendas por data
    public List<Vendas> listarVendasPorPeriodo(LocalDate data_inicio, LocalDate data_fim) {
        try {

            //1 passo criar a lista
            List<Vendas> lista = new ArrayList<>();

            // 2 passo criar o sql, organizar e executar
          /*  String sql = "select v.id, v.data_venda, c.nome, v.total_venda, v.observacoes from tb_vendas as v "
                    + "inner join tb_clientes as c on (v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ? ";*/

            //com a data formatada
              String sql = "select v.id, date_format(v.data_venda, '%d%m%Y') as data_formatada, c.nome, v.total_venda, v.observacoes from tb_vendas as v "
                    + "inner join tb_clientes as c on (v.cliente_id = c.id) where v.data_venda BETWEEN ? AND ? ";

            
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, data_inicio.toString());//converter para string
            stmt.setString(2, data_fim.toString());

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Vendas obj = new Vendas();
                Clientes c = new Clientes();

                obj.setId(rs.getInt("v.id"));

                //precisamos mudar o nome do campo pois formatamos a data para aparecer mais simples
               //obj.setData_venda(rs.getString("v.data_venda"));
                obj.setData_venda(rs.getString("data_formatada"));

                c.setNome(rs.getString("c.nome"));
                obj.setTotal_venda(rs.getDouble("v.total_venda"));
                obj.setObs(rs.getString("v.observacoes"));

                obj.setCliente(c);

                lista.add(obj);

            }

            return lista;

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }
    }


}
