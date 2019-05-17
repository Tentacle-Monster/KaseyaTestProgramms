package com.mycompany.app;

import java.util.concurrent.atomic.AtomicBoolean;

public class Parser {
    private ParsingAsset settings;
    private WebInterface loader;
    private KeynameParser wordfounder;
    private Thread endless_run;
    private AtomicBoolean isRunned = new AtomicBoolean(false);

    public Parser(final ParsingAsset settings) throws Exception {
        this.settings = settings;
        loader = new WebInterface(settings.url);
        wordfounder = new KeynameParser(settings.keywords,settings.caseEqualization);
        endless_run = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            {
                while (isRunned.get()){
                    try {
                        iteration();
                        if(settings.delay>0) Thread.sleep(settings.delay);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

    }
    public void iteration() throws Exception{
        wordfounder.findAllNames(loader.getDocument());
    }

    public void start(){
        isRunned.set(true);
        endless_run.run();

    }
    public void stop(){
        isRunned.set(false);
    }



}
