/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package re.modelo;

/**
 *
 * @author kriz_
 */
public class Datos {
    private int cod_Datos;//Variable entera para el codigo
    private String dispositivo;//Variable String para el ingreso de los dispositivos(Varchar2)
    private String dias;//Variable String para el ingreso de los dias(Varchar2)
    private String hora;//Variable String para el ingreso de la hora(Varchar2)
    private String lugar;//Variable String para el ingreso del lugar(Varchar2)
    private String situacion;//Variable String para el ingreso de la  situacion ocurrida(Varchar2)
    private double tiempo;//Variable double del tiempo transcurrido(Varchar2)
    private String emergencia;//Variable String para el ingreso de la emergencia(Varchar2)

    public Datos() {    }

    public Datos(int cod_Datos, String dispositivo, String dias, String hora, String lugar, String situacion, double tiempo, String emergencia) {
        this.cod_Datos = cod_Datos;
        this.dispositivo = dispositivo;
        this.dias = dias;
        this.hora = hora;
        this.lugar = lugar;
        this.situacion = situacion;
        this.tiempo = tiempo;
        this.emergencia = emergencia;
    }
    
    //Incorporacion de los metodos setter and getter

    public int getCod_Datos() {
        return cod_Datos;
    }

    public void setCod_Datos(int cod_Datos) {
        this.cod_Datos = cod_Datos;
    }

    public String getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(String dispositivo) {
        this.dispositivo = dispositivo;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = situacion;
    }

    public double getTiempo() {
        return tiempo;
    }

    public void setTiempo(double tiempo) {
        this.tiempo = tiempo;
    }

    public String getEmergencia() {
        return emergencia;
    }

    public void setEmergencia(String emergencia) {
        this.emergencia = emergencia;
    }
    
    @Override
    public String toString() {
        return String.valueOf(this.cod_Datos)+", dispositivo=" + getDispositivo() + ", Dias=" +", Cargo="+getDias()+
                ", hora=" +getHora() + ", lugar=" + getLugar() + ", situacion=" + getSituacion() + ", Tiempo=" + 
                String.valueOf(this.tiempo)+ ", emergencia=" + getEmergencia() + '}';}    
    
}
