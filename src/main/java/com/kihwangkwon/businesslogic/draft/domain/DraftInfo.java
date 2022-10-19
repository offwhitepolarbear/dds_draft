package com.kihwangkwon.businesslogic.draft.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class DraftInfo {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	private int season;

	// 팀당 시작 금액
	private int budget;
	// 팀당 드래프트 인원
	private int playerPerTeam;
	// 경매 드래프트로 지명할 인원
	private int auctionBidRound;
	// 경매 드래프트 입찰 마감 시간
	private int bidTime;
	// 경매 드래프트 경매대상 등록 마감 시간
	private int nominateTime;
}
