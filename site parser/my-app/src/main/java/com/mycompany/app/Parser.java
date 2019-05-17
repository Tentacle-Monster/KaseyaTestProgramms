package com.mycompany.app;

import java.util.concurrent.atomic.AtomicBoolean;

public class Parser implements Runnable {
    private ParsingAsset settings;
    private WebInterface loader;
    private KeynameParser wordfounder;
    private Thread endless_run;


    public Parser(final ParsingAsset settings) throws Exception {
        this.settings = settings;
        loader = new WebInterface(settings.url);
        wordfounder = new KeynameParser(settings.keywords, settings.caseEqualization);
    }
       /* endless_run = new Thread(new Runnable()
        {
            public void run() //Этот метод будет выполняться в побочном потоке
            { Thread current = Thread.currentThread();

                while (!current.isInterrupted()){
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


    public void start(){
        endless_run.run();

    }
    public void stop(){

        endless_run.interrupt();
    }

*/


    public void iteration() throws Exception {
        wordfounder.findAllNames(loader.getDocument());
    }

    public void run() {
        Thread current = Thread.currentThread();
        while (!current.isInterrupted()) {
            try {
                iteration();
                if (settings.delay > 0) Thread.sleep(settings.delay);
            } catch (Exception e) {
               // e.printStackTrace();
            }
        }
    }
}