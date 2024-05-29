package com.example.linebot.replier;

import java.util.List;
import java.util.Arrays;

import com.example.linebot.replier.weatherGetter.*;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.quickreply.QuickReply;
import com.linecorp.bot.model.message.quickreply.QuickReplyItem;
// おうむ返し用の返信クラス
public class Weather implements Replier {




    @Override
    public Message reply() {
        GetWeatherIsikari isikari =new GetWeatherIsikari();
        GetWeatherSorati sorati =new GetWeatherSorati();
        GetWeatherSiribesi siribesi=new GetWeatherSiribesi();
        List<QuickReplyItem> quickReplyItems = Arrays.asList(
                QuickReplyItem.builder()
                        .action(new MessageAction("石狩", isikari.getWeather()))
                        .build(),
                QuickReplyItem.builder()
                        .action(new MessageAction("空知", sorati.getWeather()))
                        .build(),
                QuickReplyItem.builder()
                        .action(new MessageAction("後志", siribesi.getWeather()))
                        .build()
        );

        QuickReply quickReply = QuickReply.items(quickReplyItems);
        TextMessage textMessage = TextMessage.builder()
                .text("地域を選択してください")
                .quickReply(quickReply)
                .build();
        return textMessage;
    }

}
