package com.kihwangkwon.businesslogic.draft.service;

import java.util.List;

import com.kihwangkwon.businesslogic.draft.domain.DraftResult;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.domain.DraftTeam;

public interface DraftService {
	boolean login(DraftTeam draftTeam);

	void setDraftProgress(boolean start);

	boolean logout(DraftTeam draftTeam);
	DraftResult placeBid(DraftBid draftBid);

	void setNominateTime(int second);
	void bid(DraftBid draftBid);
	void setbidTime(int second);
	void draftStart(int season);
	void whileBid(DraftBid playerBid);
	void whileNominate();
	void autoNominate();
	void bidApproval(DraftBid playerBid);
	void draftFinish(int season);
	int getBidTimeLeft();
	List<DraftTeam> getDraftTeams(String season);
	public void bidTimer();

}
