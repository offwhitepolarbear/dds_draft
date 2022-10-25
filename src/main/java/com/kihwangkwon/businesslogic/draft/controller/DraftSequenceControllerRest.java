package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.service.DraftSequenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/draft/process")
public class DraftSequenceControllerRest {

    private final DraftSequenceService draftSequenceService;


    @PostMapping("/draftInfo/{season}")
    private void changeDraftProcessStatus(@PathVariable String season){
        draftSequenceService.setDraftInfoBySeason(Integer.parseInt(season));
    }

    @PostMapping("/starter")
    public void draftProcessStarter(){
        draftSequenceService.setOnDraft(true);
    }

    @PostMapping("/break")
    public void draftProcessBreaker(){
        draftSequenceService.setOnDraft(false);
    }


    @GetMapping("/timeLeft")
    public int getLeftTime(){
        return draftSequenceService.getTimeLeft();
    }

    @RequestMapping("/timeLeft/{time}")
    public void setDraftTimeManually(@PathVariable String time) {
        int timeLeft = Integer.parseInt(time);
        draftSequenceService.setTimeLeft(timeLeft);
    }
}
