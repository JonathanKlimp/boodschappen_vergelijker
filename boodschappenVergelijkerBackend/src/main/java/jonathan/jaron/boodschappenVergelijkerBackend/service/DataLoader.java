package jonathan.jaron.boodschappenVergelijkerBackend.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    private final SupermarktRepository supermarktRepository;
    private final ProductRepository productRepository;

    @Autowired
    public DataLoader(SupermarktRepository supermarktRepository, ProductRepository productRepository) {
        this.supermarktRepository = supermarktRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0 || supermarktRepository.count() == 0) {

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
    }
}

