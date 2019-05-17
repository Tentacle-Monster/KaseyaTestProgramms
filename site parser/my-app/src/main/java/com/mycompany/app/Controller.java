package com.mycompany.app;

import java.util.ArrayList;

public class Controller {
    private Parser parser;
    private Thread pasingThread;
    private SettingsLoader loader;
    private ArrayList<ParsingAsset>assets;
    private int currientAssetNomber;
    private UserInterface user;
    private Thread userThread;

    public Controller(String settingsAdress) throws Exception {
      //  System.out.println(settingsAdress);
        loader = new SettingsLoader(settingsAdress);
        load();
        user = new UserInterface(this);
        userThread = new Thread(user);
        userThread.start();

    }

    public void changeAsset(int i) throws Exception{
        setCurrientAssetNomber(i);
        refresh();
    }
    public ArrayList<ParsingAsset> getAssets(){
        return this.assets;
    }
    public void setCurrientAssetNomber(int i){
        currientAssetNomber = i;
    }
    public void updateAsset(int nomber, ParsingAsset replacement){
        if(nomber >=0 && nomber< assets.size())
            assets.set(nomber,replacement);
    }
    public void deleteAsset(int nomber){

        if(nomber >=0 && nomber< assets.size())
            assets.remove(nomber);
    }
    public void addAsset( ParsingAsset addition){
        assets.add(addition);
    }
    public boolean refresh() throws Exception{
        if(parser!=null)stop();

        parser = new Parser(assets.get(currientAssetNomber));
        System.out.println(assets.get(currientAssetNomber).url);
        return start();
    }
    public boolean start(){
        pasingThread = new Thread(parser);
        pasingThread.start();
        return !pasingThread.isInterrupted();
    }
    public boolean stop(){
        pasingThread.interrupt();
        return pasingThread.isInterrupted();
    }
    public void save() throws Exception{
        loader.rebuildDocument(assets.toArray(new ParsingAsset[0]));
        loader.saveFile();
    }
    public void load() throws Exception {
        assets = loader.loadFromFile();
    }
    public void die(){
        try {
            save();
        } catch (Exception e) {
            e.printStackTrace();
        }
        stop();
        userThread.interrupt();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {

        }finally {
            System.exit(1);
        }
    }



}
