package edu.cuny.csi.s23.csc330.food;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Drivers extends AbstractWebSocketHandler {

    private final ConcurrentHashMap<String, WebSocketSession> sessions;

    public Drivers() {
        this.sessions = new ConcurrentHashMap<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        this.sessions.put(session.getId(), session);
        session.sendMessage(new TextMessage("id: " + session.getId()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
            throws Exception {
        this.sessions.remove(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        System.out.printf("id:%s, message:%s\n", session.getId(), message.getPayload());
    }

    public void notifyAll(String order) {
        List<WebSocketSession> webSocketSessions = new ArrayList<>(sessions.values());

        for (WebSocketSession session : webSocketSessions) {
            try {
                session.sendMessage(new TextMessage(order));
            } catch (IOException e) {

                e.printStackTrace();
                if (!session.isOpen()) {
                    sessions.remove(session.getId());
                }
            }
        }
    }
}
