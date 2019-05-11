package bo.testigos_del_bitcoin.betsports.models;

import android.view.ViewDebug;

import com.google.gson.annotations.Expose;

public class User {

    @Expose
    private int id;

    @Expose
    private String nombreUsuario;

    @Expose
    private String password;

    @Expose
    private int edad;

    @Expose
    private String email;

    @Expose
    private int monedas = 2000;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        this.monedas = monedas;
    }
}
