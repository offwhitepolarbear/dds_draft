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
        try{
            draftSequenceService.draftProcessor();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/break")
    public void draftProcessBreaker(){
        draftSequenceService.setOnDraft(false);
    }


    @PostMapping("/")

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
