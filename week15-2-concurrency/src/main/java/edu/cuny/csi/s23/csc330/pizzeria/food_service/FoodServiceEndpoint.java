package edu.cuny.csi.s23.csc330.pizzeria.food_service;

import edu.cuny.csi.s23.csc330.pizzeria.Menu;
import jakarta.websocket.CloseReason;
import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.MessageHandler;
import jakarta.websocket.Session;
import org.glassfish.tyrus.client.ClientManager;

import java.net.URI;

public class FoodServiceEndpoint extends Endpoint implements MessageHandler.Whole<String> {


    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler(this);
        try {
            session.getBasicRemote().sendText("some menu");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(String message) {
        System.out.printf("""
                Order from food service: orderId: %s
                %n""", message);

    }


    @Override
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("close " + closeReason);
    }

    @Override
    public void onError(Session session, Throwable thr) {
        thr.printStackTrace();
    }

    public void connect() {
        try {
            ClientManager.createClient()
                    .connectToServer(this, new URI("ws://localhost:8080/store"));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
