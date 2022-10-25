package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.domain.DraftInfo;
import com.kihwangkwon.businesslogic.draft.service.DraftInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DraftInfoController {
    private final DraftInfoService draftInfoService;

    @GetMapping("/draft/info/{season}")
    public DraftInfo getDraftInfo(@PathVariable String season){
        int seasonInt = Integer.parseInt(season);
        return draftInfoService.findDraftInfo(seasonInt);
    }
}
