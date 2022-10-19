package com.kihwangkwon.businesslogic.draft.service;

import com.kihwangkwon.businesslogic.draft.domain.DraftBid;
import com.kihwangkwon.businesslogic.draft.domain.DraftInfo;
import com.kihwangkwon.socket.SocketMessageService;
import com.kihwangkwon.socket.domain.SocketMessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DraftProcessService {

    private final SocketMessageService socketMessageService;
    private final DraftBidService draftBidService;
    private int timeLeft;

    private boolean onDraft;

    private DraftInfo draftInfo;

    public void draftProcessor() throws InterruptedException {
        if(onDraft){
            while(timeLeft>0){
                Thread.sleep(1000);
                timeLeft = timeLeft-1;
            }
            if(timeLeft<=0){
                nextProcess();
            }

        }
        else{

        }
    }

    public int getTimeLeft(){
        return this.timeLeft;
    }

    public void handleBid(DraftBid draftBid){
        if (draftBidService.checkBidapproval(draftBid)){
            draftBidService.placeBid(draftBid);
        }
        else {
            System.out.println("bid 거절됨");
        }


    }
    public boolean isBidSuccess(DraftBid draftBid){
        boolean result = false;
        return result;
    }

    public void nextProcess() throws InterruptedException {
        // 비드 상황 확인
        // 노미네이트 확인
        // 드래프트 순서 확인
        // 팀 선수 수 확인(비딩/노미네이트 가능한지)
        // 시간 리셋
        setTimeLeft(10);
        draftProcessor();
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
        socketMessageService.sendMessageToAll(SocketMessageType.TIME_LEFT, this.timeLeft);
    }
}
