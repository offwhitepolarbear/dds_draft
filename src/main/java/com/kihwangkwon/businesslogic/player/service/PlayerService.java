package com.kihwangkwon.businesslogic.player.service;

import java.util.List;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.player.domain.OfficialPlayerRating;

public interface PlayerService {
	public List<OfficialPlayerRating> getAllPlayer(String season);
	public List<OfficialPlayerRating> getUndraftPlayers(String season);
	public DraftBid getPlayerOnBid(String season);
	
}
