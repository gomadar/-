package com.example.linebot.replier;

import com.linecorp.bot.model.message.ImageMessage;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.ImagemapMessage;

import java.net.URI;
import java.net.URL;
import java.util.Random;
public class Omikuji implements Replier{
    @Override
    public Message reply(){
        int ranNum=new Random().nextInt(3);
        String uriString="";
        switch (ranNum){
            case 2:
                uriString="https://2.bp.blogspot.com/-h61ngruj0tE/T3K7RDUWmPI/AAAAAAAAE-0/KXtPY8fDwco/s1600/omikuji_daikyou.png";
                break;
            case 1:
                uriString="https://4.bp.blogspot.com/-qCfF4H7YOvE/T3K7R5ZjQVI/AAAAAAAAE-4/Hd1u2tzMG3Q/s1600/omikuji_kyou.png";
                break;
            default:
                uriString="https://3.bp.blogspot.com/-JLNa8mwZRnU/T3K7StR-bEI/AAAAAAAAE-8/rQrDomz5MSw/s1600/omikuji_suekichi.png";
                break;

        }
        URI uri= URI.create(uriString);
        return new ImageMessage(uri,uri);
    }
}
