package com.mycompany.app;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

//import org.apache.log4j.LoggerFactory;

public class KeynameParser {
    private String[] keywords;
    private boolean caseEqualization;
    private static Logger logger = LogManager.getLogger(KeynameParser.class);


    public KeynameParser(String[] keywords , boolean caseEqualization) {

        this.keywords = keywords;
        this.caseEqualization = caseEqualization;
        normalizeKeyWords();
    }

    private void normalizeKeyWords(){
        if(caseEqualization)
            for(String keyword : keywords)
                keyword=keyword.toLowerCase();
    }

    public void findAllNames( Document document){
        for(Element curientTag: document.getAllElements()){
            String tagContent=curientTag.ownText();
            findNames(tagContent);

        }

    }

    private void findNames(String input){

        if(caseEqualization) input=input.toLowerCase();
        for(String keyword: keywords){
            if(input.contains(keyword))
            {

                cachWord(keyword);
            }
        }

    }

    private void cachWord(String word){
     logger.info(word);
    }


    public String[] getKeywords() {
        return keywords;
    }

    public void setKeywords(String[] keywords) {
        this.keywords = keywords;
    }

    public boolean isCaseEqualization() {
        return caseEqualization;
    }

    public void setCaseEqualization(boolean caseEqualization) {
        this.caseEqualization = caseEqualization;
    }
}
