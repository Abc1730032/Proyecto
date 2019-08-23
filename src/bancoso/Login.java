/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bancoso;

import java.awt.Event;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Enrique
 */
public class Login extends javax.swing.JFrame {

    public static String Cuenta, Nombre, Tipo, NIP;
    Icon icon = new ImageIcon(getClass().getResource("IC2.png"));

    public Login() {
        initComponents();
        Image icon = new ImageIcon(getClass().getResource("IC.png")).getImage();
        setIconImage(icon);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        txtCuenta.requestFocus(true);
        this.setTitle("Banco - BBVA");
    }
    //Metodo de Acceso
    public void Acceder() {
        try {
            if (txtCuenta.getText().equals("") || txtNIP.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "<html><h2>Campos Incompletosssss</h2></html>",
                        "Banco - BBVA", JOptionPane.INFORMATION_MESSAGE, icon);
            } else {
                Statement stm = new Conexion().Conexion().createStatement();
                ResultSet rs = stm.executeQuery("select * from Usuarios where Cuenta=\'" + txtCuenta.getText() + "\' and NIP=\'" + txtNIP.getText()+"\'");
                System.out.println("a");
                if (rs == null) {
                    JOptionPane.showMessageDialog(null, "<html><h2>Usuario y/o Contraseña Incorrectos</h2></html>",
                            "Banco - BBVA", JOptionPane.INFORMATION_MESSAGE, icon);
                } else {
                    while (rs.next()) {
                        Cuenta = rs.getString("Cuenta");
                        Nombre = rs.getString("Nombre");
                        Tipo = rs.getString("Tipo");
                        NIP = rs.getString("NIP");
                        JOptionPane.showMessageDialog(null, "<html><h2>Bienvenido(a) " + Nombre + "</h2></html>",
                                "Banco - BBVA", JOptionPane.INFORMATION_MESSAGE, icon);
                        if(Tipo.equals("U")){
                            new Cliente().setVisible(true);
                            this.setVisible(false);
                        }else{
                            new Admin().setVisible(true);
                            this.setVisible(false);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new org.edisoncor.gui.panel.PanelImage();
        pnlNIP = new org.edisoncor.gui.panel.PanelImage();
        txtNIP = new jpass.JRPasswordField();
        pnlUS2 = new org.edisoncor.gui.panel.PanelImage();
        pnlUsuario = new org.edisoncor.gui.panel.PanelImage();
        txtCuenta = new app.bolivia.swing.JCTextField();
        pnlUS = new org.edisoncor.gui.panel.PanelImage();
        btnAcceder = new javax.swing.JButton();
        lblTitulo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnlPrincipal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancoso/BBVA1.png"))); // NOI18N

        pnlNIP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancoso/CP.png"))); // NOI18N

        txtNIP.setBorder(null);
        txtNIP.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNIP.setPlaceholder("NIP");
        txtNIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNIPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNIPKeyTyped(evt);
            }
        });

        pnlUS2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancoso/PW.png"))); // NOI18N

        javax.swing.GroupLayout pnlUS2Layout = new javax.swing.GroupLayout(pnlUS2);
        pnlUS2.setLayout(pnlUS2Layout);
        pnlUS2Layout.setHorizontalGroup(
            pnlUS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pnlUS2Layout.setVerticalGroup(
            pnlUS2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlNIPLayout = new javax.swing.GroupLayout(pnlNIP);
        pnlNIP.setLayout(pnlNIPLayout);
        pnlNIPLayout.setHorizontalGroup(
            pnlNIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlNIPLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(pnlUS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlNIPLayout.setVerticalGroup(
            pnlNIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNIPLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlNIPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlUS2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancoso/CP.png"))); // NOI18N

        txtCuenta.setBorder(null);
        txtCuenta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCuenta.setPlaceholder("Cuenta");
        txtCuenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCuentaKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCuentaKeyTyped(evt);
            }
        });

        pnlUS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/bancoso/US.png"))); // NOI18N

        javax.swing.GroupLayout pnlUSLayout = new javax.swing.GroupLayout(pnlUS);
        pnlUS.setLayout(pnlUSLayout);
        pnlUSLayout.setHorizontalGroup(
            pnlUSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        pnlUSLayout.setVerticalGroup(
            pnlUSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout pnlUsuarioLayout = new javax.swing.GroupLayout(pnlUsuario);
        pnlUsuario.setLayout(pnlUsuarioLayout);
        pnlUsuarioLayout.setHorizontalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap(69, Short.MAX_VALUE)
                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlUsuarioLayout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(pnlUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(308, Short.MAX_VALUE)))
        );
        pnlUsuarioLayout.setVerticalGroup(
            pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUsuarioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
            .addGroup(pnlUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlUsuarioLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(pnlUS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        btnAcceder.setBackground(new java.awt.Color(177, 213, 231));
        btnAcceder.setFont(new java.awt.Font("Calibri", 0, 25)); // NOI18N
        btnAcceder.setText("Acceder");
        btnAcceder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAcceder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccederActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Arial Black", 0, 40)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Inicio");

        javax.swing.GroupLayout pnlPrincipalLayout = new javax.swing.GroupLayout(pnlPrincipal);
        pnlPrincipal.setLayout(pnlPrincipalLayout);
        pnlPrincipalLayout.setHorizontalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(125, 125, 125))
            .addGroup(pnlPrincipalLayout.createSequentialGroup()
                .addGap(243, 243, 243)
                .addComponent(btnAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlPrincipalLayout.setVerticalGroup(
            pnlPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPrincipalLayout.createSequentialGroup()
                .addContainerGap(81, Short.MAX_VALUE)
                .addComponent(lblTitulo)
                .addGap(33, 33, 33)
                .addComponent(pnlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlNIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnAcceder, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNIPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIPKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtCuenta.requestFocus(true);
            Acceder();
        }
    }//GEN-LAST:event_txtNIPKeyPressed

    private void txtCuentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            txtNIP.requestFocus(true);
        }
    }//GEN-LAST:event_txtCuentaKeyPressed

    private void txtCuentaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCuentaKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtCuentaKeyTyped

    private void btnAccederActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccederActionPerformed
        txtCuenta.requestFocus(true);
        Acceder();
    }//GEN-LAST:event_btnAccederActionPerformed

    private void txtNIPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNIPKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNIPKeyTyped

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceder;
    private javax.swing.JLabel lblTitulo;
    private org.edisoncor.gui.panel.PanelImage pnlNIP;
    private org.edisoncor.gui.panel.PanelImage pnlPrincipal;
    private org.edisoncor.gui.panel.PanelImage pnlUS;
    private org.edisoncor.gui.panel.PanelImage pnlUS2;
    private org.edisoncor.gui.panel.PanelImage pnlUsuario;
    private app.bolivia.swing.JCTextField txtCuenta;
    private jpass.JRPasswordField txtNIP;
    // End of variables declaration//GEN-END:variables
}
