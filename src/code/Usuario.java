
package code;
public class Usuario {
    private int id;
    private String username;
    private String name;
    private String password;
    private boolean tipoUser;
    
    //Cnstruct
    public Usuario(int id, String username, String name, String password, boolean tipoUser) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.tipoUser = tipoUser;
    }
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

    public boolean isTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(boolean tipoUser) {
        this.tipoUser = tipoUser;
    }
}
