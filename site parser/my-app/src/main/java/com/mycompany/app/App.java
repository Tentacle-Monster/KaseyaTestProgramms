package com.mycompany.app;


import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
//import com.foo.Bar;
import java.io.File;
import java.io.IOException;


public class App

{
    private static final String PATH_TO_SETTINGS = "Settings.xml";
    public static void main(String[] args) {

        try {
            Controller controller = new Controller(PATH_TO_SETTINGS);
            controller.load();
            controller.setCurrientAssetNomber(0);
            controller.refresh();
            Thread.sleep(1250);
            controller.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }
        //alpha.parse();




     // parse zombie table


     /*


     try {
            File input = new File("/home/romchik/Downloads/Telegram Desktop/Spanning Backup Domain Admin_ Progress Monitor.html");
            doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

        }catch (Exception e){
            System.out.println("unable to load page!");
            System.out.println(url);
        }
             ArrayList<Float> persents = new ArrayList<Float>();

  Element table = doc.select("tbody").get(1); //select the first table.
        Elements rows = table.select("tr");
        for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");

            try {
                System.out.println(cols.get(16).ownText());
                float a = Float.parseFloat(cols.get(16).ownText());
                if(a>0 && a<99.9f)
                persents.add(a);
            }catch (Exception e){

            }

        }
        float sum = 0;
        for(float cur: persents){
            sum+=cur;
        }
        System.out.println(sum+"/"+persents.size()+"="+sum/persents.size());
*/
    }
}
