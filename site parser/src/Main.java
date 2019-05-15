
//import jdk.internal.util.xml.impl.Parser;
//import jdk.nashorn.internal.parser.Parser;
//import com.sun.org.apache.xalan.internal.xsltc.compiler.Parser;
//import jdk.nashorn.internal.parser.Parser;
import jdk.nashorn.internal.runtime.ParserException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.traversal.NodeFilter;
import sun.nio.cs.Surrogate;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.Parser;
//import javax.swing.text.html.parser.Parser;


import java.io.*;
import java.net.*;
import javax.swing.text.*;
import javax.swing.text.html.*;
import javax.swing.text.html.parser.*;

public class Main {

        private static String adr= "http://tvset.tut.by/";
        private static URL url = null;
        private static HttpURLConnection conn = null;
        private static BufferedReader br = null;
        private static String str;
        static private String[] keywords = new String[]{"Кухня","комедия","Мухтар","полиция","смерть","Свят","овости"};

    public static void main(String [] args) {
        try {
            url = new URL(adr); //создаем URL
            conn = (HttpURLConnection) url.openConnection(); //открываем соединение
            br = new BufferedReader(new InputStreamReader(
                    conn.getInputStream())
            ); // используем объект класса BufferedReader для работы со строками
            while ((str = br.readLine()) != null) { // пока не достигнут конец, считываем страницу построчно
               for (int i=0; i<keywords.length;i++)
                if(str.contains(keywords[i]))
                System.out.println(str);
            }

            br.close(); //закрываем поток
        } catch (IOException e) {
            e.printStackTrace();
        }
        conn.disconnect(); //закрываем соединение

        }}

