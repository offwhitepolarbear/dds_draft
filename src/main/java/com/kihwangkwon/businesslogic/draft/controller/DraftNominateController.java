package com.kihwangkwon.businesslogic.draft.controller;

import com.kihwangkwon.businesslogic.draft.domain.DraftNominate;
import com.kihwangkwon.businesslogic.draft.service.DraftNominateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DraftNominateController {
    private final DraftNominateService draftNominateService;



}
