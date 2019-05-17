package com.mycompany.app;

import com.sun.org.apache.xerces.internal.dom.DocumentImpl;
import com.sun.org.apache.xpath.internal.compiler.Keywords;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;

public class SettingsLoader {
    private static final String PATH_TO_DEFAULT_SETTINGS = "Settings.xml";
    private    String settingsPath;
    private    Document document;

    public SettingsLoader(String settingsPath) throws Exception{
        this.settingsPath = settingsPath;
        openFlie();
    }

    public ArrayList<ParsingAsset> loadFromFile() throws Exception{
System.out.println(document);

        if(document==null)openFlie();
        System.out.println(document);
        System.out.println(document.getPrefix());

        NodeList configs = document.getElementsByTagName("parsingAsset");
        ArrayList<ParsingAsset> all = getAssets(configs);
       return  all;


    }

    public ArrayList<ParsingAsset> getAssets(NodeList assetList) {
        ArrayList<ParsingAsset> result  = new ArrayList<ParsingAsset>(assetList.getLength());
       // System.out.println(assetList.getLength() +"|"+result.size());
        for (int i=0; i<assetList.getLength();i++){
            result.set(i, getAsset(assetList.item(i)));
        }
        return result;

    }

    private ParsingAsset getAsset(Node asset){
        NamedNodeMap raw_atributes= asset.getAttributes();
        String assetUrl = raw_atributes.getNamedItem("URL").getNodeValue();
        boolean caseEqualization = false;
        if(raw_atributes.getNamedItem("caseEqualization")!=null) caseEqualization=Boolean.parseBoolean(raw_atributes.getNamedItem("caseEqualization").getNodeValue());
        long delay = -1;
        if(raw_atributes.getNamedItem("delay")!=null)
            delay = Long.parseLong(raw_atributes.getNamedItem("delay").getNodeValue());
        String[]keywords = extractKeywords(asset).toArray(new String[0]);
        return new ParsingAsset(assetUrl,keywords,caseEqualization,delay);

    }
private ArrayList<String> extractKeywords(Node Asset){
    //NodeList result = new NodeList();
    ArrayList<String> result = new ArrayList<String>();
     NodeList raw = Asset.getChildNodes();
     for (int i=0; i<raw.getLength();i++){
         Node currient = raw.item(i);
         if(currient.getNodeName().contains("Keyword")) result.add(currient.getTextContent());
     }
     return result;


}


public void rebuildDocument( ParsingAsset[] assets){

    Document xmlDoc = new DocumentImpl();
    Element root = xmlDoc.createElement("Settings");

    for (ParsingAsset newsetting : assets){
        Element item = xmlDoc.createElement("parsingAsset");
        Attr url =  xmlDoc.createAttribute("URL");
        url.setValue(newsetting.url);
        item.setAttributeNode(url);
        Attr caseEqualization =  xmlDoc.createAttribute("caseEqualization");
        caseEqualization.setValue(Boolean.toString(newsetting.caseEqualization));
        item.setAttributeNode(caseEqualization);
        if(newsetting.delay>=0){
            Attr delay =  xmlDoc.createAttribute("delay");
            delay.setValue(Long.toString(newsetting.delay));
            item.setAttributeNode(delay);
            for(String word : newsetting.keywords){
                Element keyword = xmlDoc.createElement("Keyword");
                keyword.appendChild( xmlDoc.createTextNode(word));
                item.appendChild(keyword);
            }
        }
        root.appendChild(item);
    }
    xmlDoc.appendChild(root);

    document = xmlDoc;

}


private void openFlie()throws Exception{

    DocumentBuilder documentBuilder;
    documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    System.out.println(documentBuilder);
    try{  document = documentBuilder.parse(settingsPath);
    }
      catch (FileNotFoundException e){ e.fillInStackTrace();}
    if(document==null){

          ClassLoader classLoader = getClass().getClassLoader();
          InputStream is =(classLoader.getResourceAsStream(PATH_TO_DEFAULT_SETTINGS));
          document= documentBuilder.parse(is);
      }
    }

    public void saveFile()throws Exception{

        DOMSource source = new DOMSource(document);
        FileWriter writer = new FileWriter(new File(settingsPath));
        StreamResult result = new StreamResult(writer);

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }

}

