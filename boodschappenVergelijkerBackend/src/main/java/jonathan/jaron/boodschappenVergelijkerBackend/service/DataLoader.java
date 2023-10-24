package jonathan.jaron.boodschappenVergelijkerBackend.service;

import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;

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
    public void run(String... args) throws IOException {
        try {
            if (productRepository.count() == 0 || supermarktRepository.count() == 0) {
                processingService.processAndSaveData(new File(JSON_FILE_PATH));
            }
            //imageGetterService.getImages();
        } catch (IOException e) {
            throw new IOException("file not found");
        }

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
