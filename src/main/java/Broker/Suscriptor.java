/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import re.dao.DAOException;
import re.dao.DAOManager;
import re.dao.bd.OracleDaoManager;
import re.modelo.Datos;

/**
 *
 * @author kriz_
 */
public class Suscriptor {

    ArrayList<Datos> dat = new ArrayList();
    Datos da = new Datos();
    int id = 1;

    public void consumidor() throws Exception {

        String uri = System.getenv("CLOUDAMQP_URL");
        if (uri == null) {
            uri = "amqps://edocvcey:pbGCxKNVwcziQMRVSjsWhwdiXkQH_N_X@gull.rmq.cloudamqp.com/edocvcey";
        }
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(uri);
        factory.setConnectionTimeout(30000);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        String queue = " ";
        String exchangeName = "";
        String routingKey = "";

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), "UTF-8");
            System.out.println(" [x] Received '" + message + "'");
            try {
                obtDatos(message);
            } catch (DAOException ex) {
                Logger.getLogger(Suscriptor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Suscriptor.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Suscriptor.class.getName()).log(Level.SEVERE, null, ex);
            }
        };
        channel.basicConsume(queue = "Dispositivos", true, deliverCallback, consumerTag -> {
        });
        channel.basicConsume(queue = "Dia", true, deliverCallback, consumerTag -> {
        });
        channel.basicConsume(queue = "Hora", true, deliverCallback, consumerTag -> {
        });
        channel.basicConsume(queue = "Lugar", true, deliverCallback, consumerTag -> {
        });
        channel.basicConsume(queue = "Situacion", true, deliverCallback, consumerTag -> {
        });
        channel.basicConsume(queue = "Tiempo", true, deliverCallback, consumerTag -> {
        });
        channel.basicConsume(queue = "Emergencia", true, deliverCallback, consumerTag -> {
        });

    }

    public ArrayList<Datos> getDat() {

        return dat;
    }

    public void obtDatos(String message) throws DAOException, ClassNotFoundException, SQLException {
        if (da.getDispositivo() == null) {
            da.setDispositivo(message);
        } else if (da.getDias() == null) {
            da.setDias(message);
        } else if (da.getHora() == null) {
            da.setHora(message);
        } else if (da.getLugar() == null) {
            da.setLugar(message);
        } else if (da.getSituacion() == null) {
            da.setSituacion(message);
        } else if (da.getTiempo() == 0.0) {
            da.setTiempo(Double.valueOf(message));
        } else if (da.getEmergencia() == null) {
            da.setEmergencia(message);
        } else {
            DAOManager manager = new OracleDaoManager("jdbc:oracle:thin:@localhost:1521:XE", "Grupo1", "12345");

            if (manager.getDatosDao().obtener(id) == null) {
                da.setCod_Datos(id);
                id++;
            }
            
            dat.add(da);
            da = new Datos();
            da.setDispositivo(message);
        }
    }
}
