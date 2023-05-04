package edu.cuny.csi.s23.csc330.food;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;

@Component
public class Drivers extends AbstractWebSocketHandler {

    private final ConcurrentHashMap<String, WebSocketSession> sessions;
    private final ConcurrentHashMap<String, String> toggles;

    public Drivers(@Qualifier("toggles") ConcurrentHashMap<String, String> toggles) {
        this.sessions = new ConcurrentHashMap<>();
        this.toggles = toggles;
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

        boolean isParallel = Boolean.valueOf(toggles.getOrDefault("parallel", "false"));

        long sleepTime = Long.parseLong(toggles.getOrDefault("sleep", "3000"));

        Stream<WebSocketSession> webSocketSessionStream =
                isParallel ? webSocketSessions.stream().parallel() : webSocketSessions.stream();

        webSocketSessionStream.forEach(
                session -> {
                    try {
                        session.sendMessage(new TextMessage(order));
                        System.out.println(
                                Thread.currentThread().getName() + " went sleep" + sleepTime);
                        Thread.sleep(sleepTime);
                    } catch (Exception e) {

                        e.printStackTrace();
                        if (!session.isOpen()) {
                            sessions.remove(session.getId());
                        }
                    }
                });
    }
}
