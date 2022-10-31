package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.service.DraftBidService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/draft/bid")
public class DraftBidController {
    private final DraftBidService draftBidService;
    @PostMapping("/doBid")
    public DraftBid bid(@RequestBody DraftBid draftBid){
        return draftBidService.placeBid(draftBid);
    }

    @GetMapping("/last/{season}")
    public DraftBid getLastBid(@PathVariable String season){
        return draftBidService.findLatestBid(season);
    }

}
