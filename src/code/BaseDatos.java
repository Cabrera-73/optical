package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDatos {
        
    String bd = "optical";
    String url ="jdbc:mysql://127.0.0.1:3306/";
    String usuario = "root";
    String password = "";
    String driver ="com.mysql.cj.jdbc.Driver";
    //Variable de conecction 
    Connection cx;
        
    public BaseDatos(){
    }

    public Connection conectar(){
        try{
            Class.forName(driver);
            cx = DriverManager.getConnection(url+bd,usuario,password);
            System.out.println("Conexion exitosa a mysql "+bd);
        }
        catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error de conexion");
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cx;
    }
    public void desconectar(){
        try {
            cx.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

    
