package com.beauty.jvm;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/8/27 10:05 上午
 */
@RestController
public class OomTest {

    @GetMapping("/oom")
    public String createBean(){
        List<byte[]> list = new ArrayList();

        for (int i = 0; i < 100; i++) {
            byte[] o = new byte[1024*1024];
            list.add(o);
        }

        return "no oom end";
    }
}
