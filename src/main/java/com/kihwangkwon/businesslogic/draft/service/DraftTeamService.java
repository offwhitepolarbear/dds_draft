package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftTeam;
import com.kihwangkwon.businesslogic.draft.domain.response.DraftTeamInfo;
import com.kihwangkwon.businesslogic.draft.repository.DraftTeamRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DraftTeamService {
    private final DraftTeamRepository draftTeamRepository;

    public List<DraftTeam> findDraftTeamList(String season){
        int seasonInt = Integer.parseInt(season);
        return draftTeamRepository.findBySeason(seasonInt);
    }

    public List<DraftTeamInfo> findDraftTeamInfoList(String season){
        List<DraftTeamInfo> draftTeamInfoList = new ArrayList<>();
        int seasonInt = Integer.parseInt(season);
        List<DraftTeam> draftTeamList = draftTeamRepository.findBySeasonOrderByPick(seasonInt);
        for (DraftTeam draftTeam : draftTeamList){
            ModelMapper modelMapper = new ModelMapper();
            DraftTeamInfo draftTeamInfo = modelMapper.map(draftTeam,DraftTeamInfo.class);
            draftTeamInfoList.add(draftTeamInfo);
        }
        return draftTeamInfoList;
    }


    public DraftTeam findDraftTeam(int season, String teamName,String password){
        return draftTeamRepository.findBySeasonAndTeamNameAndPassword(season, teamName, password);
    }
}
