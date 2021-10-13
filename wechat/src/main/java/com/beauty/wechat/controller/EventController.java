package com.beauty.wechat.controller;

import com.beauty.wechat.utils.CommonUtil;
import com.beauty.wechat.utils.MessageUtil;
import com.beauty.wechat.utils.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/10/8 1:46 下午
 */
@Slf4j
@RestController
public class EventController {


    @GetMapping(value = "/signature")
    public void get(HttpServletRequest request, HttpServletResponse response) throws Exception {

        log.error("WechatController   ----   WechatController");

        System.out.println("========WechatController========= ");
        log.info("请求进来了...");

        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String name = (String) pNames.nextElement();
            String value = request.getParameter(name);

            log.info("name =" + name + "     value =" + value);

        }

        String signature = request.getParameter("signature");/// 微信加密签名
        String timestamp = request.getParameter("timestamp");/// 时间戳
        String nonce = request.getParameter("nonce"); /// 随机数
        String echostr = request.getParameter("echostr"); // 随机字符串

        String msgType = request.getParameter("MsgType"); // 随机字符串
        String event = request.getParameter("Event"); // 随机字符串


        PrintWriter out = response.getWriter();
        out.print(echostr);
        out.close();

    }


    @PostMapping(value = "/signature")
    public void post(HttpServletRequest request, HttpServletResponse response) throws Exception {

        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String message = "success";
        try {
            //把微信返回的xml信息转义成map
            Map<String, String> map = XmlUtil.xmlToMap(request);
            String fromUserName = map.get("FromUserName");//消息来源用户标识
            String toUserName = map.get("ToUserName");//消息目的用户标识
            String msgType = map.get("MsgType");//消息类型
            String content = map.get("Content");//消息内容

            String eventType = map.get("Event");
            if (MessageUtil.MSGTYPE_EVENT.equals(msgType)) {//如果为事件类型
                if (MessageUtil.MESSAGE_SUBSCIBE.equals(eventType)) {//处理订阅事件
                    message = MessageUtil.subscribeForText(toUserName, fromUserName);
                } else if (MessageUtil.MESSAGE_UNSUBSCIBE.equals(eventType)) {//处理取消订阅事件
                    message = MessageUtil.unsubscribe(toUserName, fromUserName);
                }
            }
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            out.println(message);
            out.close();
        }

    }

    /**
     * 网页授权获取用户openid
     * @Title: getOpenId
     * @param @param code
     * @throws
     */
    @RequestMapping(value = "getOpenId", method = RequestMethod.GET)
    public String getOpenId(@RequestParam("code") String code) throws JSONException {
        System.out.println("cede="+code);
        //通过code获取openId
        JSONObject jsonDate = CommonUtil.getOpenId(code);
        if(jsonDate.isNull("errcode")){
            return jsonDate.getString("openid");
        }
        return "";

    }
}
