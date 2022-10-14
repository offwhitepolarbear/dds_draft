package com.kihwangkwon.businesslogic.draft.domain;

import com.kihwangkwon.businesslogic.draft.domain.enumerate.DraftType;
import com.kihwangkwon.jpaaudit.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class DraftResult  extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int season;
    private int pick;
    private DraftType draftType;
    private String playerId;
    private String draftTeam;
    private int bidPrice;
}
