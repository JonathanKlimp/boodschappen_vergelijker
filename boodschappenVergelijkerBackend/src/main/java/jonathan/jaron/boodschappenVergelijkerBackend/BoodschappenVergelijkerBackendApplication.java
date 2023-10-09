package jonathan.jaron.boodschappenVergelijkerBackend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.controller.SupermarktController;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BoodschappenVergelijkerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoodschappenVergelijkerBackendApplication.class, args);
    }

    //[{"n":"ah","d":[{"n":"'t IJ Kadoosje bierpakket","l":"wi394045/t-ij-kadoosje-bierpakket","p":17.99,"s":"6 x 0,33 l"}],"u":"https://www.ah.nl/producten/product/","c":"AH","i":"https://www.ah.nl/favicon.ico"}}
}

