package com.kihwangkwon.socket;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class SocketService {
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