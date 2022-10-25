package com.kihwangkwon.businesslogic.draft.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DraftTeamInfo {
    private int season;
    private int pick;
    private String teamName;
    private String gmName;
    private boolean gm;
    private boolean biddable;
}