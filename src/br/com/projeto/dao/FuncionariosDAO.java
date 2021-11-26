/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto.dao;

import br.com.projeto.jdbc.ConnectionFactory;
import br.com.projeto.model.Funcionarios;
import br.com.projeto.model.WebServiceCep;
import br.com.projeto.view.FrmLogin;
import br.com.projeto.view.FrmMenu;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author geu_p
 */
public class FuncionariosDAO {
    
    //Conexao 
    private Connection con;
    
    public FuncionariosDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    //Metodo cadastrar Funcionario
        public void cadastrarFuncionarios(Funcionarios obj) {

        try {
            // 1 passo - criar o comando sql
            String sql = "insert into tb_funcionarios(nome, rg, cpf, email, senha, cargo, nivel_acesso, telefone, celular, "
                    + "cep, endereco, numero, complemento, bairro, cidade, estado) "
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());

            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());

            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            // 3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }

    //Metodo listar todos od funcionarios
    public List<Funcionarios> listarFuncionarios() {

        try {

            //1 passo criar a lista
            List<Funcionarios> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));

                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));

                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }
    }


    //Metodo alterarFuncionarios
    public void alterarFuncionarios(Funcionarios obj) {
        try {
            // 1 passo - criar o comando sql
            String sql = "update tb_funcionarios set nome=?, rg=?, cpf=?, email=?, senha=?, cargo=?, nivel_acesso=?, telefone=?, celular=?, "
                    + "cep=?, endereco=?, numero=?, complemento=?, bairro=?, cidade=?, estado=? where id=?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getRg());
            stmt.setString(3, obj.getCpf());
            stmt.setString(4, obj.getEmail());

            stmt.setString(5, obj.getSenha());
            stmt.setString(6, obj.getCargo());
            stmt.setString(7, obj.getNivel_acesso());

            stmt.setString(8, obj.getTelefone());
            stmt.setString(9, obj.getCelular());
            stmt.setString(10, obj.getCep());
            stmt.setString(11, obj.getEndereco());
            stmt.setInt(12, obj.getNumero());
            stmt.setString(13, obj.getComplemento());
            stmt.setString(14, obj.getBairro());
            stmt.setString(15, obj.getCidade());
            stmt.setString(16, obj.getUf());

            stmt.setInt(17, obj.getId());

            // 3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Alterado com sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    //Metodo excluir cliente
    public void excluirFuncionario(Funcionarios obj) {
        try {
            // 1 passo - criar o comando sql
            String sql = "delete from tb_funcionarios where id = ?";

            //2 passo - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getId());

            // 3 passo - executar o comando sql
            stmt.execute();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!!!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }

    }



    //metodo consulta cliente por nome
    public Funcionarios consultaPorNome(String nome) {

        try {
            //1 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios where nome = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();
            Funcionarios obj = new Funcionarios();

            if (rs.next()) {

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));

                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));

                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));
            }
            return obj;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado!!");
            return null;
        }
    }

    //metodo buscar Funcionario por nome
    public List<Funcionarios> buscaFuncionarioPorNome(String nome) {

        try {

            //1 passo criar a lista
            List<Funcionarios> lista = new ArrayList<>();

            //2 passo - criar o sql , organizar e executar.
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Funcionarios obj = new Funcionarios();

                obj.setId(rs.getInt("id"));
                obj.setNome(rs.getString("nome"));
                obj.setRg(rs.getString("rg"));
                obj.setCpf(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));

                obj.setSenha(rs.getString("senha"));
                obj.setCargo(rs.getString("cargo"));
                obj.setNivel_acesso(rs.getString("nivel_acesso"));

                obj.setTelefone(rs.getString("telefone"));
                obj.setCelular(rs.getString("celular"));
                obj.setCep(rs.getString("cep"));
                obj.setEndereco(rs.getString("endereco"));
                obj.setNumero(rs.getInt("numero"));
                obj.setComplemento(rs.getString("complemento"));
                obj.setBairro(rs.getString("bairro"));
                obj.setCidade(rs.getString("cidade"));
                obj.setUf(rs.getString("estado"));

                lista.add(obj);
            }

            return lista;

        } catch (SQLException erro) {

            JOptionPane.showMessageDialog(null, "Erro :" + erro);
            return null;
        }

    }
    
    //Busca por  cep


    public Funcionarios buscaCep(String cep) {

        WebServiceCep webServiceCep = WebServiceCep.searchCep(cep);


        Funcionarios obj = new Funcionarios();

        if (webServiceCep.wasSuccessful()) {
            obj.setEndereco(webServiceCep.getLogradouroFull());
            obj.setCidade(webServiceCep.getCidade());
            obj.setBairro(webServiceCep.getBairro());
            obj.setUf(webServiceCep.getUf());
            return obj;
        } else {
            JOptionPane.showMessageDialog(null, "Erro numero: " + webServiceCep.getResulCode());
            JOptionPane.showMessageDialog(null, "Descrição do erro: " + webServiceCep.getResultText());
            return null;
        }

    }
    
   // criando metodo de login na classe de funcionario pois quem ira fazer login é apenas o funcionario
    
    //Metodo efetuarLogin
    public void efetuarLogin(String email, String senha){
        try {
            //1 passo - SQL
            String sql = "select * from tb_funcionarios where email = ? and senha = ? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,email);
            stmt.setString(2,senha);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                //Usuario logou


                //Caso o usuario seja do tipo admin
                if (rs.getString("nivel_acesso").equals("Admin")){

                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema ");
                    //Se efetuar o login mudar para a tela de menu
                    FrmMenu tela = new FrmMenu();
                    //pegar no banco de dados o campo com o nome do usuario que fez o login
                    tela.usuarioLogado = rs.getString("nome");
                    tela.setVisible(true);

                }
                //Caso o usuario seja do tipo limitado
                else  if (rs.getString("nivel_acesso").equals("Usuário")){

                    JOptionPane.showMessageDialog(null, "Seja bem vindo ao Sistema ");
                    FrmMenu tela = new FrmMenu();
                    tela.usuarioLogado = rs.getString("nome");

                    //Desabilitar os menus
                    tela.menu_posicao.setEnabled(false);
                    tela.menu_controlevendas.setVisible(false);

                    tela.setVisible(true);
                }


            }else {
                //Dados incorretos
                JOptionPane.showMessageDialog(null, "Dados incorretos, Favor verificar dados informados!");
                new FrmLogin().setVisible(true);
            }

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);

        }
    }

    
}
