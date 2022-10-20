package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.service.DraftSequenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/draft/process")
public class DraftSequenceControllerRest {
    private final DraftSequenceService draftSequenceService;

    @PostMapping("/break")
    private void changeDraftProcessStatus(){

    }

    @RequestMapping("/timeLeft/{}")
    private void setDraftTimeManually(){
        draftSequenceService.setTimeLeft(2);
    }
}
