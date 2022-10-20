package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.domain.DraftResult;
import com.kihwangkwon.businesslogic.draft.repository.DraftBidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DraftBidService {

    private final DraftBidRepository draftBidRepository;

    private final DraftResultService draftResultService;

    private final DraftNomianteService draftNomianteService;

    public DraftBid placeBid(DraftBid draftBid){
        draftBid = draftBidRepository.save(draftBid);
        return draftBid;
    }

    public DraftBid successBid(DraftBid draftBid){
        draftBid.setApproval(true);
        draftBid = draftBidRepository.save(draftBid);
        draftNomianteService.updateNominateStatus(draftBid);
        return draftBid;
    }

    public boolean checkBidapproval(DraftBid draftBid){
        boolean result = false;
        // 선수가 현재 비딩 대상인지 확인

        // 팀 잔여 자리 체크
        int season = draftBid.getSeason();
        String team = draftBid.getBidTeam();
        List<DraftResult> resultList= draftResultService.findDraftResultBySeasonAndTeam(season,team);
        draftBid.getBidTeam();

        // 금액 체크
        return result;
    }
    public DraftBid getLastBid(int Season){
        DraftBid draftBid = null;
//        draftBid = draftBidRepository.findBySeason(season, Sort.sort());
        return draftBid;
    }


}
