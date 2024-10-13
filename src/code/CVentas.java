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

 public void confirmarVenta(JTable carrito) {
    String sql = "UPDATE productos SET existencia = existencia - ? WHERE codigo = ?";

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
    } catch (Exception e) {
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

        // Verificar que el NIT tenga exactamente 9 caracteres 
        if (nit.getText().length() != 9) {
            JOptionPane.showMessageDialog(null, "El NIT debe contener exactamente 9 Caracteres.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }

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

    
    
    
}
