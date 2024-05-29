package com.example.linebot.replier.weatherGetter;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GetWeatherIsikari implements GetWeather{


    @Override
    public String getWeather() {
        String url="https://www.jma.go.jp/bosai/forecast/data/forecast/016000.json";
        String json=fetchJsonFromUrl(url);

        JsonArray jsonArray= JsonParser.parseString(json).getAsJsonArray();
        JsonObject tmp=jsonArray.get(0).getAsJsonObject();
        JsonArray tmp2=tmp.get("timeSeries").getAsJsonArray();
        tmp=tmp2.get(0).getAsJsonObject();
        tmp2=tmp.get("areas").getAsJsonArray();
        tmp=tmp2.get(0).getAsJsonObject();
        tmp2=tmp.get("weathers").getAsJsonArray();
        return tmp2.get(1).getAsString();
    }
}
