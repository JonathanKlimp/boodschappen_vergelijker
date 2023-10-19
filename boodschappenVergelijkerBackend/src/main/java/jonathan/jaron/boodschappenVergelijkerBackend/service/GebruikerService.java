package jonathan.jaron.boodschappenVergelijkerBackend.service;

//import jonathan.jaron.boodschappenVergelijkerBackend.mapper.GebruikerMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Gebruiker;
import jonathan.jaron.boodschappenVergelijkerBackend.model.GebruikerDto;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.GebruikerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GebruikerService {

    @Autowired
    GebruikerRepository gebruikerRepository;

//    public Gebruiker save(Gebruiker gebruiker) {
//        GebruikerDto gebruikerDto = gebruikerRepository.save(GebruikerMapper.toGebruikerDto(gebruiker));
//        return GebruikerMapper.toGebruiker(gebruikerDto);
//    }

    public List<Gebruiker> findAll() {
        List<Gebruiker> gebruikers = new ArrayList<>();

        List<Gebruiker> gebruikerDtos = gebruikerRepository.findAll();
//        for (GebruikerDto gebruikerDto: gebruikerDtos) {
//            gebruikers.add(GebruikerMapper.toGebruiker(gebruikerDto));
//        }

        return gebruikerRepository.findAll();
    }

    public boolean verifieerGebruiker(String gebruikersnaam, String wachtwoord) {
        Gebruiker gebruiker = this.gebruikerRepository.findByGebruikersnaam(gebruikersnaam);
        System.out.println(gebruiker);
        if(gebruiker != null && gebruiker.getGebruikersnaam().equals(gebruikersnaam) && gebruiker.getWachtwoord().equals(wachtwoord)){
            return true;
        }else {
            return false;
        }
    }
}
