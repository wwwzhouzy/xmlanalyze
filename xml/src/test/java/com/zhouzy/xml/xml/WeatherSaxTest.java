package com.zhouzy.xml.xml;

import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.zhouzy.xml.Forecast;
import com.zhouzy.xml.Weather;
import com.zhouzy.xml.WeatherSax;

public class WeatherSaxTest {

    public static void main(String[] args) throws Exception{
        Weather weather = new WeatherSaxTest().readXml();
        System.out.println("city=" + weather.getCity());
        System.out.println("forecase_date=" + weather.getForecase_date());
        System.out.println("current_date_time=" + weather.getCurrent_date_time());
        System.out.println("condition=" + weather.getCurrent_condition());
        System.out.println("humidity=" + weather.getCurrent_humidity());
        System.out.println("icon=" + weather.getCurrent_image_url());
        System.out.println("wind_condition=" + weather.getCurrent_wind());
        System.out.println("===========");
        List<Forecast> forecasts = weather.getForecasts();
        for(Forecast forecast : forecasts){
            System.out.println("day_of_week=" + forecast.getDay_of_week());
            System.out.println("low=" + forecast.getLow());
            System.out.println("high=" + forecast.getHigh());
            System.out.println("icon=" + forecast.getImage_url());
            System.out.println("condition=" + forecast.getCondition());
            System.out.println("---------------");
        }
        
    }
    
    private Weather readXml() throws Exception{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        InputStream is = WeatherSaxTest.class.getClassLoader().getResourceAsStream("fuzhou_weather.xml");
        WeatherSax handle = new WeatherSax();
        parser.parse(is, handle);
        is.close();
        return handle.getWeather();
    }
}