package jonathan.jaron.boodschappenVergelijkerBackend.service;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class ImageGetterService {
    @Autowired
    private HtmlService htmlService;


    private final SupermarktRepository supermarktRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ImageGetterService(SupermarktRepository supermarktRepository, ProductRepository productRepository) {
        this.supermarktRepository = supermarktRepository;
        this.productRepository = productRepository;
    }

    public void getImages() {

        List<Supermarkt> supermarktList = supermarktRepository.findAll();

        for (Supermarkt supermarkt: supermarktList) {
            String rootUrl = supermarkt.getUrl();
            List<Product> productList = supermarkt.getProducten();

            for (Product product: productList) {
                String productUrl = product.getUrl();
                String imagePageUrl = rootUrl + productUrl;

                System.out.println("root url: " + imagePageUrl);
                try {
                    String htmlString = getHtmlString(imagePageUrl);
//                    System.out.println( "htmlString: " + htmlString);
                    String imageUrls = htmlService.extractImageUrls(htmlString);
                    System.out.println("imageUrls: " +  imageUrls);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private String getHtmlString(String imageUrl) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet httpGet = new HttpGet(imageUrl);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                if (response.getStatusLine().getStatusCode() == 200) {

                    return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
                } else {
                    throw new IOException("Failed to get url. Status code: " + response.getStatusLine().getStatusCode());
                }
            }
        }
    }
}
