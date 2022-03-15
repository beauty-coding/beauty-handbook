package com.beauty.wechat.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

/**
 * description 模板消息实体
 *
 * @author yufengwen
 * @date 2021/10/9 7:11 下午
 */
public class TemplateMessage {
    /**
     * 接收者openid
     */
    private String touser;

    /**
     * 模板ID
     */
    @JsonProperty("template_id")
    private String templateId;

    /**
     * 模板跳转链接（海外帐号没有跳转能力）
     */
    private String url;

    /**
     * 跳小程序所需数据，不需跳小程序可不用传该数据
     */
    private MiniProgram miniprogram;

    /**
     * 模板数据
     */
    private Map<String, DataItem> data = new HashMap<>();

    public void addData(String keyword,DataItem dataItem){
        data.put(keyword,dataItem);
    }

    public Map<String, DataItem> getData(){
        return this.data;
    }

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public String getTemplateId() {
        return templateId;
    }

    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MiniProgram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(MiniProgram miniprogram) {
        this.miniprogram = miniprogram;
    }

    public static class MiniProgram {
        /**
         * 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，暂不支持小游戏）
         */
        String appid;

        /**
         * 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar），要求该小程序已发布，暂不支持小游戏
         */
        String pagepath;

        MiniProgram() {
        }

        MiniProgram(String appid, String pagepath) {
            this.appid = appid;
            this.pagepath = pagepath;
        }

        public String getAppid() {
            return appid;
        }

        public void setAppid(String appid) {
            this.appid = appid;
        }

        public String getPagepath() {
            return pagepath;
        }

        public void setPagepath(String pagepath) {
            this.pagepath = pagepath;
        }
    }


    public static class DataItem {
        String value;

        /**
         * 模板内容字体颜色，不填默认为黑色
         */
        String color;

        public DataItem() {
        }

        public DataItem(String value, String color) {
            this.value = value;
            this.color = color;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }
    }
}
