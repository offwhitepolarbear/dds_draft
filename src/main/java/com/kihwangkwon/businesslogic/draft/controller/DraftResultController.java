package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.service.DraftResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DraftResultController {
    private final DraftResultService draftResultService;

    @GetMapping("/draft/palyer/result/{season}")
    public List findAllDraftResult(@PathVariable String season){
        return draftResultService.findAllDraftResult(season);
    }
}
