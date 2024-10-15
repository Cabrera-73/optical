
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
    model.addColumn("ID");
    model.addColumn("User Name");
    model.addColumn("Nombre");
    model.addColumn("Password");
    model.addColumn("Nivel");
    
    // Configurar el modelo en la tabla
    paramTablaTotalUsuarios.setModel(model);
    try {
        String sql = "SELECT * FROM usuarios";
        Statement st = cx.conectar().createStatement();
        ResultSet rs = st.executeQuery(sql);
        
        String[] datos = new String[5];  

        while (rs.next()) {
            datos[0] = rs.getString("id");  
            datos[1] = rs.getString("username");
            datos[2] = rs.getString("name");
            datos[3] = rs.getString("password");
            datos[4] = rs.getString("nivel");
            model.addRow(datos);
        }
        //ayuda a ocultar la tabla id
        paramTablaTotalUsuarios.getColumnModel().getColumn(0).setMinWidth(0);
        paramTablaTotalUsuarios.getColumnModel().getColumn(0).setMaxWidth(0);
        paramTablaTotalUsuarios.getColumnModel().getColumn(0).setWidth(0);  
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al mostrar los Usuarios: " + e.toString());
        e.printStackTrace();
    }
}

    public void EditarUsuario(int id, JTextField paramName, JTextField paramUsername, JTextField paramPassword , JTextField paramTipoUser) {
    BaseDatos cn = new BaseDatos();  
    
        String name = paramName.getText();
        String username = paramUsername.getText();
        String password = paramPassword.getText();
        String tipoUser = paramTipoUser.getText();

    String consulta = "UPDATE usuarios SET username = ?, name = ?, password = ?, nivel = ? WHERE id = ?";

    try {
        CallableStatement cs = cn.conectar().prepareCall(consulta);
        //Se mandan los datos 
        cs.setString(1, username);
        cs.setString(2, name);
        cs.setString(3, password);
        cs.setString(4, tipoUser);
        cs.setInt(5, id);

        int resultado = cs.executeUpdate();

        if (resultado > 0) {
            JOptionPane.showMessageDialog(null, "Usuario actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario con el código especificado.");
        }

    } catch (Exception e) {
        // Mostrar mensaje de error
        JOptionPane.showMessageDialog(null, "Error al actualizar el usuario: " + e.toString());
        e.printStackTrace();
    }  
}

    public void EliminarUsuario(int id){
    
    setId(id);
    
    BaseDatos cn = new BaseDatos();
    
    String sql = "delete from usuarios where usuarios.id = ?;";
    try {
        CallableStatement cs = cn.conectar().prepareCall(sql);
        
        cs.setInt(1, id);
        
          int respuesta = JOptionPane.showConfirmDialog(null,"¿Estás seguro de que deseas eliminar este Usuario?", "Confirmación de Eliminación",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
         if (respuesta == JOptionPane.YES_OPTION) {
                cs.execute();
                JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Operación cancelada.");
            }
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en la selección" + e.toString());
            e.printStackTrace();
        }    
    }

}
