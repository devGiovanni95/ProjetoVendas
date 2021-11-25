/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Fornecedores;
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

    //Metodo listar Produtos
    public List<Produtos> listarProdutos() {
        try {

            //1 passo criar a lista
            List<Produtos> lista = new ArrayList<>();

            // 2 passo criar o sql, organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id)";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();

                obj.setId(rs.getInt("p.id"));
                obj.setDescrição(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);

                lista.add(obj);

            }

            return lista;

            // JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }
    }

    //Metodo listarProdutoPorNome Produtos
    public List<Produtos> listarProdutoPorNome(String nome) {
        try {

            //1 passo criar a lista
            List<Produtos> lista = new ArrayList<>();

            // 2 passo criar o sql, organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao like ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos obj = new Produtos();
                Fornecedores f = new Fornecedores();

                obj.setId(rs.getInt("p.id"));
                obj.setDescrição(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));
                obj.setFornecedor(f);

                lista.add(obj);

            }

            return lista;

            // JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);
            return null;

        }
    }

    //Metodo consultaPorNome Produtos
    public Produtos consultaPorNome(String nome) {
        try {

            //1 passo criar a lista
            List<Produtos> lista = new ArrayList<>();

            // 2 passo criar o sql, organizar e executar
            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.descricao = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescrição(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));

                obj.setFornecedor(f);
            }

            return obj;

            // JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Produto não encontrado! ");
            return null;

        }
    }


    //variação de pesquisa
    //Metodo buscaProduto por Codigo
    public Produtos buscaPorCodigoCompleta(int id) {
        try {
            // 1 passo criar o sql, organizar e executar

            String sql = "select p.id, p.descricao, p.preco, p.qtd_estoque, f.nome from tb_produtos as p "
                    + "inner join tb_fornecedores as f on (p.for_id = f.id) where p.id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();
            Fornecedores f = new Fornecedores();

            if (rs.next()) {

                obj.setId(rs.getInt("p.id"));
                obj.setDescrição(rs.getString("p.descricao"));
                obj.setPreco(rs.getDouble("p.preco"));
                obj.setQtd_estoque(rs.getInt("p.qtd_estoque"));

                f.setNome(rs.getString("f.nome"));

                obj.setFornecedor(f);
            }

            return obj;

            // JOptionPane.showMessageDialog(null, "Produto Cadastrado com Sucesso!");
        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Produto não encontrado! ");
            return null;

        }
    }

    //Variacao da pesquisa acima simplificada
    //Metodo buscaProduto por Codigo
    public Produtos buscaPorCodigo(int id) {
        try {
            // 1 passo criar o sql, organizar e executar

            String sql = "select * from tb_produtos where id = ?";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();
            Produtos obj = new Produtos();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setDescrição(rs.getString("descricao"));
                obj.setPreco(rs.getDouble("preco"));
                obj.setQtd_estoque(rs.getInt("qtd_estoque"));

            }

            return obj;

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Produto não encontrado! ");
            return null;

        }
    }


    //Metodo Alterar Produtos
    public void alterar(Produtos obj) {
        try {

            // 1 passo Comando SQL
            String sql = "update tb_produtos set descricao=?, preco=?, qtd_estoque=?, for_id=? where id=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getDescrição());
            stmt.setDouble(2, obj.getPreco());
            stmt.setInt(3, obj.getQtd_estoque());

            stmt.setInt(4, obj.getFornecedor().getId());//tranforma o objeto em um numeto no caso do id;

            stmt.setInt(5, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto Alterado com Sucesso!");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    //Metodo Excluir Produtos
    public void excluir(Produtos obj) {
        try {

            // 1 passo Comando SQL
            String sql = "delete from tb_produtos where id=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, obj.getId());

            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Produto Excluido com Sucesso!");

        } catch (Exception erro) {

            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    //Metodo que atualiza e dá as devidas baixas no estoque conforme as vendas
    public void baixaEstoque(int id, int qtd_nova) {
        try {

            //1 passo criar comando sql para atualizar a quantidade de produtos no estoque
            String sql = "update tb_produtos set qtd_estoque = ? where id = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setInt(1, qtd_nova);
            stmt.setInt(2, id);
            stmt.execute();
            stmt.close();


        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);

        }
    }

    //Metodo retorna estoque atual de um produto
    public int retornaEstoqueAtual(int id) {
        try {
            int qtd_estoque = 0;

            String sql = "Select qtd_estoque from tb_produtos where id = ? ";

            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1,id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){

                qtd_estoque = (rs.getInt("qtd_estoque"));
            }
            return qtd_estoque;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }

    }
}
