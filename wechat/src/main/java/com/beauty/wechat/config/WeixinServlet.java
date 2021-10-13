package com.beauty.wechat.config;


import com.beauty.wechat.utils.CheckSignatureUtil;
import com.beauty.wechat.utils.MessageUtil;
import com.beauty.wechat.utils.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.dom4j.DocumentException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/10/8 2:13 下午
 */
@Slf4j
public class WeixinServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /*
     * 响应get请求，微信默认token校验时使用get请求
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //接收微信用来校验信息的内置规定参数
        String signature = req.getParameter("signature");// 微信加密签名
        String timestamp = req.getParameter("timestamp");// 时间戳
        String nonce = req.getParameter("nonce");// 随机数
        String echostr = req.getParameter("echostr");// 随机字符串

        log.info("入参{}", req);
        log.info("signature{}", signature);
        log.info("timestamp{}", timestamp);
        log.info("nonce{}", nonce);
        log.info("echostr{}", echostr);

        PrintWriter out = resp.getWriter();
//        按微信指定的规则进行校验并做出响应
        if(CheckSignatureUtil.checkSignature(signature, timestamp, nonce)){
            out.print(echostr);
        }
    }

    /*
     * 响应post请求，微信中消息和菜单交互都是采用post请求
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        String message = "success";
        try {
            //把微信返回的xml信息转义成map
            Map<String, String> map = XmlUtil.xmlToMap(req);
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

}

