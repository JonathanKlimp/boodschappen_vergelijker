package jonathan.jaron.boodschappenVergelijkerBackend.service;

import com.beust.ah.A;
import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;
import jonathan.jaron.boodschappenVergelijkerBackend.model.SupermarktDto;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.tools.ConsoleColors;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.NodeList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class ImageGetterService {
    double time_now = System.currentTimeMillis();
    double last_ah = time_now;
    double last_jumbo= time_now;
    double last_aldi= time_now;
    double last_coop= time_now;
    double last_vomar= time_now;
    double last_spar= time_now;
    double last_dirk= time_now;

    int last_coop_id = 30505;


    double progressAmount = 0.0;
    @Autowired
    private HtmlService htmlService;


    private final SupermarktRepository supermarktRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ImageGetterService(SupermarktRepository supermarktRepository, ProductRepository productRepository) {
        this.supermarktRepository = supermarktRepository;
        this.productRepository = productRepository;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void getImages() throws InterruptedException, IOException {

        List<SupermarktDto> supermarktList = supermarktRepository.findAll();


        Thread progress = new Thread(){
            public void run(){
                while(true) {
                    int amountOfProducts = 0;
                    int amountOfProductsWithUrl = 0;
                    for (SupermarktDto supermarkt : supermarktList) {
                        List<ProductDto> productList = supermarkt.getProducten();
                        for (ProductDto selpro : productList) {
                            amountOfProducts++;
                            if (selpro.getImageUrl() != null) {
                                amountOfProductsWithUrl++;
                            }

                        }

                    }
                    progressAmount = ((double) amountOfProductsWithUrl /amountOfProducts) * 100;
                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread last = new Thread(){
            public void run(){
                while (true){
                    double last_ah_local = System.currentTimeMillis() - last_ah;
                    System.out.println("Laatste AH: \t\t" + last_ah_local);

                    double last_jumbo_local = System.currentTimeMillis() - last_jumbo;
                    System.out.println("Laatste Jumbo: \t\t" + last_jumbo_local);

                    double last_aldi_local = System.currentTimeMillis() - last_aldi;
                    System.out.println("Laatste Aldi: \t\t" + last_aldi_local);

                    double last_coop_local = System.currentTimeMillis() - last_coop;
                    System.out.println("Laatste Coop: \t\t" + last_coop_local);

                    double last_vomar_local = System.currentTimeMillis() - last_vomar;
                    System.out.println("Laatste Vomar: \t\t" + last_vomar_local);

                    double last_spar_local = System.currentTimeMillis() - last_spar;
                    System.out.println("Laatste Spar: \t\t" + last_spar_local);

                    double last_dirk_local = System.currentTimeMillis() - last_dirk;
                    System.out.println("Laatste Dirk: \t\t" + last_dirk_local);

                    System.out.println(ConsoleColors.ANSI_GREEN + "Progressie: " + progressAmount +"%" + ConsoleColors.ANSI_RESET);

                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread ah1 = new Thread() {
            public void run() {
                for (SupermarktDto supermarkt : supermarktList) {
                    String rootUrl = supermarkt.getUrl().strip();
                    List<ProductDto> productList = supermarkt.getProducten();
                    int productListSize = productList.size();
                    int count = 0;
                    for (ProductDto product : productList) {
                            if (supermarkt.getNaam().equals("ah")) {
                                if (product.getImageUrl() == null) {
                                try {
                                    Thread.sleep(getRandomNumber(1500, 2500));
                                } catch (InterruptedException e) {
                                    continue;
                                }
                                String productUrl = product.getUrl().strip();
                                String imagePageUrl = rootUrl + productUrl;

                                URL url = null;
                                try {
                                    url = new URL(imagePageUrl);
                                } catch (MalformedURLException e) {
                                    continue;
                                }
                                InputStream is = null;
                                try {
                                    is = url.openStream();
                                } catch (IOException e) {
                                    continue;
                                }
                                int ptr = 0;
                                StringBuffer buffer = new StringBuffer();
                                while (true) {
                                    try {
                                        if (!((ptr = is.read()) != -1)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    buffer.append((char) ptr);
                                }
                                String bufferStr = buffer.toString();
                                BufferedReader bufReader = new BufferedReader(new StringReader(bufferStr));
                                String line = null;
                                String imageUrl = "";
                                int index = 0;
                                ArrayList<String> stringList = new ArrayList<>();
                                while (true) {
                                    try {
                                        if (!((line = bufReader.readLine()) != null)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    line = line.replace("\\u002F", "/");
                                    String[] lines = line.split(",");
                                    for (String selLine : lines) {
                                        if (selLine.contains("800x800")) {
                                            stringList.add(selLine.split("\"")[3]);
                                            break;
                                        }
                                    }

                                }
                                //System.out.println("\nProduct gezocht voor " + product.getNaam() + "supermarkt: " + supermarkt.getNaam());
                                try {
                                    String productImgUrl = stringList.get(0);
                                    //System.out.println("Gevonden IMG Url: \t" + ConsoleColors.ANSI_GREEN + productImgUrl + ConsoleColors.ANSI_RESET);
                                    product.setImageUrl(productImgUrl);
                                    productRepository.save(product);
                                    //System.out.println(ConsoleColors.ANSI_GREEN + "Progressie: " + progressAmount +"%" + ConsoleColors.ANSI_RESET);
                                    last_ah = System.currentTimeMillis();
                                } catch (Exception e) {

                                    System.out.println(ConsoleColors.ANSI_RED + "URL NIET GEVONDEN" + ConsoleColors.ANSI_RESET);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        };

        Thread aldi = new Thread() {
            public void run() {
                for (SupermarktDto supermarkt : supermarktList) {
                    String rootUrl = supermarkt.getUrl().strip();
                    List<ProductDto> productList = supermarkt.getProducten();
                    int productListSize = productList.size();
                    int count = 0;
                    for (ProductDto product : productList) {
                        if (supermarkt.getNaam().equals("aldi")) {
                            if (product.getImageUrl() == null) {
                                try {
                                    Thread.sleep(getRandomNumber(1500, 2500));
                                } catch (InterruptedException e) {
                                    continue;
                                }
                                String productUrl = product.getUrl().strip();
                                String imagePageUrl = productUrl;

                                URL url = null;
                                try {
                                    url = new URL(imagePageUrl);
                                } catch (MalformedURLException e) {
                                    continue;
                                }
                                InputStream is = null;
                                try {
                                    is = url.openStream();
                                } catch (IOException e) {
                                    continue;
                                }
                                int ptr = 0;
                                StringBuffer buffer = new StringBuffer();
                                while (true) {
                                    try {
                                        if ((ptr = is.read()) == -1) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    buffer.append((char) ptr);
                                }
                                String bufferStr = buffer.toString();
                                //System.out.println(bufferStr);
                                BufferedReader bufReader = new BufferedReader(new StringReader(bufferStr));
                                String line = null;
                                int index = 0;
                                ArrayList<String> stringList = new ArrayList<>();
                                while (true) {
                                    try {
                                        if (!((line = bufReader.readLine()) != null)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    if (line.contains("png")) {
                                        index++;
                                        line = line.strip();
                                        stringList.add(line);
                                        //Index 1
                                    }

                                }
                                //System.out.println("\nProduct gezocht voor " + product.getNaam() + "supermarkt: " + supermarkt.getNaam());
                                try {
                                    String productImgUrl = stringList.get(0).split("\"")[3];
                                    //System.out.println("Gevonden IMG Url: \t" + ConsoleColors.ANSI_GREEN + productImgUrl + ConsoleColors.ANSI_RESET);
                                    product.setImageUrl(productImgUrl);
                                    productRepository.save(product);
                                    //System.out.println(ConsoleColors.ANSI_GREEN + "Progressie: " + progressAmount +"%" + ConsoleColors.ANSI_RESET);
                                    last_aldi = System.currentTimeMillis();
                                } catch (Exception e) {

                                    System.out.println(ConsoleColors.ANSI_RED + "URL NIET GEVONDEN" + ConsoleColors.ANSI_RESET);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        };

        Thread dirk = new Thread() {
            public void run() {
                for (SupermarktDto supermarkt : supermarktList) {
                    String rootUrl = supermarkt.getUrl().strip();
                    List<ProductDto> productList = supermarkt.getProducten();
                    int productListSize = productList.size();
                    int count = 0;
                    for (ProductDto product : productList) {
                        if (supermarkt.getNaam().equals("dirk")) {
                            if (product.getImageUrl() == null) {
                                try {
                                    Thread.sleep(getRandomNumber(1500, 2500));
                                } catch (InterruptedException e) {
                                    continue;
                                }
                                String productUrl = product.getUrl().strip();
                                String imagePageUrl = rootUrl + productUrl;

                                URL url = null;
                                try {
                                    url = new URL(imagePageUrl);
                                } catch (MalformedURLException e) {
                                    continue;
                                }
                                InputStream is = null;
                                try {
                                    is = url.openStream();
                                } catch (IOException e) {
                                    continue;
                                }
                                int ptr = 0;
                                StringBuffer buffer = new StringBuffer();
                                while (true) {
                                    try {
                                        if (!((ptr = is.read()) != -1)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    buffer.append((char) ptr);
                                }
                                String bufferStr = buffer.toString();
                                bufferStr = bufferStr.replace(" ", "\n");
                                BufferedReader bufReader = new BufferedReader(new StringReader(bufferStr));

                                String line = null;
                                int index = 0;
                                ArrayList<String> stringList = new ArrayList<>();
                                while (true) {
                                    try {
                                        if (!((line = bufReader.readLine()) != null)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    if (line.contains("&amp")) {
                                        index++;
                                        line = line.strip();
                                        stringList.add(line);
                                    }

                                }
                                //System.out.println("\nProduct gezocht voor " + product.getNaam() + "supermarkt: " + supermarkt.getNaam());
                                try {
                                    String productImgUrl = stringList.get(0).split("\"")[1];
                                    //System.out.println("Gevonden IMG Url: \t" + ConsoleColors.ANSI_GREEN + productImgUrl + ConsoleColors.ANSI_RESET);
                                    product.setImageUrl(productImgUrl);
                                    productRepository.save(product);
                                    //System.out.println(ConsoleColors.ANSI_GREEN + "Progressie: " + progressAmount +"%" + ConsoleColors.ANSI_RESET);
                                    last_dirk = System.currentTimeMillis();
                                } catch (Exception e) {

                                    System.out.println(ConsoleColors.ANSI_RED + "URL NIET GEVONDEN" + ConsoleColors.ANSI_RESET);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        };

        Thread jumbo = new Thread() {
            public void run() {
                for (SupermarktDto supermarkt : supermarktList) {
                    String rootUrl = supermarkt.getUrl().strip();
                    List<ProductDto> productList = supermarkt.getProducten();
                    int productListSize = productList.size();
                    int count = 0;
                    for (ProductDto product : productList) {
                        if (supermarkt.getNaam().equals("jumbo")) {
                            if (product.getImageUrl() == null) {
                                try {
                                    Thread.sleep(getRandomNumber(1500, 2500));
                                } catch (InterruptedException e) {
                                    continue;
                                }

                                String productUrl = product.getUrl().strip();
                                String imagePageUrl = rootUrl + productUrl;

                                URL url = null;
                                try {
                                    url = new URL(imagePageUrl);
                                } catch (MalformedURLException e) {
                                    continue;
                                }
                                InputStream is = null;
                                try {
                                    is = url.openStream();
                                } catch (IOException e) {
                                    continue;
                                }
                                int ptr = 0;
                                StringBuffer buffer = new StringBuffer();
                                while (true) {
                                    try {
                                        if (!((ptr = is.read()) != -1)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    buffer.append((char) ptr);
                                }
                                String bufferStr = buffer.toString();
                                bufferStr = bufferStr.replace(" ", "\n");
                                BufferedReader bufReader = new BufferedReader(new StringReader(bufferStr));

                                String line = null;
                                int index = 0;
                                ArrayList<String> stringList = new ArrayList<>();
                                while (true) {
                                    try {
                                        if (!((line = bufReader.readLine()) != null)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    if (line.contains(".png")) {
                                        line = line.strip();
                                        index++;
                                        stringList.add(line);
                                    }

                                }
                                //System.out.println("\nProduct gezocht voor " + product.getNaam() + "supermarkt: " + supermarkt.getNaam());
                                try {
                                    String productImgUrl = stringList.get(3).split("\"")[1];
                                   //System.out.println("Gevonden IMG Url: \t" + ConsoleColors.ANSI_GREEN + productImgUrl + ConsoleColors.ANSI_RESET);
                                    product.setImageUrl(productImgUrl);
                                    productRepository.save(product);
                                    //System.out.println(ConsoleColors.ANSI_GREEN + "Progressie: " + progressAmount +"%" + ConsoleColors.ANSI_RESET);
                                    last_jumbo = System.currentTimeMillis();
                                } catch (Exception e) {

                                    System.out.println(ConsoleColors.ANSI_RED + "URL NIET GEVONDEN" + ConsoleColors.ANSI_RESET);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        };

        Thread spar = new Thread() {
            public void run() {
                for (SupermarktDto supermarkt : supermarktList) {
                    String rootUrl = supermarkt.getUrl().strip();
                    List<ProductDto> productList = supermarkt.getProducten();
                    int productListSize = productList.size();
                    int count = 0;
                    for (ProductDto product : productList) {
                        if (supermarkt.getNaam().equals("spar")) {
                            if(product.getImageUrl() == null){
                                try {
                                    Thread.sleep(getRandomNumber(1500, 2500));
                                } catch (InterruptedException e) {
                                    continue;
                                }
                                String productUrl = product.getUrl().strip();
                                String imagePageUrl = rootUrl + productUrl;

                                URL url = null;
                                try {
                                    url = new URL(imagePageUrl);
                                } catch (MalformedURLException e) {
                                    continue;
                                }
                                InputStream is = null;
                                try {
                                    is = url.openStream();
                                } catch (IOException e) {
                                    continue;
                                }
                                int ptr = 0;
                                StringBuffer buffer = new StringBuffer();
                                while (true) {
                                    try {
                                        if (!((ptr = is.read()) != -1)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    buffer.append((char) ptr);
                                }
                                String bufferStr = buffer.toString();
                                bufferStr = bufferStr.replace(" ", "\n");
                                BufferedReader bufReader = new BufferedReader(new StringReader(bufferStr));

                                String line = null;
                                int index = 0;
                                ArrayList<String> stringList = new ArrayList<>();
                                while (true) {
                                    try {
                                        if (!((line = bufReader.readLine()) != null)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    if (line.contains("jpg")) {
                                        line = line.strip();
                                        index++;
                                        stringList.add(line);
                                    }

                                }
                                //System.out.println("\nProduct gezocht voor " + product.getNaam() + "supermarkt: " + supermarkt.getNaam());
                                try {
                                    String productImgUrl = stringList.get(0).split("\"")[1];
                                    //System.out.println("Gevonden IMG Url: \t" + ConsoleColors.ANSI_GREEN + productImgUrl + ConsoleColors.ANSI_RESET);
                                    product.setImageUrl(productImgUrl);
                                    productRepository.save(product);
                                    //System.out.println(ConsoleColors.ANSI_GREEN + "Progressie: " + progressAmount +"%" + ConsoleColors.ANSI_RESET);
                                    last_spar = System.currentTimeMillis();
                                } catch (Exception e) {

                                    System.out.println(ConsoleColors.ANSI_RED + "URL NIET GEVONDEN" + ConsoleColors.ANSI_RESET);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        };

        Thread coop = new Thread() {
            public void run() {
                for (SupermarktDto supermarkt : supermarktList) {
                    String rootUrl = supermarkt.getUrl().strip();
                    List<ProductDto> productList = supermarkt.getProducten();
                    int productListSize = productList.size();
                    int count = 0;
                    for (ProductDto product : productList) {
                        if (supermarkt.getNaam().equals("coop")) {
                            if (product.getImageUrl() == null && product.getId() > last_coop_id) {
                                try {
                                    Thread.sleep(getRandomNumber(1500, 2500));
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                String productUrl = product.getUrl().strip();
                                String imagePageUrl = rootUrl + productUrl;

                                WebDriver driver = new FirefoxDriver();
                                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                                driver.get(imagePageUrl);
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                String content = driver.getPageSource();

                                content = content.replace(" ", "\n");
                                driver.quit();
                                //System.out.println(content);

                                BufferedReader bufReader = new BufferedReader(new StringReader(content));
                                String line = null;
                                int index = 0;
                                ArrayList<String> stringList = new ArrayList<>();
                                while (true) {
                                    try {
                                        if (!((line = bufReader.readLine()) != null)) break;
                                    } catch (Exception e) {
                                        continue;
                                    }
                                    if (line.contains("syndy")) {
                                        index++;
                                        line = line.strip();
                                        //System.out.println(index + ": " + line);
                                        stringList.add(line);
                                        //1
                                    }

                                }
                                //System.out.println("\nProduct gezocht voor " + product.getNaam() + "supermarkt: " + supermarkt.getNaam());
                                try {
                                    String productImgUrl = stringList.get(0).split("\"")[1];
                                    //System.out.println("Gevonden IMG Url: \t" + ConsoleColors.ANSI_GREEN + productImgUrl + ConsoleColors.ANSI_RESET);
                                    product.setImageUrl(productImgUrl);
                                    productRepository.save(product);
                                    //System.out.println(ConsoleColors.ANSI_GREEN + "Progressie: " + progressAmount +"%" + ConsoleColors.ANSI_RESET);
                                    last_coop = System.currentTimeMillis();
                                } catch (Exception e) {

                                    System.out.println(ConsoleColors.ANSI_RED + "URL NIET GEVONDEN" + ConsoleColors.ANSI_RESET);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        };

        Thread vomar = new Thread() {
            public void run() {
                for (SupermarktDto supermarkt : supermarktList) {
                    String rootUrl = supermarkt.getUrl().strip();
                    List<ProductDto> productList = supermarkt.getProducten();
                    int productListSize = productList.size();
                    int count = 0;
                    for (ProductDto product : productList) {
                        if (supermarkt.getNaam().equals("vomar")) {
                            if(product.getImageUrl() == null){
                                try {
                                    Thread.sleep(getRandomNumber(1500, 2500));
                                } catch (InterruptedException e) {
                                    continue;
                                }

                                String productUrl = product.getUrl().strip();
                                String imagePageUrl = rootUrl + productUrl;

                                URL url = null;
                                try {
                                    url = new URL(imagePageUrl);
                                } catch (MalformedURLException e) {
                                    continue;
                                }
                                InputStream is = null;
                                try {
                                    is = url.openStream();
                                } catch (IOException e) {
                                    continue;
                                }
                                int ptr = 0;
                                StringBuffer buffer = new StringBuffer();
                                while (true) {
                                    try {
                                        if (!((ptr = is.read()) != -1)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    buffer.append((char) ptr);
                                }
                                String bufferStr = buffer.toString();
                                bufferStr = bufferStr.replace(" ", "\n");
                                BufferedReader bufReader = new BufferedReader(new StringReader(bufferStr));

                                String line = null;
                                int index = 0;
                                ArrayList<String> stringList = new ArrayList<>();
                                while (true) {
                                    try {
                                        if (!((line = bufReader.readLine()) != null)) break;
                                    } catch (IOException e) {
                                        continue;
                                    }
                                    if (line.contains("png")) {
                                        line = line.strip();
                                        index++;
                                        stringList.add(line);
                                    }

                                }
                                //System.out.println("\nProduct gezocht voor " + product.getNaam() + "supermarkt: " + supermarkt.getNaam());
                                try {
                                    String productImgUrl = stringList.get(0).split("\"")[1];
                                    //System.out.println("Gevonden IMG Url: \t" + ConsoleColors.ANSI_GREEN + productImgUrl + ConsoleColors.ANSI_RESET);
                                    product.setImageUrl(productImgUrl);
                                    productRepository.save(product);
                                    //System.out.println(ConsoleColors.ANSI_GREEN + "Progressie: " + progressAmount +"%" + ConsoleColors.ANSI_RESET);
                                    last_vomar = System.currentTimeMillis();
                                } catch (Exception e) {

                                    System.out.println(ConsoleColors.ANSI_RED + "URL NIET GEVONDEN" + ConsoleColors.ANSI_RESET);
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        };


        System.out.println("running ah1");
        //ah1.start();
        System.out.println("running aldi");
        //aldi.start();
        System.out.println("running dirk");
        //dirk.start();
        System.out.println("running jumbo");
        //jumbo.start();
        System.out.println("running vomar");
        //vomar.start();
        System.out.println("running spar");
        //spar.start();
        System.out.println("running coop");
        coop.start();
        progress.start();
        last.start();
    }
}



