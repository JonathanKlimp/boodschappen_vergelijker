package jonathan.jaron.boodschappenVergelijkerBackend.service;

import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class DataLoader implements CommandLineRunner {

    private static final String JSON_FILE_URL = "https://raw.githubusercontent.com/supermarkt/checkjebon/main/data/supermarkets.json";
    private static final String JSON_FILE_PATH = "src/main/resources/data/supermarkets.json";

    private final DataDownloaderService downloaderService;
    private final DataProcessingService processingService;

    private final ImageGetterService imageGetterService;
    private final SupermarktRepository supermarktRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DataLoader(DataDownloaderService downloaderService, DataProcessingService processingService, ImageGetterService imageGetterService, SupermarktRepository supermarktRepository, ProductRepository productRepository) {
        this.downloaderService = downloaderService;
        this.processingService = processingService;
        this.imageGetterService = imageGetterService;
        this.supermarktRepository = supermarktRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0 || supermarktRepository.count() == 0) {

            processingService.processAndSaveData(new File(JSON_FILE_PATH));


            ObjectMapper objectMapper = new ObjectMapper();
            List<Supermarkt> supermarkten = objectMapper.readValue(new File("src/main/resources/data/supermarkets.json"), new TypeReference<List<Supermarkt>>() {
            });
            for (Supermarkt supermarkt : supermarkten) {
                for (Product product : supermarkt.getProducten()) {
                    product.setSupermarkt(supermarkt);
                }
                supermarktRepository.save(supermarkt);
                productRepository.saveAll(supermarkt.getProducten());
            }

        }
        //imageGetterService.getImages();
    }

//    @Scheduled(initialDelay = 60 * 1000, fixedRate = 3 * 60 * 60 * 1000) // 3 hours
//    public void updateData() {
//        try {
//            // Download JSON data using DataDownloaderService
//            String jsonData = downloaderService.downloadJsonData(JSON_FILE_URL);
//            // Process and save data using DataProcessingService
//            File tempFile = File.createTempFile("supermarkets", ".json");
//
//            // Write the JSON data to the temporary file
//            FileUtils.writeStringToFile(tempFile, jsonData, StandardCharsets.UTF_8);
//
//            processingService.processAndUpdateData(tempFile);
//        } catch (IOException e) {
//            // Handle exceptions
//            e.printStackTrace();
//        }
//    }
}

