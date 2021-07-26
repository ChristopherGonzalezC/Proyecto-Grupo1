/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 *
 * @author kriz_
 */
public class Publicador {

    Random random = new Random();

    void publicar() throws Exception {

        Suscriptor csm = new Suscriptor();
        int i = 0;
        String uri = System.getenv("CLOUDAMQP_URL");
        if (uri == null) {
            uri = "amqps://edocvcey:pbGCxKNVwcziQMRVSjsWhwdiXkQH_N_X@gull.rmq.cloudamqp.com/edocvcey";
        }
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri(uri);
        factory.setConnectionTimeout(30000000);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String queue = " ";
        String exchangeName = "";
        String routingKey = "";
        queue = "Dispositivos";
        routingKey = queue;
        channel.queueDeclare(queue, false, false, false, null);
        String message = random.dispositivos();
        channel.basicPublish(exchangeName = "", routingKey, null, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");

        queue = "Dia";
        routingKey = queue;
        channel.queueDeclare(queue, false, false, false, null);
        String message0 = random.dias();
        channel.basicPublish(exchangeName = "", routingKey, null, message0.getBytes());
        System.out.println("[x] Sent '" + message0 + "'");

        queue = "Hora";
        routingKey = queue;
        channel.queueDeclare(queue, false, false, false, null);
        String message1 = random.horas();
        channel.basicPublish(exchangeName = "", routingKey, null, message1.getBytes());
        System.out.println("[x] Sent '" + message1 + "'");

        queue = "Lugar";
        routingKey = queue;
        channel.queueDeclare(queue, false, false, false, null);
        String message2 = random.lugar();
        channel.basicPublish(exchangeName = "", routingKey, null, message2.getBytes());
        System.out.println("[x] Sent '" + message2 + "'");

        queue = "Situacion";
        routingKey = queue;
        channel.queueDeclare(queue, false, false, false, null);
        String message3 = random.situacion();
        channel.basicPublish(exchangeName = "", routingKey, null, message3.getBytes());
        System.out.println("[x] Sent '" + message3 + "'");

        queue = "Tiempo";
        routingKey = queue;
        channel.queueDeclare(queue, false, false, false, null);
        String message4 = random.tiempo();
        channel.basicPublish(exchangeName = "", routingKey, null, message4.getBytes());
        System.out.println("[x] Sent '" + message4 + "'");

        queue = "Emergencia";
        routingKey = queue;
        channel.queueDeclare(queue, false, false, false, null);
        String message5 = random.emergencia();
        channel.basicPublish(exchangeName = "", routingKey, null, message5.getBytes());
        System.out.println("[x] Sent '" + message5 + "'");
        i++;
        connection.close();
    }
}
