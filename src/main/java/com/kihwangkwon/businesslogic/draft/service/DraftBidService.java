package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.domain.DraftInfo;
import com.kihwangkwon.businesslogic.draft.domain.DraftNominate;
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

    private final DraftNominateService draftNomianteService;

    private final DraftInfoService draftInfoService;

    public boolean checkBidapproval(DraftBid draftBid){
        boolean result = false;
        boolean checkNominated = false;
        boolean checkPlayerSlot = false;
        boolean checkPositivePrice = false;
        boolean highestBid = false;

        // 선수가 현재 비딩 대상인지 확인 playerId, season, bid상태로 검사함
        DraftNominate draftNominate = draftNomianteService.findNominateByBid(draftBid);
        if (draftNominate != null){
            // 비딩 대상이고 비드와 동일할 때
                checkNominated = true;
        }

        // 팀 잔여 자리 체크
        int season = draftBid.getSeason();
        String team = draftBid.getBidTeam();
        DraftInfo draftInfo = draftInfoService.findDraftInfo(season);
        List<DraftResult> draftResultList = draftResultService.findDraftResultBySeasonAndTeam(season, team);

        checkPlayerSlot = isPlayerSlotLeft(draftInfo, draftResultList);

        // 비딩된 금액 체크
        int bidPrice = draftBid.getBidPrice();
        checkPositivePrice = bidPrice > 0;

        // 사용 금액 체크
        int useBudget = 0;
        for (DraftResult draftResult : draftResultList){
            useBudget += draftResult.getBidPrice();
        }

        int playerLimit = draftInfo.getPlayerPerTeam();
        int drafteeCount = draftResultList.size();
        boolean payablePrice = isPayablePrice(draftInfo, playerLimit, drafteeCount, bidPrice, useBudget);

        highestBid = isHighestBid(draftBid, bidPrice);

        if(checkNominated && checkPlayerSlot && checkPositivePrice && payablePrice && highestBid){
            result = true;
        }

        return result;
    }

    private boolean isPlayerSlotLeft(DraftInfo draftInfo, List<DraftResult> draftResultList){
        boolean checkPlayerSlot = false;

        int playerLimit = draftInfo.getPlayerPerTeam();
        int drafteeCount = 0;

        try {
            drafteeCount = draftResultList.size();
        }catch (Exception e){

        }

        if(playerLimit>drafteeCount){
            checkPlayerSlot = true;
        }
        return checkPlayerSlot;
    }

    private boolean isHighestBid(DraftBid draftBid, int bidPrice) {
        DraftBid oldHighestBid = findHighestBidPrice(draftBid);
        return bidPrice > oldHighestBid.getBidPrice();
    }

    private boolean isPayablePrice(DraftInfo draftInfo, int playerLimit, int drafteeCount, int bidPrice, int useBudget) {
        int startBudget = draftInfo.getBudget();

        // 남은 잔액
        int budgetNow = startBudget - useBudget;

        int howManyPlayerNeed = playerLimit - drafteeCount;

        // 지불 가능한 금액인지 확인
        boolean payablePrice = budgetNow >= bidPrice + howManyPlayerNeed - 1 ;

        return payablePrice;
    }

    private DraftBid findHighestBidPrice(DraftBid draftBid){
        int season = draftBid.getSeason();
        String playerId = draftBid.getPlayerId();
        return draftBidRepository.findFirstBySeasonAndPlayerIdOrderByBidPriceDesc(season, playerId);   
    }

    public DraftBid placeBid(DraftBid draftBid){
        DraftBid result = null;
        if(checkBidapproval(draftBid)){
            draftBid = draftBidRepository.save(draftBid);
            result = draftBid;
        }
        return result;
    }

    public boolean checkAbleBidSuccess(DraftBid draftBid){
        boolean result = false;

        return result;
    }

    public DraftBid successBid(DraftBid draftBid){
        draftBid.setApproval(true);
        draftBid = draftBidRepository.save(draftBid);
        draftNomianteService.updateNominateStatus(draftBid);
        return draftBid;
    }

    public DraftBid findLatestBid(String season){
        int seasonInteger = Integer.parseInt(season);
        return draftBidRepository.findFirstBySeasonOrderByCreatedDateDesc(seasonInteger);
    }

}
