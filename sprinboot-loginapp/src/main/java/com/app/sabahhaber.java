package com.app;

import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import javax.imageio.ImageIO;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class sabahhaber {

    public static void sabahhaber() throws ParserConfigurationException, IOException {




        String url=readRSSFeed("https://www.sabah.com.tr/rss/ekonomi.xml");// RSS site adresi

    }

    public static String readRSSFeed(String urlAddress) throws ParserConfigurationException, IOException{
        File file = new File("output.txt");
        FileWriter filewriter = new FileWriter(file,false);
        BufferedWriter bufferwriter = new BufferedWriter(filewriter);

        // site adına göre klasör olusturmak istiyorum bu yuzden site adını urlden ayıklamak için alttaki kodları yazdım.
        int sayac=0,p=0,j=0,t=0,id;

        char tut[]=new char [999];
        String src[]=new String[9999],tarih = null;
        Random random = new Random();

        for (int i = 0; i < urlAddress.length(); i++) {
            if(urlAddress.charAt(i)=='.'){
                sayac++;
                i++;
            }
            if(sayac>0 && sayac<2){// site adını www ile com arasındaki alanı aldım.
                tut[p] =urlAddress.charAt(i);
                p++;
            }

        }
        char siteAdiniTut[]=new char [p];
        for (int i = 0; i < p; i++) {
            siteAdiniTut[i]=tut[i];
        }

        // karekter olan siteAdiniTut dizisini stringe çevirdim.Artık elimde siteadı var.
        String siteadi = String.copyValueOf(siteAdiniTut);

        Document doc,docc;
        BufferedImage image =null;
        docc = Jsoup.connect("https://www.sabah.com.tr/rss/ekonomi.xml").get(); // rss'ini çekeceğimiz site linki

        try{
            File s = new File("/home/semih/Desktop/sabah/İCERİK");// icerik klasörü oluşturuldu
            s.mkdir();
            File r = new File("/home/semih/Desktop/sabah/İCERİK/Resimler"); // içerik klasörü içinde resimler klasörü oluşturuldu
            r.mkdir();

            File resimdosyasi = new File(r+"/"+siteadi+"");
            resimdosyasi.mkdir();


            File dosya = new File(s+"/"+siteadi+".txt"); // site ismindeki klasörün içine attık veriyi.

            FileWriter yazici = new FileWriter(dosya,false);
            BufferedWriter yaz = new BufferedWriter(yazici);



            URL rssUrl = new URL (urlAddress);
            BufferedReader in = new BufferedReader(new InputStreamReader(rssUrl.openStream()));
            String sourceCode = "";
            String line;


            while((line=in.readLine())!=null){

                Elements imgs = docc.select("title");
                for (Element img : imgs) {
                    if (img.hasAttr("url")) {
                        URL url = new URL(img.attr("url"));
                        image = ImageIO.read(url);
                        ImageIO.write(image, "png",new File(resimdosyasi+"/"+j+".png"));
                        j++;
                        bufferwriter.write(img.attr("url"));
                        bufferwriter.newLine();
                    }
                }
                //Tarih bilgisini elde ettim
                if(line.contains("<pubDate>")){
                    int firstPos = line.indexOf("<pubDate>");
                    String temp = line.substring(firstPos);
                    temp=temp.replace("<pubDate>","");
                    int lastPos = temp.indexOf("</pubDate>");
                    temp = temp.substring(0,lastPos);
                    tarih=temp; // tarihi aşağıda sıralı kullanmak için burda değişkene attım.
                }

                //link,baslık ve içerik bilgisi elde ettim.
                if(line.contains("<link>")){
                    int firstPos = line.indexOf("<link>");
                    String temp = line.substring(firstPos);
                    temp=temp.replace("<link>","");
                    int lastPos = temp.indexOf("</link>");
                    temp = temp.substring(0,lastPos);

                    //haberin text-area classındaki p ile yazılmıs tüm açıklamayı aldım.
                    doc = Jsoup.connect(temp).get();
                    String baslik = doc.select("title").text();
                    String icerik = doc.select("div.newsDetailText").text();

                    bufferwriter.write("Baslık:"+ baslik);
                    bufferwriter.newLine();
                    bufferwriter.write("Zaman: "+tarih);
                    bufferwriter.newLine();
                    bufferwriter.write( "link: "+temp  );
                    bufferwriter.newLine();
                    bufferwriter.write("İçerik: "+icerik );
                    bufferwriter.newLine();


                    id=random.nextInt(100000000)+111223;
                    bufferwriter.write("İD: "+id);
                    bufferwriter.newLine();

                    //Dosyaya yazdıralım...
                    yaz.write("Başlık :"+baslik+"\n");
                    yaz.write("İd :"+id+"\n");
                    yaz.write("Zaman :"+tarih+"\n");
                    yaz.write("Link :"+temp+"\n");
                    yaz.write("İÇERİK : \n"+icerik+"\n\n------------------------------------------------------------\n \n");


                }

            }

            // RESİMLERİ ALDIM VE KAYIT ETTİM.
            Elements imgs = docc.select("enclosure");
            for (Element img : imgs) {
                if (img.hasAttr("url")) {
                    URL url = new URL(img.attr("url"));
                    image = ImageIO.read(url);
                    j=random.nextInt(100000000)+111223;
                    ImageIO.write(image, "png",new File(resimdosyasi+"/"+j+"_IBO.jpg"));
                    bufferwriter.write(img.attr("url"));
                    bufferwriter.newLine();
                }
            }


            yaz.close();
            in.close();
            return sourceCode;
        }

        catch (MalformedURLException ue){
            System.out.println("Hatalı url");
        } catch (IOException ioe){
            System.out.println("okuma hatası...");
        }
        return null;
    }

    private static void getImages(String src) {
        throw new UnsupportedOperationException("--");
    }
}
