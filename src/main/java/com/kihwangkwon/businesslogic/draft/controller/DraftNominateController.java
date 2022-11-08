package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.domain.DraftNominate;
import com.kihwangkwon.businesslogic.draft.service.DraftBidService;
import com.kihwangkwon.businesslogic.draft.service.DraftNominateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DraftNominateController {

//    private final DraftNominateService draftNominateService;

    private final DraftBidService draftBidService;

    @PostMapping("/rest/nominate")
    public DraftNominate placeNominate(@RequestBody DraftBid draftBid){
        return draftBidService.placeNominate(draftBid);
    }


}
