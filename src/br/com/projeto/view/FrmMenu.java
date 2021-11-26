/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package br.com.projeto.view;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author geu_p
 */
public class FrmMenu extends javax.swing.JFrame {

    /**
     * Creates new form FrmMenu
     */
    public String usuarioLogado;

    public FrmMenu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings({"unchecked", "unchecked"})
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/imagens/fundo.jpg"));

        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }
        };
        jPanel2 = new javax.swing.JPanel();
        lblusuariologado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menu_controlecliente = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menu_controlefuncionario = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menu_controlefornecedor = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        menu_controleestoque = new javax.swing.JMenuItem();
        menu_consultaprodutos = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menu_abrirpdv = new javax.swing.JMenuItem();
        menu_posicao = new javax.swing.JMenuItem();
        menu_controlevendas = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menu_trocausuario = new javax.swing.JMenuItem();
        menu_sairdosistema = new javax.swing.JMenu();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Sistema de Controle de Vendas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        lblusuariologado.setForeground(new java.awt.Color(0, 51, 153));
        lblusuariologado.setText("Giovanni Almeida");

        jLabel2.setText("Usuário Logado:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(lblusuariologado)
                .addContainerGap(788, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2)
                    .addContainerGap(884, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblusuariologado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 477, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/clientes.png"))); // NOI18N
        jMenu1.setText("Clientes");

        menu_controlecliente.setText("Controle de Clientes");
        jMenu1.add(menu_controlecliente);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/funcionarios.png"))); // NOI18N
        jMenu2.setText("Funcionários");

        menu_controlefuncionario.setText("Controle de Funcionários");
        jMenu2.add(menu_controlefuncionario);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/fornecedores.png"))); // NOI18N
        jMenu3.setText("Fornecedores");

        menu_controlefornecedor.setText("Controle de Fornecedores");
        jMenu3.add(menu_controlefornecedor);

        jMenuBar1.add(jMenu3);

        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/produtos.png"))); // NOI18N
        jMenu7.setText("Produtos");

        menu_controleestoque.setText("Controle de  Estoque");
        jMenu7.add(menu_controleestoque);

        menu_consultaprodutos.setText("Consulta de Produtos");
        jMenu7.add(menu_consultaprodutos);

        jMenuBar1.add(jMenu7);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/vendas.png"))); // NOI18N
        jMenu4.setText("Vendas");

        menu_abrirpdv.setText("Abrir PDV");
        menu_abrirpdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_abrirpdvActionPerformed(evt);
            }
        });
        jMenu4.add(menu_abrirpdv);

        menu_posicao.setText("Posição do dia");
        jMenu4.add(menu_posicao);

        menu_controlevendas.setText("Histórico de Vendas");
        jMenu4.add(menu_controlevendas);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/configuracoes.png"))); // NOI18N
        jMenu5.setText("Configurações");

        menu_trocausuario.setText("Trocar de Usuário");
        menu_trocausuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu_trocausuarioActionPerformed(evt);
            }
        });
        jMenu5.add(menu_trocausuario);

        jMenuBar1.add(jMenu5);

        menu_sairdosistema.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/sair.png"))); // NOI18N
        menu_sairdosistema.setText("Sair");
        menu_sairdosistema.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_sairdosistemaMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_sairdosistema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 982, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jDesktopPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu_abrirpdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_abrirpdvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu_abrirpdvActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Deixar em tela cheia

        this.setExtendedState(this.MAXIMIZED_BOTH);

        //setar o nome do usuario logado no campo abaixo da tela do menu
        lblusuariologado.setText(usuarioLogado);

        this.setVisible(true);

    }//GEN-LAST:event_formWindowActivated

    private void menu_trocausuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu_trocausuarioActionPerformed
        // Trocar de usuario//Efetuar logout
        FrmLogin telalogin = new FrmLogin();

        this.dispose();
        telalogin.setVisible(true);

    }//GEN-LAST:event_menu_trocausuarioActionPerformed

    private void menu_sairdosistemaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_sairdosistemaMouseClicked
        // Botao sair do sistema
        
        int op;
        
        op = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja sair ?");
        
        if(op == 0){
            System.exit(0);
        }
    }//GEN-LAST:event_menu_sairdosistemaMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblusuariologado;
    private javax.swing.JMenuItem menu_abrirpdv;
    private javax.swing.JMenuItem menu_consultaprodutos;
    private javax.swing.JMenuItem menu_controlecliente;
    private javax.swing.JMenuItem menu_controleestoque;
    private javax.swing.JMenuItem menu_controlefornecedor;
    private javax.swing.JMenuItem menu_controlefuncionario;
    public javax.swing.JMenuItem menu_controlevendas;
    public javax.swing.JMenuItem menu_posicao;
    private javax.swing.JMenu menu_sairdosistema;
    private javax.swing.JMenuItem menu_trocausuario;
    // End of variables declaration//GEN-END:variables
}
