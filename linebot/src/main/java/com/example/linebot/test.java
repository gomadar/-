package com.example.linebot;

import com.example.linebot.replier.weatherGetter.GetWeatherIsikari;
import com.example.linebot.replier.weatherGetter.GetWeatherSiribesi;
import com.example.linebot.replier.weatherGetter.GetWeatherSorati;

public class test {
    public static void main(String[] args) {

        GetWeatherSiribesi isikari=new GetWeatherSiribesi();
        String st=isikari.getWeather();
        System.out.println(st);
    }
}




