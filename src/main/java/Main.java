import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://lenta.ru").get();
            Elements el = doc.getElementsByTag("img");
            List<String> list = new ArrayList<>();
            for (Element element : el) {
                String srcElement = element.absUrl("src");
                srcElement = srcElement.substring(srcElement.lastIndexOf("/") + 1);
                list.add(srcElement);
                System.out.println(srcElement);
            }
            Files.write(Path.of("image.txt"), list,StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
