/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import code.BaseDatos;
import gui.EditarProductos;
import java.sql.Statement;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;


/**
 *
 * @author luism
 */
//Solo dios sabe que paso aqui, aun me faltan unos try para saber si los campos que ingresa son validos
//pero de momento el CRUD funciona
public class CProductos {
    
    String codigo;
    String nombre;
    double precio;
    int existencia;
    String categoria;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
    public void IngresarProducto(JTextField paramCodigo, JTextField paramNombre, JTextField paramPrecio , JTextField paramExistencia, JTextField paramCategoria  ){
        setCodigo(paramCodigo.getText());
        setNombre(paramNombre.getText());
        setPrecio(Double.parseDouble(paramPrecio.getText()));
        setExistencia(Integer.parseInt(paramExistencia.getText()));   
        setCategoria(paramCategoria.getText()); 
        
        BaseDatos objetoConexion = new BaseDatos();
       
        String Consulta = "insert into productos (codigo, nombre, precio, existencia, categoria) values (?,?,?,?,?)";
        
         try {
            CallableStatement cs = objetoConexion.conectar().prepareCall(Consulta);
            
            cs.setString(1, getCodigo());
            cs.setString(2, getNombre() );
            cs.setDouble(3, getPrecio());
            cs.setInt(4, getExistencia());
            cs.setString(5, getCategoria());
            
            cs.execute();
             
            JOptionPane.showMessageDialog(null, "Poducto Agregado Correctamente ");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valio Verga" + e.toString());
            e.printStackTrace();  // Captura errores
        }
    }
    
    
    
    
    public void MostrarProductos(JTable paramTablaTotalProductos) {
    BaseDatos objetoConexion = new BaseDatos();
    
    // Crear un modelo de tabla
    DefaultTableModel model = new DefaultTableModel();
    
    
    model.addColumn("ID");// Esta no se vera, es solo para el registro
    model.addColumn("Codigo");
    model.addColumn("Nombre");
    model.addColumn("Precio");
    model.addColumn("Existencia");
    model.addColumn("Categoria");

    // Configurar el modelo en la tabla
    paramTablaTotalProductos.setModel(model);
    
    // Consulta para obtener los datos, incluyendo el ID
        String sql = "SELECT * FROM productos";
    
    try {
        // Ejecutar la consulta
        Statement st = objetoConexion.conectar().createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        // Crear un array para los datos, incluyendo el ID
        String[] datos = new String[6];  

        // Iterar sobre los resultados
        while (rs.next()) {
            // Obtener los datos del ResultSet y asignarlos a las posiciones correctas del array
            datos[0] = rs.getString("id");  
            datos[1] = rs.getString("codigo");
            datos[2] = rs.getString("nombre");
            datos[3] = rs.getString("precio");
            datos[4] = rs.getString("existencia");
            datos[5] = rs.getString("categoria");

            // Añadir la fila al modelo de la tabla
            model.addRow(datos);
        }
        // Ocultar la primera columna (ID)
        paramTablaTotalProductos.getColumnModel().getColumn(0).setMinWidth(0);
        paramTablaTotalProductos.getColumnModel().getColumn(0).setMaxWidth(0);
        paramTablaTotalProductos.getColumnModel().getColumn(0).setWidth(0);
        
    } catch (Exception e) {
        // Mostrar mensaje de error
        JOptionPane.showMessageDialog(null, "Error al mostrar los productos: " + e.toString());
        e.printStackTrace();  // Imprimir la traza del error
    }
}

   

    public void EditarProducto(int id, JTextField paramCodigo, JTextField paramNombre, JTextField paramPrecio, JTextField paramExistencia, JTextField paramCategoria) {
    // Conectar a la base de datos
    BaseDatos objetoConexion = new BaseDatos();  
    
    // Obtener los valores de los campos de texto
    String codigo = paramCodigo.getText();
    String nombre = paramNombre.getText();
    double precio = Double.parseDouble(paramPrecio.getText());
    int existencia = Integer.parseInt(paramExistencia.getText());
    String categoria = paramCategoria.getText();

    // Sentencia SQL para actualizar el registro
    String consulta = "UPDATE productos SET codigo = ?, nombre = ?, precio = ?, existencia = ?, categoria = ? WHERE ID = ?";

    try {
        // Preparar la sentencia
        CallableStatement cs = objetoConexion.conectar().prepareCall(consulta);

        // Asignar los valores a la consulta
        cs.setString(1, codigo);
        cs.setString(2, nombre);
        cs.setDouble(3, precio);
        cs.setInt(4, existencia);
        cs.setString(5, categoria);
        cs.setInt(6, id);  // El código es la clave para identificar el producto

        // Ejecutar la consulta
        int resultado = cs.executeUpdate();  // Devuelve el número de filas afectadas

        // Verificar si la actualización fue exitosa
        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Producto actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el producto con el código especificado.");
        }

    } catch (Exception e) {
        // Mostrar mensaje de error
        JOptionPane.showMessageDialog(null, "Error al actualizar el producto: " + e.toString());
        e.printStackTrace();  // Mostrar la traza del error
    }  
}

    public void EliminarProducto(int id){
    
    setId(id);
    
    BaseDatos objetoConexion = new BaseDatos();
    
    String sql = "delete from productos where productos.id = ?;";
    try {
           // Preparar la sentencia
        CallableStatement cs = objetoConexion.conectar().prepareCall(sql);
        
        cs.setInt(1, id);
        
          int respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de que deseas eliminar este registro?", "Confirmación de Eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
         if (respuesta == JOptionPane.YES_OPTION) {
                // Lógica para eliminar el registro
                cs.execute();
                JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Valio Verga" + e.toString());
            e.printStackTrace();  // Captura errores
        }
    
    
    
    }
    
    
   }
   
