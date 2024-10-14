/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; //librerias que no estoy seguro si se usaran
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author luism
 */
public class CVentas {
    
    private final BaseDatos conexion;

    // Constructor que inicializa la conexión a la BD
    public CVentas() {
        conexion = new BaseDatos();
    }
    
    public ResultSet buscarProductoPorCodigo(String codigo) {
    String sql = "SELECT nombre, precio, existencia FROM productos WHERE codigo = ?";
    try {
        PreparedStatement ps = conexion.conectar().prepareStatement(sql);  // Preparar la consulta
        ps.setString(1, codigo);  // Pasar el código como parámetro
        return ps.executeQuery();  // Ejecutar y devolver el resultado
    } catch (SQLException e) {
        e.printStackTrace();  // Mostrar el error en la consola
        return null;
    }
}

 public void confirmarVenta(String nombreCliente, JTable carrito, float total, String nitCliente) {
    String sql = "UPDATE productos SET existencia = existencia - ? WHERE codigo = ?";
     String sql2 = "INSERT INTO facturas (nombre, fecha, total, ruta, nit) VALUES (?, ?, ?, ?, ?)";
     
      String fecha = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")); 
      String rutaPDF = "facturas/" + nombreCliente + "_" + fecha + ".pdf";  // Ruta del PDF para agregar a BD

     
    try {
        BaseDatos objetoConexion = new BaseDatos();
        PreparedStatement ps = objetoConexion.conectar().prepareStatement(sql);
        
       
        for (int i = 0; i < carrito.getRowCount(); i++) { //Recorre la tabla para buscar las existencias a restar de cada producto 
            String codigo = carrito.getValueAt(i, 0).toString();
            int cantidad = Integer.parseInt(carrito.getValueAt(i, 3).toString());

            ps.setInt(1, cantidad);
            ps.setString(2, codigo);
            ps.executeUpdate();
        }

        JOptionPane.showMessageDialog(null, "Venta confirmada y existencias actualizadas.");
    } 
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al confirmar venta: " + e.getMessage());
    }
    
    BaseDatos objetoConexion = new BaseDatos(); //manda los datos a la BD
    try (Connection con = objetoConexion.conectar(); PreparedStatement ps = con.prepareStatement(sql2)) {
        ps.setString(1, nombreCliente);
        ps.setString(2, fecha);
        ps.setFloat(3, total);
        ps.setString(4, rutaPDF);
        ps.setString(5, nitCliente);
        ps.executeUpdate();
    }
    
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al confirmar venta: " + e.getMessage());
    }
}
 
 
 public float actualizarTotal(JTable carrito) {
     float totalGeneral = 0;
     totalGeneral = Math.round(totalGeneral * 100) / 100.0f; //Permite redondear a dos digitos

    for (int i = 0; i < carrito.getRowCount(); i++) {
        totalGeneral += Float.parseFloat(carrito.getValueAt(i, 4).toString()); // Suponiendo que la columna 4 es el total
    }
    
    return totalGeneral; // Llama a este método para actualizar tabla
}
 
 
   public boolean validarDatosCliente(String nombre, JTextField nit, String direccion) {
        // Verificar que los campos no estén vacíos
        if (nombre.isEmpty() || nit.getText().isEmpty() || direccion.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor, completa todos los campos de Cliente", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        // Verificar que el NIT tenga exactamente 9 caracteres (Pendiente pues esta la opcion de poner C/F)
       /* if (nit.getText().length() != 9) {
           
            JOptionPane.showMessageDialog(null, "El NIT debe contener exactamente 9 Caracteres.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        } */ 
       

        return true; // Todos los datos son válidos
    }


    // Método reutilizable para mostrar una confirmación personalizada
    public boolean Confirmacion(String mensaje, String titulo) {
        String[] opciones = {"Sí", "No"};
        
        int confirmacion = JOptionPane.showOptionDialog(
                null, 
                mensaje, 
                titulo, 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, 
                null, 
                opciones, 
                opciones[1]  
        );

        return confirmacion == JOptionPane.YES_OPTION;
    }

    public void mostrarHistorialVentas(JTable tabla) {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("Nombre Cliente");
    model.addColumn("Fecha de Venta");
    model.addColumn("Pago");
    model.addColumn("ruta");
    model.addColumn("NIT");

    String sql = "SELECT nombre, fecha, total, ruta, nit FROM Facturas";
    BaseDatos objetoConexion = new BaseDatos();
    
    try (Connection con = objetoConexion.conectar();
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql)) {

        while (rs.next()) {
            String nombreCliente = rs.getString("nombre");
            String fecha = rs.getString("fecha");
            String pago = String.format("Q%.2f", rs.getDouble("total"));
            String ruta = rs.getString("ruta");
            String NIT = rs.getString("nit");

            model.addRow(new Object[]{nombreCliente, fecha, pago, ruta, NIT});
        }

        tabla.setModel(model);
        //Oculta la fila de ruta, pues solo esta para funcionalidad y no vista (poner en 0 todo)
        TableColumn rutaColumn = tabla.getColumnModel().getColumn(3); 
        rutaColumn.setMinWidth(0);
        rutaColumn.setMaxWidth(0);
        rutaColumn.setWidth(0);
        rutaColumn.setPreferredWidth(0);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    
}
