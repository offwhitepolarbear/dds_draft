package com.kihwangkwon.businesslogic.draft.repository;

import com.kihwangkwon.businesslogic.draft.domain.DraftResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DraftResultRepository extends JpaRepository<DraftResult, Long> {
    List<DraftResult> findBySeason(int season);

    List<DraftResult> findBySeasonAndDraftTeam(int season, String draftTeam);
}
