package com.beauty.wechat.utils;

import com.beauty.wechat.constant.WeChatInfo;
import org.springframework.boot.configurationprocessor.json.JSONObject;

/**
 * description
 *
 * @author yufengwen
 * @date 2021/10/11 7:49 下午
 */
public class CommonUtil {
    /**
     * 网页授权获取openId
     * @Title: getOpenId
     * @Description: TODO
     * @param code
     * @return JSONObject
     */
    public static JSONObject getOpenId(String code) {
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
        String requestUrl = url.replace("APPID", WeChatInfo.WX_APPID).replace("SECRET", WeChatInfo.WX_APPSECRET).replace("CODE", code);

//        JSONObject jsonObject = httpsRequest(requestUrl, "GET", null);

        return new JSONObject();
    }
}
