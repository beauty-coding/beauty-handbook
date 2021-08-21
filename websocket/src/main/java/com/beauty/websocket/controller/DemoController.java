package com.beauty.websocket.controller;

import com.beauty.websocket.conf.WebSocketServer;
import com.beauty.websocket.dto.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;

/**
 * WebSocketController
 * @author zhengkai.blog.csdn.net
 */
@RestController
public class DemoController {

    @GetMapping("index")
    public ResponseEntity<String> index(){
        return ResponseEntity.ok("请求成功");
    }

    @GetMapping("page")
    public ModelAndView page(){
        return new ModelAndView("websocket");
    }

    @PostMapping("/push")
    public ResponseEntity<String> pushToWeb(@RequestBody Request request) throws IOException {
        WebSocketServer.sendInfo(request.getMessage(),request.getAppId(),request.getToUserId());
        return ResponseEntity.ok("MSG SEND SUCCESS");
    }
}

