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

    public void print(){
        printMinimum();
        System.out.println("Keywords:");
        printKeywords();

    }
    public void printMinimum(){
        System.out.println("URL: "+ url + "  | delay: " + delay);
    }
    public void printKeywords(){

        for (int i=0;i<keywords.length;i++){
            System.out.println("    "+i+") "+keywords[i]);
        }
    }
}
