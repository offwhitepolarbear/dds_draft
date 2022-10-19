package com.kihwangkwon.businesslogic.draft.domain;

import com.kihwangkwon.businesslogic.draft.domain.enumerate.DraftNominateStatus;
import com.kihwangkwon.jpaaudit.BaseTimeEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
public class DraftNominate extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int season;
    private String playerId;
    private int pick;
    private DraftNominateStatus draftNominateStatus;

}
