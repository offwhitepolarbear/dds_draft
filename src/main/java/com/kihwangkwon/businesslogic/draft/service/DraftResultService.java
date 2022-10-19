package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftResult;
import com.kihwangkwon.businesslogic.draft.repository.DraftResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DraftResultService {
    DraftResultRepository draftResultRepository;

    List<DraftResult> findDraftResultBySeasonAndTeam(int season, String team){
        return draftResultRepository.findBySeasonAndDraftTeam(season,team);
    }
}
