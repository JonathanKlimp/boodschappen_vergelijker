package jonathan.jaron.boodschappenVergelijkerBackend.controller;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Gebruiker;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.GebruikerRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.service.WachtwoordEncoder;
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

    @PostMapping("/gebruiker")
    Gebruiker save(@RequestBody Gebruiker gebruiker){ return gebruikerRepository.save(gebruiker);}
    @GetMapping("/gebruiker")
    List<Gebruiker> findAll(){return gebruikerRepository.findAll();}

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody Gebruiker gebruiker) {

        passwordEncoder.encode("j");
        gebruiker.getWachtwoord();
//        User user = new User();
//        user.setFirstName(accountDto.getFirstName());
//        user.setLastName(accountDto.getLastName());
//
//        user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
//
//        user.setEmail(accountDto.getEmail());
//        user.setRole(new Role(Integer.valueOf(1), user));
//        return repository.save(user);
        return null;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Gebruiker gebruiker) {
        // Implement user authentication logic, validate credentials
        // Return a success or error response, possibly with a JWT token for authentication
        return null;
    }
}
