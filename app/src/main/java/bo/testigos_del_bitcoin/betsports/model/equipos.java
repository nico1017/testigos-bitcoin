package bo.testigos_del_bitcoin.betsports.model;

import com.google.gson.annotations.Expose;

public class equipos {
    @Expose
    private int id;

    @Expose
    private String equipo;

    @Expose
    private int logo;

    public equipos(int id, String equipo, int logo){
        this.id = id;
        this.equipo = equipo;
        this.logo = logo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

}
