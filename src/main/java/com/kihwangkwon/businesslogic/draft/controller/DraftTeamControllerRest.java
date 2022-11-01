package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.domain.response.DraftTeamInfo;
import com.kihwangkwon.businesslogic.draft.service.DraftTeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/draft/team")
public class DraftTeamControllerRest {

    private final DraftTeamService draftTeamService;

    @GetMapping("/getDraftTeams/{season}")
    public List<DraftTeamInfo> getTeamList(@PathVariable String season){
        return draftTeamService.findDraftTeamInfoList(season);
    }
}
