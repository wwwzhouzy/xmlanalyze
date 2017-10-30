package com.zhouzy.xml.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class WeatherSax extends DefaultHandler {
    private Weather weather;
    private Forecast forecast;
    private List<Forecast> forecasts;
    private String preTag;

    @Override
    public void startDocument() throws SAXException {
        weather = new Weather();
        forecasts = new ArrayList<Forecast>();
    }

    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {

    }

    @Override
    public void startElement(String uri, String localName, String name,
            Attributes attr) throws SAXException {

        if ("city".equals(name)) {
            weather.setCity(attr.getValue("data")); // 等价于weather.setCity(attr.getValue("data"));
        }
        if ("forecast_date".equals(name)) {
            weather.setForecase_date(attr.getValue("data"));
        }
        if ("current_date_time".equals(name)) {
            weather.setCurrent_date_time(attr.getValue("data"));
        }
        if("current_conditions".equals(name)){
            preTag = name;
        }
        if ("condition".equals(name) && "current_conditions".equals(preTag)) {
            weather.setCurrent_condition(attr.getValue("data"));
        }
        if ("humidity".equals(name)) {
            weather.setCurrent_humidity(attr.getValue("data"));
        }
        if ("icon".equals(name) && "current_conditions".equals(preTag)) {
            weather.setCurrent_image_url(attr.getValue("data"));
        }
        if ("wind_condition".equals(name)) {
            weather.setCurrent_wind(attr.getValue("data"));
        }

        if ("forecast_conditions".equals(name)) {
            preTag = name; // 记录标识，用来区分相同节点的不同父节点
            forecast = new Forecast();
        }
        if ("day_of_week".equals(name)) {
            forecast.setDay_of_week(attr.getValue("data"));
        }
        if ("low".equals(name)) {
            forecast.setLow(attr.getValue("data"));
        }
        if ("high".equals(name)) {
            forecast.setHigh(attr.getValue("data"));
        }

        if ("icon".equals(name) && "forecast_conditions".equals(preTag)) {
            forecast.setImage_url(attr.getValue("data"));
        }
        if ("condition".equals(name) && "forecast_conditions".equals(preTag)) {
            forecast.setCondition(attr.getValue("data"));
        }

    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        if ("forecast_conditions".equals(name)) {
            forecasts.add(forecast);
            forecast = null;
        }
        if ("weather".equals(name)) {
            weather.setForecasts(forecasts);
        }

    }

    public Weather getWeather() {
        return weather;
    }
}