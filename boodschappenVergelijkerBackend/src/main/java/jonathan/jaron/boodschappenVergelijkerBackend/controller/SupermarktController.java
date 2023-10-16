package jonathan.jaron.boodschappenVergelijkerBackend.controller;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.service.SupermarktService;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SupermarktController {
    @Autowired
    SupermarktRepository supermarktRepository;

    @Autowired
    SupermarktService supermarktService;
    @GetMapping("/supermarkt")
    List<Supermarkt> findAll(){
        return supermarktService.getSupermarkten(supermarktRepository.findAll());
    }
}
