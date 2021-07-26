/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import java.util.ArrayList;
/**
 *
 * @author kriz_
 */
public class Random {
    public String dispositivos(){//Envio de datos de los dispotivos
        ArrayList<String> dispran = new ArrayList();
        dispran.add("Dron");dispran.add("Camara");dispran.add("Sensores");dispran.add("Actuadores");
        int a = (int)(Math.random()*4);
        String disp = dispran.get(a);
        return disp;
 
    }
    public String dias(){//Envio de datos de los dispotivos
        ArrayList<String> dias = new ArrayList();
        dias.add("Lunes");dias.add("Martes");dias.add("Miercoles");dias.add("Jueves");dias.add("Viernes");dias.add("Sabado");dias.add("Domingo");
        int a = (int)(Math.random()*7);
        String dia = dias.get(a);
        return dia;
    }
    public String horas(){//Envio de datos de los dispotivos
        ArrayList<String> horas = new ArrayList();
        horas.add("10:00");horas.add("10:30");horas.add("11:00");horas.add("13:00");horas.add("14:00");horas.add("18:00");horas.add("20:00");
        int a = (int)(Math.random()*7);
        String hor = horas.get(a);
        return hor;
    }
    public String lugar(){//Envio de datos de los dispotivos
        ArrayList<String> lugar = new ArrayList();
        lugar.add("Av. Francisco de Orellana");lugar.add("Av. Quito");lugar.add("Portete");lugar.add("Via Daule");lugar.add("Via perimetral");lugar.add("Autopista Narcisa de jesu");
        int a = (int)(Math.random()*6);
        String lug = lugar.get(a);
        return lug;
    }
    public String situacion(){//Envio de datos de los dispotivos
        ArrayList<String> situacion = new ArrayList();
        situacion.add("Accidente");situacion.add("Cuello de botella");situacion.add("Vehiculo detenido");situacion.add("Otro");situacion.add("Incidencias");
        int a = (int)(Math.random()*5);
        String sit = situacion.get(a);
        return sit;
    }

    public String tiempo(){//Envio de datos de los dispotivos
        ArrayList<String> tiempo = new ArrayList();
        tiempo.add("0.30");tiempo.add("1");tiempo.add("1.30");tiempo.add("2.00");tiempo.add("2.30");tiempo.add("3.00");tiempo.add("3.30");
        int a = (int)(Math.random()*7);
        String tp = tiempo.get(a);
        return tp;
    }

    public String emergencia(){//Envio de datos de los dispotivos
        ArrayList<String> emg = new ArrayList();
        emg.add("True");emg.add("False");
        int a = (int)(Math.random()*2);
        String emergencia = emg.get(a);
        return emergencia;
    }
}
