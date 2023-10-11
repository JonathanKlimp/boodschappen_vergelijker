package jonathan.jaron.boodschappenVergelijkerBackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class DataProcessingService {

    private final SupermarktRepository supermarktRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DataProcessingService(SupermarktRepository supermarktRepository, ProductRepository productRepository) {
        this.supermarktRepository = supermarktRepository;
        this.productRepository = productRepository;
    }

    public void processAndSaveData(File jsonData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Supermarkt> supermarkten = objectMapper.readValue(jsonData, new TypeReference<List<Supermarkt>>() {
        });
        System.out.println("processing and saving data");
        for (Supermarkt supermarkt : supermarkten) {
            for (Product product : supermarkt.getProducten()) {
                product.setSupermarkt(supermarkt);
            }
            System.out.println("saving data van: " + supermarkt.getNaam());
            supermarktRepository.save(supermarkt);

            productRepository.saveAll(supermarkt.getProducten());
        }
    }

    public void processAndUpdateData(File jsonData) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Supermarkt> supermarktenData = objectMapper.readValue(jsonData, new TypeReference<List<Supermarkt>>() {
        });
        for (int i = 1; i <= 12; i++) {
            Optional<Supermarkt> optionalSupermarkt = supermarktRepository.findById(i);

            if (optionalSupermarkt.isPresent()) {
                // Modify the fetched Supermarkt entity
                Supermarkt supermarkt = optionalSupermarkt.get();

                // Get the current list of products associated with the Supermarkt
                for (Product product : supermarkt.getProducten()) {
                    product.setSupermarkt(supermarkt);
                }
                // Modify the products as needed
                // Update product properties as needed
                productRepository.saveAll(supermarktenData.get(i -1).getProducten());

                // Save the updated Supermarkt entity (this will also cascade updates to associated products)
                supermarktRepository.save(supermarkt);

            }
        }

    }
}
