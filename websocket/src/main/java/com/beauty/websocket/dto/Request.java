package com.beauty.websocket.dto;

import lombok.Data;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/8/21 4:50 下午
 */
@Data
public class Request {

    String message;
    String toUserId;
    String appId;
}
