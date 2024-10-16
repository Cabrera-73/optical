/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import code.CProductos;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author luism
 */
public class Productos extends javax.swing.JPanel {

    //Instanciamos fondo de pantalla
    Background fondo = new Background();
    public Productos() {
        initComponents();
       
      
       CProductos objetoProductos = new CProductos();
       objetoProductos.MostrarProductos(tbProductos);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new Background();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductos = new javax.swing.JTable();
        btnBorrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(860, 525));
        setRequestFocusEnabled(false);

        bg.setPreferredSize(new java.awt.Dimension(860, 525));

        tbProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tbProductos);

        btnBorrar.setBackground(new java.awt.Color(234, 67, 53));
        btnBorrar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/deleteIcon.png"))); // NOI18N
        btnBorrar.setText("Borrar");
        btnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(52, 168, 83));
        btnEditar.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editPackage.png"))); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnNuevo.setBackground(new java.awt.Color(89, 131, 252));
        btnNuevo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/addPackage.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Lista de Productos");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/listIcon.png"))); // NOI18N

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 347, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
       CProductos objetoProducto = new CProductos();
       int filaSeleccionada = tbProductos.getSelectedRow(); 
      if (filaSeleccionada >= 0) { 
       int idProducto = Integer.parseInt(tbProductos.getModel().getValueAt(filaSeleccionada, 0).toString());
       objetoProducto.EliminarProducto(idProducto);
       objetoProducto.MostrarProductos(tbProductos);
      }
      JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para borrar.");
       
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // Crear una instancia del JDialog AgregarProducto
    AgregarProducto dialogo = new AgregarProducto(null, true);  
    
    // Mostrar el JDialog
    dialogo.setVisible(true);
    CProductos objetoProductos = new CProductos();
    objetoProductos.MostrarProductos(tbProductos);
    }//GEN-LAST:event_btnNuevoActionPerformed
    
    private int idProductoSeleccionado;
      
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
                                                 
    int filaSeleccionada = tbProductos.getSelectedRow();  // Obtener la fila seleccionada
    
    if (filaSeleccionada >= 0) {
             // Almacenar el ID del producto de la fila seleccionada
         idProductoSeleccionado = Integer.parseInt(tbProductos.getModel().getValueAt(filaSeleccionada, 0).toString());
        // Obtener los valores de las columnas de la fila seleccionada
        String codigo = tbProductos.getValueAt(filaSeleccionada, 1).toString();
        String nombre = tbProductos.getValueAt(filaSeleccionada, 2).toString();
        String precio = tbProductos.getValueAt(filaSeleccionada, 3).toString();
        String existencia = tbProductos.getValueAt(filaSeleccionada, 4).toString();
        String categoria = tbProductos.getValueAt(filaSeleccionada, 5).toString();
        
        // Abrir el JDialog y pasarle los datos
        EditarProductos editarDialog = new EditarProductos(null, true, tbProductos);
        
        // Asignar los valores a los campos del JDialog
        editarDialog.setCodigo(codigo);
        editarDialog.setNombre(nombre);
        editarDialog.setPrecio(precio);
        editarDialog.setExistencia(existencia);
        editarDialog.setCategoria(categoria);
        // Asignar el ID del producto
        editarDialog.setIdProductoSeleccionado(idProductoSeleccionado);
        
        // Mostrar el diálogo
        editarDialog.setVisible(true);
    } else {
        JOptionPane.showMessageDialog(null, "Por favor, selecciona una fila para editar.");
    }
    
    }//GEN-LAST:event_btnEditarActionPerformed
    
    class Background extends JPanel{
        private Image imagen;
        
        public void paint (Graphics g){
            imagen = new ImageIcon(getClass().getResource("/img/bgContent.png")).getImage();
            g.drawImage(imagen, 0, 0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProductos;
    // End of variables declaration//GEN-END:variables
}
