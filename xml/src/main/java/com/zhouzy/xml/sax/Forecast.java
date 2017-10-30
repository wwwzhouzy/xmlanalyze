package com.zhouzy.xml.sax;

/**
 * 未来天气信息的类
 * 
 * @author jiqinlin
 * 
 */
public class Forecast {
    /** 星期几 * */
    private String day_of_week;
    /** 最低温度 * */
    private String low;
    /** 最高温度 * */
    private String high;
    /** 图片地址 * */
    private String image_url;
    /** 现象描述 * */
    private String condition;

    public String getDay_of_week() {
        return day_of_week;
    }

    public void setDay_of_week(String day_of_week) {
        this.day_of_week = day_of_week;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

}