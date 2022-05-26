package com.beauty.springboot.controller;

import com.beauty.idgenerator.util.IdGenerator;
import com.beauty.springboot.service.BusinessDealService;
import com.beauty.starter.service.BeautyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class DemoApi {

    @Resource
    private BeautyService beautyService;

    @Autowired
    private BusinessDealService businessDealService;

    @Resource
    private IdGenerator idGenerator;

    @RequestMapping(value = "/getClassQr")
    public void getClassQr(@RequestBody Map<String, String> request, HttpServletResponse response) {
        try {
            // 设置响应流信息
            response.setContentType("image/jpg");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            //海报的宽高
            int pic_width = 750;
            int pic_height = 1334;
            BufferedImage bufferedImage = new BufferedImage(pic_width, pic_height, BufferedImage.TYPE_INT_RGB);
            OutputStream stream = response.getOutputStream();
            bufferedImage = getClassQr(request, bufferedImage);
            //以流的形式输出到前端
            ImageIO.write(bufferedImage, "jpg", stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getClassQr(Map<String, String> request, BufferedImage bufferedImage) {

        String note = "扫码加入班级群";
        Graphics2D graphics2D = (Graphics2D) bufferedImage.getGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0, 0, 750, 1334);
        graphics2D.setColor(Color.BLACK);
        try {
            Font font = new Font("微软雅黑", Font.BOLD, 48);

            font = new Font("微软雅黑", Font.PLAIN, 36);
            graphics2D.setFont(font);
            graphics2D.drawString(note, 252, 1024);
            //5.填充logo图片
            ClassLoader classLoader = this.getClass().getClassLoader();
            String path = classLoader.getResource("").getPath().replace("/WEB-INF/classes/", "/resources/images/oasisbasic/logo.png");
            InputStream inputStream = classLoader.getResourceAsStream(path);
            graphics2D.drawImage(ImageIO.read(inputStream), 206, 1238, 344, 32, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bufferedImage;
    }

    @GetMapping("/id")
    public Long getId(){
        try {
            return idGenerator.nextId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * value：抛出指定异常才会重试
     *  include：和value一样，默认为空，当exclude也为空时，默认所以异常
     *  exclude：指定不处理的异常
     *  maxAttempts：最大重试次数，默认3次
     *  backoff：重试等待策略，默认使用@Backoff，@Backoff的value默认为1000L，我们设置为2000L；multiplier（指定延迟倍数）   默认为0，表示固定暂停1秒后进行重试，如果把multiplier设置为1.5，则第一次重试为2秒，第二次为3秒，第三次为4.5秒。
     * @param param
     * @return
     */
    @Retryable(value= {RemoteAccessException.class},maxAttempts = 4,backoff = @Backoff(delay = 5000,multiplier = 1))
    @GetMapping("/test/get")
    public String testGet(String param){

        System.out.println("重试 - --------");
        throw new RemoteAccessException("test");
    }


    @GetMapping("/test/get/{param}")
    public String testGetParam(@PathVariable String param){
        return param;
    }

    @PostMapping("/test/post")
    public Map testPost(@RequestBody Map param){
        return param;
    }

    @GetMapping("/test/starter")
    public Object testStarter(){
        return beautyService.sayHello("beauty");
    }

    @GetMapping("/test/filter")
    public void testFilter(){
        businessDealService.doWork();
    }

}
