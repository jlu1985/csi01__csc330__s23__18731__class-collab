package edu.cuny.csi.s23.csc330.food;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class Stores extends AbstractWebSocketHandler {

    private final ConcurrentHashMap<String, String> menus;
    private final ConcurrentHashMap<String, WebSocketSession> sessions;

    public Stores() {
        this.sessions = new ConcurrentHashMap<>();
        this.menus = new ConcurrentHashMap<>();
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.put(session.getId(), session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status)
            throws Exception {
        String id = session.getId();
        sessions.remove(id);
        menus.remove(id);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        String msg = message.getPayload();
        menus.put(session.getId(), msg);
        System.out.printf("message from:%s, msg: %s", session.getId(), msg);
        session.sendMessage(new TextMessage(session.getId()));
    }

    public Map<String, String> getMenus() {
        return new HashMap<>(this.menus);
    }

    public boolean notifyOrder(String storeId, String orderId) {
        if (!sessions.containsKey(storeId)) {
            return false;
        }

        try {
            sessions.get(storeId).sendMessage(new TextMessage(orderId));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
