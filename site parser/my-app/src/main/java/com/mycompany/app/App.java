package com.mycompany.app;


import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class App 
{
    public static void main(String[] args) throws IOException {
        Validate.isTrue(args.length == 1, "usage: supply url to fetch");
        String url = args[0];
        Document doc = Jsoup.connect(url).get();
        Elements all = doc.getAllElements();
        boolean noCaseCare= true;
        String[] keywords= new String[]{"jsoup","parsing","java","html","example","git","stackowerflou","realisation"};
        for(Element src: all){
            String paragraph = src.ownText();
            if(noCaseCare) paragraph=paragraph.toLowerCase();
            for(String keyword: keywords){
             if(paragraph.contains(keyword))
             {
                 System.out.println("Keyword \"" + keyword + "\" found in string");
                 System.out.println(paragraph);
             }
        }}
    }
}
