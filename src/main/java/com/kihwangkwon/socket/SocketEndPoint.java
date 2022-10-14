package com.kihwangkwon.socket;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Component
@ServerEndpoint(value = "/socket", configurator = ServerEndpointConfigurator.class)
public class SocketEndPoint {
    private static int onlineCount = 0;
    public static Set<Session> subscribers = new HashSet<>();

    @OnOpen
    public void onOpen(Session session) {
        onlineCount++;
        subscribers.add(session);
        System.out.println("OnOpen:" + onlineCount);
    }

    @OnClose
    public void OnClose(Session session) {
        onlineCount--;
        subscribers.remove(session);
        System.out.println("OnClose:" + onlineCount);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
//        System.out.println("OnMessage:" + message);
//        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("onError:" + throwable.getMessage());
        subscribers.remove(session);
        onlineCount--;
    }

    public static void broadcast(String message) {
        try {
            for (Session session : subscribers) {
                session.getBasicRemote().sendText(message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
