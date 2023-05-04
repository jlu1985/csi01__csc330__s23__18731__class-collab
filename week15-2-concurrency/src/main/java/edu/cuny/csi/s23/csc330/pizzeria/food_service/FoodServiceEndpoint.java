package edu.cuny.csi.s23.csc330.pizzeria.food_service;

import edu.cuny.csi.s23.csc330.pizzeria.Menu;
import edu.cuny.csi.s23.csc330.pizzeria.price.PriceCalculator;
import jakarta.websocket.CloseReason;
import jakarta.websocket.Endpoint;
import jakarta.websocket.EndpointConfig;
import jakarta.websocket.MessageHandler;
import jakarta.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;

import java.net.URI;
import java.util.function.Supplier;

public class FoodServiceEndpoint extends Endpoint implements MessageHandler.Whole<String> {


    private final Supplier<String> menuSupplier;

    public FoodServiceEndpoint(Supplier<String> menuSupplier) {
      this.menuSupplier = menuSupplier;

    }

    @Override
    public void onOpen(Session session, EndpointConfig config) {
        session.addMessageHandler(this);
        System.out.println("Successfully connected to food service");
        try {

            session.getBasicRemote().sendText(menuSupplier.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(String message) {
        System.out.printf(
                """
                        Order from food service: orderId: %s
                        %n""",
                message);
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
