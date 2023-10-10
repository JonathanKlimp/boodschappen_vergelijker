package jonathan.jaron.boodschappenVergelijkerBackend;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class BoodschappenVergelijkerBackendApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(BoodschappenVergelijkerBackendApplication.class, args);
	}


	private static void jSonToDatabase() throws IOException {

	}

}
