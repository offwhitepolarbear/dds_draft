package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.service.DraftBidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/draft/bid")
public class DraftBidController {
    private final DraftBidService draftBidService;
    @PostMapping
    public DraftBid bid(@RequestBody DraftBid draftBid){
        return draftBidService.placeBid(draftBid);
    }

}
