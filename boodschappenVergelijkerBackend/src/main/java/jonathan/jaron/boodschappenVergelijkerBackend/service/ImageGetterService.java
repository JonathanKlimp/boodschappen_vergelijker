package jonathan.jaron.boodschappenVergelijkerBackend.service;
//
//import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
//import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
//import jonathan.jaron.boodschappenVergelijkerBackend.model.SupermarktDto;
//import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
//import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
//import org.apache.http.client.methods.CloseableHttpResponse;
//import org.apache.http.client.methods.HttpGet;
//import org.apache.http.impl.client.CloseableHttpClient;
//import org.apache.http.impl.client.HttpClients;
//import org.apache.http.util.EntityUtils;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import org.springframework.web.client.HttpStatusCodeException;
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.util.List;
//
@Service
public class ImageGetterService {
//    @Autowired
//    private HtmlService htmlService;
//
//
//    private final SupermarktRepository supermarktRepository;
//    private final ProductRepository productRepository;
//
//    @Autowired
//    public ImageGetterService(SupermarktRepository supermarktRepository, ProductRepository productRepository) {
//        this.supermarktRepository = supermarktRepository;
//        this.productRepository = productRepository;
//    }
//
//    public void getImages() {
//
//        List<SupermarktDto> supermarktList = supermarktRepository.findAll();
//
//        for (SupermarktDto supermarkt: supermarktList) {
//            String rootUrl = supermarkt.getUrl();
//            List<Product> productList = supermarkt.getProducten();
//            int productListSize = productList.size();
//            int count = 0;
//            for (Product product: productList) {
//
//                System.out.println("url zoeken voor product: " + product.getNaam() + "supermarkt: " + supermarkt.getNaam());
//                String productUrl = product.getUrl();
//                String imagePageUrl = rootUrl + productUrl;
//
////                System.out.println("root url: " + imagePageUrl);
//                try {
//                    String htmlString = getHtmlString(imagePageUrl);
////                    System.out.println( "htmlString: " + htmlString);
//                    String imageUrl = htmlService.extractImageUrls(htmlString);
////                    System.out.println("imageUrl: " +  imageUrl);
////                    updateNullImageUrls(imageUrl);
//                    product.setImageUrl(imageUrl);
//                } catch (HttpStatusCodeException e) {
//                    if (e.getStatusCode().value() == 404) {
//                        // Handle the 404 error and return a default value
//                        product.setImageUrl("Kon geen pagina vinden");
//                    }
//                } catch (IOException e) {
//                    product.setImageUrl("Kon geen pagina vinden");
//                }
//                System.out.println("nog " + (productListSize - count) + "producten te gaan");
//                count++;
//                productRepository.save(product);
//            }
//            System.out.println("Supermarkt is klaar "+ supermarkt.getNaam());
////            productRepository.saveAll(productList);
//
//        }
//    }
//
//    private String getHtmlString(String imageUrl) throws IOException {
//        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
//            HttpGet httpGet = new HttpGet(imageUrl);
//            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
//                if (response.getStatusLine().getStatusCode() == 200) {
//                    return EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
//                } else {
//                    throw new IOException("Failed to get url. Status code: " + response.getStatusLine().getStatusCode());
//                }
//            }
//        }
//    }
}
