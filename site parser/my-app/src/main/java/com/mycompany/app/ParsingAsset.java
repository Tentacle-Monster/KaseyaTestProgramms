package com.mycompany.app;


import org.jsoup.nodes.Document;

public class ParsingAsset {

    public String url;
    public String[] keywords;
    public boolean caseEqualization;
    public long delay;

    public ParsingAsset(String url, String[] keywords, boolean caseEqualization,long delay ) {
        this.url = url;
        this.keywords = keywords;
        this.caseEqualization = caseEqualization;
        this.delay = delay;
    }

    public ParsingAsset() {
    }

    public String getFullString(){
        String result=getMinimumString();
        result+= "\nKeywords:\n";
        result+=getKeywordsString();
return result;
    }
    public String getMinimumString(){
        return ("URL: "+ url + "  | delay: " + delay);
    }
    public String getKeywordsString(){
String result = new String("");
        for (int i=0;i<keywords.length;i++){
            result+=("\n    "+i+") "+keywords[i]);
        }
        return result;
    }
}
