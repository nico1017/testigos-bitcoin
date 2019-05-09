package bo.testigos_del_bitcoin.betsports.model;

import com.google.gson.annotations.Expose;

public class Deportes {

    @Expose
    private int id;

    @Expose
    private String equipoUno;

    @Expose
    private String equipoDos;

    @Expose
    private int logo;

    @Expose
    private int anio;

    @Expose
    private int mes;

    @Expose
    private int dia;

    @Expose
    private String hora;

    @Expose
    private String minutos;

    public Deportes(int id, String equipoUno, String equipoDos, int logo, int anio, int mes, int dia, String hora, String minutos){
        this.id = id;
        this.equipoUno = equipoUno;
        this.equipoDos = equipoDos;
        this.logo = logo;
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
        this.hora= hora;
        this.minutos = minutos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEquipoUno() {
        return equipoUno;
    }

    public void setEquipoUno(String equipoUno) {
        this.equipoUno = equipoUno;
    }

    public String getEquipoDos() {
        return equipoDos;
    }

    public void setEquipoDos(String equipoDos) {
        this.equipoDos = equipoDos;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getMinutos() {
        return minutos;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }
}
