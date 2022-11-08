package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.domain.DraftNominate;
import com.kihwangkwon.businesslogic.draft.domain.enumerate.DraftNominateStatus;
import com.kihwangkwon.businesslogic.draft.repository.DraftNominateRepository;
import com.kihwangkwon.businesslogic.team.domain.TeamTag;
import com.kihwangkwon.socket.SocketEndPoint;
import com.kihwangkwon.socket.SocketMessageService;
import com.kihwangkwon.socket.domain.SocketMessageType;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DraftNominateService {
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

    public TeamTag findNextNominator(int season){
        DraftNominate lastNominate = draftNominateRepository.findFirstBySeasonOrderByCreatedDateDesc(season);
        if (lastNominate == null){

        }
        return TeamTag.ATL;
    }

    public List getAllNominate(String season){
        int seasonInteger = Integer.parseInt(season);
        return draftNominateRepository.findBySeasonOrderByCreatedDateDesc(seasonInteger);
    }

    public TeamTag findNextNominator(String season){
        return null;
    }

    public DraftNominate saveNominate(DraftNominate draftNominate){
        return draftNominateRepository.save(draftNominate);
    }
}
