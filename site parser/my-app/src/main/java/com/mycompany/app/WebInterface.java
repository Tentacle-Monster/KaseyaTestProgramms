package com.mycompany.app;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebInterface {
    private String Url;

    public WebInterface(String url) {
        Url = url;
    }

    public static Document getDocByUrl(String url) throws Exception{
        Document doc = Jsoup.connect(url).get();
        return doc;
    }
    public Document getDocument() throws Exception{
        return WebInterface.getDocByUrl(Url);
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }
}
