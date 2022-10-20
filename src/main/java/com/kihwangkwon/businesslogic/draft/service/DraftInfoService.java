package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftInfo;
import com.kihwangkwon.businesslogic.draft.repository.DraftInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DraftInfoService {
    private final DraftInfoRepository draftInfoRepository;

    public DraftInfo findDraftInfo(int season){
        return draftInfoRepository.findBySeason(season);
    }

}
