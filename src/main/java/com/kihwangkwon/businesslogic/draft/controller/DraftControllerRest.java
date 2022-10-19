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

	private boolean drafteeSelect;
	private boolean duringAuction;

	private String playerName;

	private int timeRest;

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

	@RequestMapping("/drafting")
	public void draft() {
		// Timer draftTimer = new Timer("Timer");
		while (drafteeSelect) {

			/*
			 * Timer timer = new Timer();
			 */
//			timer.start();

			System.out.println("셀렉트중");
		}
		while (duringAuction) {
			System.out.println("옥션중");
		}
		if (!drafteeSelect) {
			System.out.println("꺼짐1");
		}
	}

	@RequestMapping("/draft/bid")
	public void boolTest(@RequestBody DraftBid draftBid) {
		draftService.bid(draftBid);
	}

	@RequestMapping("/drafting3")
	public void boolTest3() {
		draftService.bidTimer();
	}

	@RequestMapping("/getRemainTime")
	public int getRemainTime(){
		return draftService.getBidTimeLeft();
	}
	
	@RequestMapping("/getDraftTeams/{stringSeason}")
	public List<DraftTeam> getDraftTeams(@PathVariable("stringSeason") String stringSeason){
		return draftService.getDraftTeams(stringSeason);
	}
	
}
