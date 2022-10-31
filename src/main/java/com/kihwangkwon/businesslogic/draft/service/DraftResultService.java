package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftInfo;
import com.kihwangkwon.businesslogic.draft.domain.DraftResult;
import com.kihwangkwon.businesslogic.draft.repository.DraftResultRepository;
import com.kihwangkwon.businesslogic.team.domain.TeamTag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DraftResultService {
    private final DraftResultRepository draftResultRepository;

    public List<DraftResult> findAllDraftResult(String season){
        int seasonInteger = Integer.parseInt(season);
        return draftResultRepository.findBySeason(seasonInteger);
    }
    public List<DraftResult> findDraftResultBySeasonAndTeam(int season, String team){
        return draftResultRepository.findBySeasonAndDraftTeam(season,team);
    }

    boolean bidderLeft(DraftInfo draftInfo, TeamTag teamName){
        // 검사중에 하나라도 걸리면 false 처리
        boolean result = false;

        for (TeamTag teamTag : TeamTag.values()){
            // 해당팀 아닌경우 전부 검사
            if(!teamTag.equals(teamName)){
                int resultSize = 0;
                List resultList = draftResultRepository.findBySeasonAndDraftTeam(draftInfo.getSeason(), teamTag.toString());
                if(resultList != null){
                    resultSize = resultList.size();
                }

                if(resultSize==draftInfo.getPlayerPerTeam()){

                }else{
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

}
