package jonathan.jaron.boodschappenVergelijkerBackend.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class HtmlService {
    public String extractImageUrls(String html) throws IOException {
        List<String> imageUrls = new ArrayList<>();

        Document document = Jsoup.parse(html);


        // Select all <img> elements with the specified class
//        System.out.println(document);
//        Elements imgElements = document.select("img.lazy-image_image__o9P+M");
        Element imgElement = document.select("img").get(1);
//        System.out.println("ruw print: "+ document.select("img"));
//        System.out.println("class print 1: " + document.select("lazy-image_image__o9P+M"));
//        System.out.println("class print: " + document.select("img.lazy-image_image__o9P+M"));
//        System.out.println("imgElements: " + imgElements);

//        for (Element imgElement : imgElements) {
            // Get the "src" attribute of each <img> element
//        System.out.println(imgElement);
            return imgElement.attr("src");
//            imageUrls.add(imageUrl);
//        }
//        return "";
    }
}
