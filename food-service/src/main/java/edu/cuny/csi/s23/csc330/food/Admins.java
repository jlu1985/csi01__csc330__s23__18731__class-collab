package edu.cuny.csi.s23.csc330.food;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.concurrent.ConcurrentHashMap;

@Component
public class Admins extends AbstractWebSocketHandler {

    private final ConcurrentHashMap<String, String> toggles;

    public Admins(@Qualifier("toggles") ConcurrentHashMap<String, String> toggles) {
        this.toggles = toggles;
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message)
            throws Exception {
        String payload = message.getPayload().toLowerCase();
        if (payload.equalsIgnoreCase("get")) {
            session.sendMessage(new TextMessage(toggles.toString()));
            return;
        }

        String[] split = payload.split(":");
        if (split.length < 2) {
            return;
        }
        toggles.put(split[0], split[1]);
        session.sendMessage(new TextMessage(toggles.toString()));
    }
}
