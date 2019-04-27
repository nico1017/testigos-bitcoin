package bo.testigos_del_bitcoin.betsports.model;

import com.google.gson.annotations.Expose;

public class Premios {

    @Expose
    private int id;

    @Expose
    private int imagen;

    @Expose
    private int precio;

    @Expose
    private String nombre;

    @Expose
    private String descripcion;

    public Premios(int id, int imagen, int precio, String nombre, String descripcion){
        this.id = id;
        this.imagen = imagen;
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
