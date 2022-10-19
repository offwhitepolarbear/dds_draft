package com.kihwangkwon.businesslogic.player.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kihwangkwon.businesslogic.player.domain.OfficialPlayerRating;
import com.kihwangkwon.businesslogic.player.service.PlayerService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RequestMapping("/rest/player")
@RestController
public class PlayerControllerRest {

	private final PlayerService playerService;

	
	@RequestMapping("/getUndraftPlayer/{season}")
	public List<OfficialPlayerRating> getUndraftPlayer(@PathVariable String season) {
		return playerService.getUndraftPlayers(season);
	}

	public List getDraftedPlayer() {
		return null;
	}
}
