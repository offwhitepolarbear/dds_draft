package com.kihwangkwon.socket;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class SocketHandler implements WebSocketHandler{
	
	private static List<WebSocketSession> socketList = new ArrayList<>();
	private static Map<String,String> loginSessionIds;
	private static Map loginIdMap;
	private final SocketService socketService;
	
	public static List getSocketList() {
		return socketList;
	}
	
	public static Map getSessionIdTeamMap() {
		return loginSessionIds;
	}
	
	public static Map getLoginIdMap() {
		return loginIdMap;
	}
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		socketList.add(session);
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		socketList.remove(session);
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
	}

	
	//메시지 올경우 세션과 메시지를 전부 드래프트 서비스로 이전
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	// 전체 소켓에 메시지 전송하기 기능
	public void propagationMessage(WebSocketMessage<?> message) throws IOException {
		for(WebSocketSession session : socketList) {
			session.sendMessage(message);
		}
	}
	
	
	private void removeLoginIdList(String id) {
		loginIdMap.put(id, true);
	}
	
	private void addLoginIdList(String id) {
		loginIdMap.remove(id);
	}
	
}
