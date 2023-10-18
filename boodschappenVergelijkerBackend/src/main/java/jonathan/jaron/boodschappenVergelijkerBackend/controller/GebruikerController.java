package jonathan.jaron.boodschappenVergelijkerBackend.controller;

import jakarta.servlet.http.HttpSession;
import jonathan.jaron.boodschappenVergelijkerBackend.mapper.ProductMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Gebruiker;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.GebruikerRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.service.GebruikerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GebruikerController {

    @Autowired
    GebruikerService gebruikerService;

    @Autowired
    GebruikerRepository gebruikerRepository;

    @Autowired
    ProductRepository productRepository;

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

        //gebruiker1.addProduct();

        return gebruiker1;
    }

    @RequestMapping("/login")
    public String login(HttpSession session, @RequestBody Gebruiker gebruiker) {
        session.setAttribute(gebruiker.getGebruikersnaam(), gebruiker);
        return "You have logged in successfully"; // you can also redirect instead, do as you wish
    }
}
