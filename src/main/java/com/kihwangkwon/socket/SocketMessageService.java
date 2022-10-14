package com.kihwangkwon.socket;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.annotations.JsonAdapter;
import com.kihwangkwon.socket.domain.SocketMessageType;
import com.kihwangkwon.socket.domain.SocketResponseDomain;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class SocketMessageService {
 	SocketEndPoint socketEndPoint;

	 public void tt(SocketMessageType socketMessageType, Object message){
		 String jsonString = null;

		 SocketResponseDomain socketResponseDomain = new SocketResponseDomain();
		 socketResponseDomain.setSocketMessageType(socketMessageType);
		 socketResponseDomain.setObject(message);

		 ObjectMapper objectMapper = new ObjectMapper();
		 try {
			 jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(socketResponseDomain);
//			 jsonString = objectMapper.writeValueAsString(message);
		 } catch (JsonProcessingException e) {
			 throw new RuntimeException(e);
		 }
//		 System.out.println(jsonString);
		 socketEndPoint.broadcast(jsonString);
	 }

	private Map loginIdMap;
	public Map getloginIdList() {
		return loginIdMap;
	}
	
	public void removeLoginIdList(String id) {
		loginIdMap.put(id, true);
	}
	
	public void addLoginIdList(String id) {
		loginIdMap.remove(id);
	}
}