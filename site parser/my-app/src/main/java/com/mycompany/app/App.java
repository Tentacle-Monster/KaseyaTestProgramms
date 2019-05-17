package com.mycompany.app;


import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
//import com.foo.Bar;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class App

{
    private static final String PATH_TO_SETTINGS = "Settings.xml";
    public static void main(String[] args) throws Exception{

     /*   try {
            Controller controller = new Controller(PATH_TO_SETTINGS);
            controller.load();
            controller.setCurrientAssetNomber(0);
            controller.refresh();
            Thread.sleep(1250);
            controller.stop();

        } catch (Exception e) {
            e.printStackTrace();
        }*/
        //alpha.parse();




     // parse zombie table------------------------------------------------


     Document doc;



            File input = new File("/home/romchik/Downloads/Telegram Desktop/Spanning Backup Domain Admin_ Progress Monitor.html");
            doc = Jsoup.parse(input, "UTF-8", "http://example.com/");

    double sum =0;
     int more100 =0;
     int zero = 0;
     int in_activity=0;
     int undef =0;


  Element table = doc.select("tbody").get(1); //select the first table.
        Elements rows = table.select("tr");
        for (int i = 0; i < rows.size(); i++) { //first row is the col names so skip it.
            Element row = rows.get(i);
            Elements cols = row.select("td");

            try {
               // System.out.println(cols.get(16).ownText());
                float a = Float.parseFloat(cols.get(16).ownText());
                in_activity++;
                if(a>=0.0001 && a<100.0001f){

                    sum+=a;
                    if(a>99.99) {more100 ++;
                    System.out.println(cols.get(16).ownText());}

                }
                else zero++;


            }catch (Exception e){
                    undef++;
            }

        }
        System.out.print("\033\143");//очистка вывода
        System.out.println("всего полей : " + rows.size()+ "\nиз них как числа разпознаны :"+in_activity+"\n100% выполнены:" + more100 + "\n 0% выполнены:" +zero + "\n пусты: "+undef);
        System.out.println("сумма чисел = " +sum);
        System.out.println(sum+"/"+in_activity+"="+sum/in_activity);

    }
}
