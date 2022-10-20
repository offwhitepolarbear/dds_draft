package com.kihwangkwon.businesslogic.draft.repository;

import com.kihwangkwon.businesslogic.draft.domain.DraftNominate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DraftNominateRepository extends JpaRepository<DraftNominate, Long> {
    DraftNominate findBySeasonAndPlayerIdAndDraftNominateStatus(int season, String playerId,String draftNominateStatus);
}
