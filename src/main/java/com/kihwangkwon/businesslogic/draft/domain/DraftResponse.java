package com.kihwangkwon.businesslogic.draft.domain;

import com.kihwangkwon.businesslogic.draft.domain.enumerate.DraftResponseType;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
public class DraftResponse {
	DraftResponseType draftResponseType;
	Object DraftMessage;
	Timestamp messageTime;

}
