package jonathan.jaron.boodschappenVergelijkerBackend.controller;

import jonathan.jaron.boodschappenVergelijkerBackend.mapper.ProductMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Gebruiker;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.GebruikerRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.service.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GebruikerController {

    @Autowired
    GebruikerService gebruikerService;

    @Autowired
    GebruikerRepository gebruikerRepository;

    @GetMapping("/gebruiker")
    List<Gebruiker> findAll(){
        return gebruikerService.findAll();
    }

    @PostMapping("/registreer")
    public Gebruiker save(@RequestBody Gebruiker gebruiker) {
        System.out.println("in registreer user");
        System.out.println(gebruiker.getWachtwoord());
        // TODO: implement password encoder
//        gebruiker.setWachtwoord(passwordEncoder.encode(gebruiker.getWachtwoord()));
        System.out.println(gebruiker.getWachtwoord());

//        return gebruikerService.save(gebruiker);
        return gebruikerRepository.save(gebruiker);
    }

    @PostMapping("/toevoegen")
    public Gebruiker add(@RequestBody Gebruiker gebruiker) {
        Gebruiker gebruiker1 = gebruikerRepository.findByGebruikersnaam(gebruiker.getGebruikersnaam());
        
        gebruiker1.addProduct(ProductMapper.toListProductDto(gebruiker.getProducten()));

        return gebruiker1;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Gebruiker gebruiker) {
        // Implement user authentication logic, validate credentials
        // Return a success or error response, possibly with a JWT token for authentication
        return null;
    }
}
