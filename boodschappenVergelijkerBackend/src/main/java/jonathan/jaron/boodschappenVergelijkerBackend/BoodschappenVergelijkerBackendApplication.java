package jonathan.jaron.boodschappenVergelijkerBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class BoodschappenVergelijkerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoodschappenVergelijkerBackendApplication.class, args);
    }
}

