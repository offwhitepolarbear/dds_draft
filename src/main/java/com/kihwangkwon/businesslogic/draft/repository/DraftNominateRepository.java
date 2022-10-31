package com.kihwangkwon.businesslogic.draft.repository;

import com.kihwangkwon.businesslogic.draft.domain.DraftNominate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DraftNominateRepository extends JpaRepository<DraftNominate, Long> {
    DraftNominate findBySeasonAndPlayerIdAndDraftNominateStatus(int season, String playerId,String draftNominateStatus);

    DraftNominate findFirstBySeasonOrderByCreatedDateDesc(int season);

    List<DraftNominate> findBySeasonOrderByCreatedDateDesc(int season);
}
