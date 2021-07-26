/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import java.util.ArrayList;
import java.util.Iterator;
import re.dao.DAOManager;
import re.dao.bd.OracleDaoManager;
import re.modelo.Datos;

/**
 *
 * @author kriz_
 */
public class Main {

    public static void main(String[] args) throws Exception {
        int i = 0;
        DAOManager manager = new OracleDaoManager("jdbc:oracle:thin:@localhost:1521:XE", "Grupo1", "12345");
        ArrayList<Datos> data = new ArrayList();
        Publicador pub = new Publicador();
        Suscriptor csm = new Suscriptor();
        while(i<100){
            pub.publicar();
            csm.consumidor();
            System.out.println("Van "+ i+" iteracciones");
            i++;
        }
        csm.obtDatos(null);
        data=csm.getDat();
        Iterator <Datos> it= data.iterator();
        while(it.hasNext()){
            Datos da=it.next();
            System.out.println(da.getCod_Datos()+" "+da.getDias()+" "+da.getDispositivo()+" "+da.getEmergencia()+" "+da.getHora()
                    +" "+da.getLugar()+" "+da.getSituacion());
            manager.getDatosDao().insertar(da);                                                  
        }
    }

}
