
package code;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Usuario {
    private int id;
    private String username;
    private String name;
    private String password;
    private String tipoUser;
    
    /*Construct
    public Usuario(String username, String name, String password, String tipoUser) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.tipoUser = tipoUser;
    }*/
    //Getter and Setter

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getTipoUser() {
        return tipoUser;
    }
    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }
    //Metodos
    public void IngresarUsuario(JTextField paramName, JTextField paramUsername, JTextField paramPassword , JTextField paramTipoUser){
        
        setName(paramName.getText());
        setUsername(paramUsername.getText());
        setPassword(paramPassword.getText());
        setTipoUser(paramTipoUser.getText());   
        
      
        if(!name.equals("") && !username.equals("") && !password.equals("") && !tipoUser.equals("")){
            try {
                BaseDatos cn = new BaseDatos();
                String sql = "insert into usuarios (username, name, password, nivel) values (?,?,?,?)";
                CallableStatement cs = cn.conectar().prepareCall(sql);
                cs.setString(1, getUsername());
                cs.setString(2, getName() );
                cs.setString(3, getPassword());
                cs.setString(4, getTipoUser());
                cs.execute();          
                JOptionPane.showMessageDialog(null, "Usuario añadido");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la conexión" + e.toString());
                e.printStackTrace();
            }
        }else{
            JOptionPane.showMessageDialog(null, "No dejes ninguna casilla vacia");
        }
    }
    
    
    public void MostrarDatos(JTable paramTablaTotalUsuarios) {
    BaseDatos cx = new BaseDatos();
    
    // Crear un modelo de tabla
    DefaultTableModel model = new DefaultTableModel();
    
    
    model.addColumn("ID");// Esta no se vera, es solo para el registro
    model.addColumn("User Name");
    model.addColumn("Nombre");
    model.addColumn("Password");
    model.addColumn("Nivel");

    // Configurar el modelo en la tabla
    paramTablaTotalUsuarios.setModel(model);
    
    // Consulta para obtener los datos, incluyendo el ID
        String sql = "SELECT * FROM usuarios";
    
    try {
        // Ejecutar la consulta
        Statement st = cx.conectar().createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        // Crear un array para los datos, incluyendo el ID
        String[] datos = new String[5];  

        // Iterar sobre los resultados
        while (rs.next()) {
            // Obtener los datos del ResultSet y asignarlos a las posiciones correctas del array
            datos[0] = rs.getString("id");  
            datos[1] = rs.getString("username");
            datos[2] = rs.getString("name");
            datos[3] = rs.getString("password");
            datos[4] = rs.getString("nivel");

            // Añadir la fila al modelo de la tabla
            model.addRow(datos);
        }
        // Ocultar la primera columna (ID)
        paramTablaTotalUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        paramTablaTotalUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        paramTablaTotalUsuarios.getColumnModel().getColumn(0).setWidth(0);
        
        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(null, "Productos cargados correctamente.");
        
    } catch (Exception e) {
        // Mostrar mensaje de error
        JOptionPane.showMessageDialog(null, "Error al mostrar los productos: " + e.toString());
        e.printStackTrace();  // Imprimir la traza del error
    }
}

   
/*
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
*/
}
