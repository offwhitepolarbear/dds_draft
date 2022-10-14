package com.kihwangkwon.businesslogic.test.service;

import com.kihwangkwon.businesslogic.player.domain.OfficialPlayerRating;
import com.kihwangkwon.businesslogic.player.repository.OfficialPlayerRatingRepository;
import com.kihwangkwon.businesslogic.test.domain.TestRequest;
import com.kihwangkwon.socket.SocketEndPoint;
import com.kihwangkwon.socket.SocketMessageService;
import com.kihwangkwon.socket.domain.SocketMessageType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {
    private final SocketMessageService socketMessageService;
    private final OfficialPlayerRatingRepository officialPlayerRatingRepository;
    public void test(TestRequest testRequest){
        String playerId = testRequest.getPlayerId();
//        System.out.println(testRequest.toString());
        OfficialPlayerRating officialPlayerRating = officialPlayerRatingRepository.findBySeasonAndPlayerId(20220902, playerId);
        socketMessageService.tt(SocketMessageType.PLACE_BID, officialPlayerRating);
    }

}
