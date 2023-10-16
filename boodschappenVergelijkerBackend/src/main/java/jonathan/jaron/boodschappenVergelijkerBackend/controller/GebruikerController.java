package jonathan.jaron.boodschappenVergelijkerBackend.controller;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Gebruiker;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GebruikerController {

    @Autowired
    GebruikerRepository gebruikerRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

//    @PostMapping("/gebruiker")
//    Gebruiker save(@RequestBody Gebruiker gebruiker){ return gebruikerRepository.save(gebruiker);}
    @GetMapping("/gebruiker")
    List<Gebruiker> findAll(){return gebruikerRepository.findAll();}

    @PostMapping("/registreer")
    public Gebruiker save(@RequestBody Gebruiker gebruiker) {
        System.out.println("in registreer user");
        System.out.println(gebruiker.getWachtwoord());
        gebruiker.setWachtwoord(passwordEncoder.encode(gebruiker.getWachtwoord()));
        System.out.println(gebruiker.getWachtwoord());

        return gebruikerRepository.save(gebruiker);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Gebruiker gebruiker) {
        // Implement user authentication logic, validate credentials
        // Return a success or error response, possibly with a JWT token for authentication
        return null;
    }
}
