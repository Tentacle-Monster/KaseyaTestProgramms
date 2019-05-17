package com.mycompany.app;

import java.util.ArrayList;

public class Controller {
    private Parser parser;
    private Thread pasingThread;
    private SettingsLoader loader;
    private ArrayList<ParsingAsset>assets;
    private int currientAssetNomber;

    public Controller(String settingsAdress) throws Exception {
      //  System.out.println(settingsAdress);
        loader = new SettingsLoader(settingsAdress);
        load();

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
    public void refresh() throws Exception{
        if(parser!=null)stop();
        parser = new Parser(assets.get(currientAssetNomber));
        start();
    }
    public void start(){
        pasingThread = new Thread(parser);
        pasingThread.start();
    }
    public void stop(){
        pasingThread.interrupt();
    }
    public void save() throws Exception{
        loader.rebuildDocument(assets.toArray(new ParsingAsset[0]));
        loader.saveFile();
    }
    public void load() throws Exception {
        assets = loader.loadFromFile();
    }

}
