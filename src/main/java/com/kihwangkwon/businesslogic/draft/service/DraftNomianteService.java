package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.domain.DraftNominate;
import com.kihwangkwon.businesslogic.draft.domain.enumerate.DraftNominateStatus;
import com.kihwangkwon.businesslogic.draft.repository.DraftNominateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DraftNomianteService {
    private final DraftNominateRepository draftNominateRepository;

    public DraftNominate findNominateByBid(DraftBid draftBid){
        int season = draftBid.getSeason();
        String playerId = draftBid.getPlayerId();
        return draftNominateRepository.findBySeasonAndPlayerIdAndDraftNominateStatus(season, playerId, DraftNominateStatus.ON_BID.toString());
    }

    public DraftNominate updateNominateStatus(DraftBid draftBid){
        DraftNominate draftNominate = findNominateByBid(draftBid);
        draftNominate.setDraftNominateStatus(DraftNominateStatus.SUCCESSFUL_BID);
        draftNominate = draftNominateRepository.save(draftNominate);
        return draftNominate;
    }

}
