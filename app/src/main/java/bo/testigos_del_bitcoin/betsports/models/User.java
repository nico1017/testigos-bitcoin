package bo.testigos_del_bitcoin.betsports.models;

import com.google.gson.annotations.Expose;

public class User {
    @Expose
    private String nombreUsuario;

    @Expose
    private String password;

    @Expose
    private int edad;

    @Expose
    private String email;

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
