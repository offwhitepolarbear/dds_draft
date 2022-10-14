package com.kihwangkwon.socket.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SocketResponseDomain {
    SocketMessageType socketMessageType;
    Object object;
}
