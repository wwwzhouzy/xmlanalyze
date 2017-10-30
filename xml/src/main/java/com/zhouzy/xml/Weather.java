package com.zhouzy.xml;


import java.util.List;

/**
 * 当前天气信息的类
 * 
 * @author jiqinlin
 * 
 */
public class Weather {
    /** 城市 * */
    private String city;
    /** 当天日期，格式为yyyy-mm-dd * */
    private String forecase_date;
    /** 当前时间 * */
    private String current_date_time;
    /** 现象描述 * */
    private String current_condition;
    /** 当前干燥程度 * */
    private String current_humidity;
    /** 当前图片地址 * */
    private String current_image_url;
    /** 风向 * */
    private String current_wind;
    /** 此处只能用有序的List集合，因为第一位索引表示当天的天气情况 **/
    private List<Forecast> forecasts;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getForecase_date() {
        return forecase_date;
    }

    public void setForecase_date(String forecase_date) {
        this.forecase_date = forecase_date;
    }

    public String getCurrent_date_time() {
        return current_date_time;
    }

    public void setCurrent_date_time(String current_date_time) {
        this.current_date_time = current_date_time;
    }

    public String getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(String current_condition) {
        this.current_condition = current_condition;
    }

    public String getCurrent_humidity() {
        return current_humidity;
    }

    public void setCurrent_humidity(String current_humidity) {
        this.current_humidity = current_humidity;
    }

    public String getCurrent_image_url() {
        return current_image_url;
    }

    public void setCurrent_image_url(String current_image_url) {
        this.current_image_url = current_image_url;
    }

    public String getCurrent_wind() {
        return current_wind;
    }

    public void setCurrent_wind(String current_wind) {
        this.current_wind = current_wind;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }

}