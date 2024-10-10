/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import code.BaseDatos;
import java.sql.Connection;
import java.awt.Graphics;
import java.awt.Image;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Acer
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */    
    //Instanciamos fondo de pantalla
    Background fondo = new Background();
    //Instanciamos un objeto usuario para la base de datos a la vez que creamos una variable Connection
    //para poder instanciar el metodo conectar
    BaseDatos usuario = new BaseDatos();
    Connection cx = usuario.conectar();
    
    public Login() {
        this.setContentPane(fondo);
        setResizable(false);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        imgBg = new Background();
        containerLogin = new javax.swing.JPanel();
        login = new javax.swing.JLabel();
        signIn = new javax.swing.JLabel();
        userName = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        btnLogin = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        imgLogo = new javax.swing.JLabel();

        jScrollPane1.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        containerLogin.setBackground(new java.awt.Color(255, 255, 255));
        containerLogin.setToolTipText("");

        login.setFont(new java.awt.Font("Dialog", 1, 48)); // NOI18N
        login.setText("Login");

        signIn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signIn.setForeground(new java.awt.Color(143, 142, 142));
        signIn.setText("Sign in to continue");

        userName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userName.setForeground(new java.awt.Color(143, 142, 142));
        userName.setText("USER NAME");

        password.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        password.setForeground(new java.awt.Color(143, 142, 142));
        password.setText("PASSWORD");

        btnLogin.setBackground(new java.awt.Color(41, 53, 86));
        btnLogin.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(255, 255, 255));
        btnLogin.setText("Log in");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containerLoginLayout = new javax.swing.GroupLayout(containerLogin);
        containerLogin.setLayout(containerLoginLayout);
        containerLoginLayout.setHorizontalGroup(
            containerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLoginLayout.createSequentialGroup()
                .addGroup(containerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(containerLoginLayout.createSequentialGroup()
                        .addGap(184, 184, 184)
                        .addGroup(containerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(login)
                            .addGroup(containerLoginLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(signIn))))
                    .addGroup(containerLoginLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(containerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUserName)
                            .addComponent(btnLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(txtPassword)
                            .addGroup(containerLoginLayout.createSequentialGroup()
                                .addGroup(containerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(userName)
                                    .addComponent(password))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        containerLoginLayout.setVerticalGroup(
            containerLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerLoginLayout.createSequentialGroup()
                .addComponent(login)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(signIn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        imgLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N

        javax.swing.GroupLayout imgBgLayout = new javax.swing.GroupLayout(imgBg);
        imgBg.setLayout(imgBgLayout);
        imgBgLayout.setHorizontalGroup(
            imgBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgBgLayout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(imgBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgBgLayout.createSequentialGroup()
                        .addComponent(containerLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgBgLayout.createSequentialGroup()
                        .addComponent(imgLogo)
                        .addGap(210, 210, 210))))
        );
        imgBgLayout.setVerticalGroup(
            imgBgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgBgLayout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(imgLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(containerLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgBg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        
        String user = txtUserName.getText();
        String pass = new String (txtPassword.getPassword());
        
        if(!user.equals("") && !pass.equals("")){
            try{
                
                //String sql = "SELECT tipoUser from usuarios"
                //        + " WHERE username='"+user+"' AND password = '"+pass+"'";
                
                String sql = "SELECT tipoUser FROM usuarios WHERE username = ? AND password = ?";
                PreparedStatement ps = cx.prepareStatement(sql);
                ps.setString(1, user);
                ps.setString(2, pass);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                String tipoUser = rs.getString("tipoUser");
                System.out.println("Usuario encontrado: " + tipoUser);
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos.");
            }
                
            }catch(SQLException e){
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "Casillas vacias, reintentelo");
        }
        
    }//GEN-LAST:event_btnLoginActionPerformed

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

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
     class Background extends JPanel{
        private Image imagen;
        
        public void paint (Graphics g){
            imagen = new ImageIcon(getClass().getResource("/img/bg.png")).getImage();
            g.drawImage(imagen, 0, 0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JPanel containerLogin;
    private javax.swing.JPanel imgBg;
    private javax.swing.JLabel imgLogo;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel login;
    private javax.swing.JLabel password;
    private javax.swing.JLabel signIn;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
