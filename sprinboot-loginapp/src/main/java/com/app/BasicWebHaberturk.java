package com.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class BasicWebHaberturk {
    public static void main(String[] args) throws IOException {
        String sayfa = "https://www.haberturk.com/ekonomi";
        Document d = Jsoup.connect(sayfa).get();
        for(Element baslik : d.getElementById("SliderBottomNews")
                .select("div div .info a:last-child"))
        {
            System.out.println(baslik.text());
            System.out.println(baslik.attr("abs:href"));
        }

    }
}