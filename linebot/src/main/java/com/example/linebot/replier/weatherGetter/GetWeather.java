package com.example.linebot.replier.weatherGetter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

interface GetWeather {


    public  String getWeather() ;

    public default String fetchJsonFromUrl(String urlString) {
        StringBuilder result = new StringBuilder();

        try {
            // 1. URLをインスタンス化
            URL url = new URL(urlString);

            // 2. HttpURLConnectionオブジェクトを作成
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 3. リクエストメソッドをGETに設定
            connection.setRequestMethod("GET");

            // 4. レスポンスコードが200（接続に成功）の場合のみ処理を行う
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                // 5. 入力データをInputStream、BufferedReaderの順に変換し、readerをresultに入れる。
                //BufferedReaderはバッファーであり、InputStreamReaderはバイト型(?)の文字をstr型の文字のStreamに変換する。
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {//ここでreaderを定義。tryが終わると削除される。
                    String line;
                    /*(line = reader.readLine()),!=null,appendの順でループし、!=nullがfalseだったらループを抜ける*/
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                }catch (IOException e) {
                    e.printStackTrace();//ログを出力する
                }
            } else {
                // 6. HTTPレスポンスコードが200以外の場合
                System.out.println("Failed to fetch JSON. HTTP response code: " + connection.getResponseCode());
            }

            // 7. HttpURLConnectionを切断
            connection.disconnect();
        } catch (IOException e) {
            // 8. エラーハンドリング: 通信や入出力に関する例外
            e.printStackTrace();//ログを出力する
        }

        // 9. 結果を文字列として返す
        return result.toString();
    }

}
