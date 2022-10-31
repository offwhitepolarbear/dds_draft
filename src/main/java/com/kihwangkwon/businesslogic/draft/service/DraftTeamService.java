package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftTeam;
import com.kihwangkwon.businesslogic.draft.repository.DraftTeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DraftTeamService {
    private final DraftTeamRepository draftTeamRepository;

    public List<DraftTeam> findDraftTeam(String season){
        int seasonInt = Integer.parseInt(season);
        return draftTeamRepository.findBySeason(seasonInt);
    }
}
