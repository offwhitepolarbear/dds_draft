package com.kihwangkwon.businesslogic.draft.service;
import com.kihwangkwon.businesslogic.draft.domain.DraftInfo;
import com.kihwangkwon.businesslogic.draft.domain.DraftResult;
import com.kihwangkwon.businesslogic.draft.domain.DraftTeam;
import com.kihwangkwon.businesslogic.draft.domain.response.DraftTeamInfo;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DraftService {

    private final DraftInfoService draftInfoService;
    private final DraftResultService draftResultService;
    private final DraftTeamService draftTeamService;

    public List<DraftTeamInfo> bidableTeamList(String season){
        List<DraftTeamInfo> draftTeamInfoList = new ArrayList<>();

        int seasonInt = Integer.parseInt(season);
        DraftInfo draftInfo = draftInfoService.findDraftInfo(seasonInt);
        List<DraftTeam> draftTeamList = draftTeamService.findDraftTeam(season);

        for(DraftTeam draftTeam: draftTeamList){
            List<DraftResult> draftResultList = draftResultService.findDraftResultBySeasonAndTeam(seasonInt, draftTeam.getTeamName());

            ModelMapper modelMapper = new ModelMapper();
            DraftTeamInfo draftTeamInfo = modelMapper.map(draftTeam, DraftTeamInfo.class);
            boolean canBid = false;
            if (draftResultList != null){
                canBid = draftInfo.getPlayerPerTeam()>draftResultList.size();
            }
            else{
                canBid = true;
            }
            draftTeamInfo.setBiddable(canBid);
            draftTeamInfoList.add(draftTeamInfo);
        }
            return draftTeamInfoList;
    }
}