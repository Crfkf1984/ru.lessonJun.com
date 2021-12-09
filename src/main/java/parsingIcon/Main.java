package parsingIcon;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://lenta.ru").get();
            Elements el = doc.getElementsByTag("img");
            writeFiles(el, "image");
//            List<String> list = new ArrayList<>();
//            for (Element element : el) {
//                String srcElement = element.absUrl("src");
//                srcElement = srcElement.substring(srcElement.lastIndexOf("/") + 1);
//                list.add(srcElement);
//                System.out.println(srcElement);
//            }
            //Files.write(Path.of("image.txt"), list,StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeFiles(Elements elements, String downloadPath) throws IOException {
        for(int i = 0; i<elements.size();i++) {
            String name = i + ".jpg";
            URL url = new URL(elements.get(i).absUrl("src"));
            InputStream in = url.openStream();
            OutputStream out = new BufferedOutputStream(new FileOutputStream( downloadPath + name));
            for (int b; (b = in.read()) != -1;) {
                out.write(b);
            }
            out.close();
            in.close(); }

        }

    }
