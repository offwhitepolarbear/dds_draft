package com.kihwangkwon.businesslogic.player.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.repository.DraftBidRepository;
import com.kihwangkwon.businesslogic.player.domain.OfficialPlayerRating;
import com.kihwangkwon.businesslogic.player.repository.OfficialPlayerRatingRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

	private final OfficialPlayerRatingRepository officialPlayerRatingRepository;
	private final DraftBidRepository draftBidRepository;
	
	@Override
	public List<OfficialPlayerRating> getAllPlayer(String season) {
		int intSeason = Integer.parseInt(season);
		return officialPlayerRatingRepository.findBySeason(intSeason, null);
	}

	@Override
	public List<OfficialPlayerRating> getUndraftPlayers(String season) {
		
		int intSeason = Integer.parseInt(season);
		
		List<OfficialPlayerRating> allPlayer = officialPlayerRatingRepository.findBySeason(intSeason, null);
		for(OfficialPlayerRating officialPlayerRating:allPlayer){
			officialPlayerRating.setId(Long.parseLong("0"));
		}

		List<DraftBid> draftees = draftBidRepository.findBySeasonAndApproval(intSeason, true, null);
		

		
		//드래프트 진행중인 애는 못가져오니까 따로 검색해서 추가
		DraftBid lastBidPlayer = draftBidRepository.findFirstBySeasonOrderByIdDesc(intSeason,null);
		draftees.add(lastBidPlayer);
		
		return removeDuplicatePlayers(allPlayer, draftees);
	}
	
	private List<OfficialPlayerRating> removeDuplicatePlayers(List<OfficialPlayerRating> allPlayers, List<DraftBid> draftees) {
		
		Map<String, OfficialPlayerRating> playersMap = getPlayerMapByList(allPlayers);
		
		for(DraftBid draftee : draftees) {
			String playerId = draftee.getPlayerId();
			playersMap.remove(playerId);
		}
		
		List resultPlayers = getPlayerListByMap(playersMap);
		return resultPlayers;
	}
	
	private Map<String, OfficialPlayerRating> getPlayerMapByList(List<OfficialPlayerRating> allPlayers){
		
		Map<String, OfficialPlayerRating> playersMap = new HashMap<>();
		
		for (OfficialPlayerRating player: allPlayers) {
			String key = player.getPlayerId();
			playersMap.put(key, player);
		}
		
		return playersMap;
	}
	
	private List<OfficialPlayerRating> getPlayerListByMap(Map<String, OfficialPlayerRating> playersMap){
		List playerList = new ArrayList<>();
		for(String key : playersMap.keySet()) {
			OfficialPlayerRating player = playersMap.get(key);
			playerList.add(player);
		}
		return playerList;
	}
	
	@Override
	public DraftBid getPlayerOnBid(String season) {
		int intSeason = Integer.parseInt(season);
		DraftBid lastBidPlayer = draftBidRepository.findFirstBySeasonOrderByIdDesc(intSeason,null);
		return lastBidPlayer;
	}

}
