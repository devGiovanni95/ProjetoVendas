/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.model;

import java.awt.Component;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author geu_p
 */
public class Utilitarios {
    public void LimpaTela(JPanel container){
        Component components[] = container.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                ((JTextField)component).setText(null);
                
            }
            
        }
    }

//    public Clientes buscarCep2(String cep) {
//
//        String json;
//
//        String logradouro;
//
//        String bairro;
//
//        String cidade;
//
//        String uf;
//
//        try {
//
//            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
//
//            URLConnection urlConnection = url.openConnection();
//
//            BufferedReader br;
//            try (InputStream is = urlConnection.getInputStream()) {
//
//                br = new BufferedReader(new InputStreamReader(is));
//            }
//
//
//            StringBuilder jsonSb = new StringBuilder();
//
//
//
//            br.lines().forEach(l -> jsonSb.append(l.trim()));
//
//            json = jsonSb.toString();
//
//
//
//             JOptionPane.showMessageDialog(null, json);/**/
//
//            json = json.replaceAll("[{},:]", "");
//
//            json = json.replaceAll("\"", "\n");
//
//            String array[] = new String[30];
//
//            array = json.split("\n");
//
//
//
//            /**/ JOptionPane.showMessageDialog(null, array);
//
//            logradouro = array[7];
//
//            bairro = array[15];
//
//            cidade = array[19];
//
//            uf = array[23];
//
//
//
//            Clientes obj = new Clientes();
//
//
//
//            obj.setEndereco(logradouro);
//
//            obj.setCidade(cidade);
//
//            obj.setBairro(bairro);
//
//            obj.setUf(uf);
//
//
//
//            /**/JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
//
//
//
//            return obj;
//
//
//
//        } catch (Exception erro) {
//
//            throw new RuntimeException(erro);
//
//        }
//
//    }
}
