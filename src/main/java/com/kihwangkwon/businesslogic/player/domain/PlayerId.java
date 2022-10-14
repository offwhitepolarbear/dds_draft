package com.kihwangkwon.businesslogic.player.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@ToString
@Entity
@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
public class PlayerId {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int version;
	
	private String playerId;
	private String playerName;
	private String playerNameKorean;

	public PlayerId() {

	}
}
