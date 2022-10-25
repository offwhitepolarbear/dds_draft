package com.kihwangkwon.businesslogic.draft.domain;

import com.kihwangkwon.businesslogic.draft.domain.enumerate.DraftType;
import com.kihwangkwon.jpaaudit.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class DraftResult extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int season;
    private int pick;
    private String playerId;
    private String draftTeam;
    private int bidPrice;
    private DraftType draftType;

}
