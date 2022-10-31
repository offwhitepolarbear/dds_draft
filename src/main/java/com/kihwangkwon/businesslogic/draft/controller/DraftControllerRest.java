package com.kihwangkwon.businesslogic.draft.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.domain.DraftTeam;
import com.kihwangkwon.businesslogic.draft.service.DraftService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/draft")
public class DraftControllerRest {

	private final DraftService draftService;

	@RequestMapping("/login")
	public boolean draftLogin(@RequestBody DraftTeam draftTeam) {
		return draftService.login(draftTeam);
	}

	@RequestMapping("/start/{stringSeason}")
	public void draftStarter(@PathVariable("stringSeason") String stringSeason) {
		int season = Integer.parseInt(stringSeason);
		// draftService.draftStart(season);
	}

	@RequestMapping("/stop/{stringSeason}")
	public void draftStopper(@PathVariable("stringSeason") String stringSeason) {
		int season = Integer.parseInt(stringSeason);
		// draftService.draftFinish(season);
	}


	
}
