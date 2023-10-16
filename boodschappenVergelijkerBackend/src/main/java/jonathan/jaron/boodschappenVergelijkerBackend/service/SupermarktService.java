package jonathan.jaron.boodschappenVergelijkerBackend.service;

import jonathan.jaron.boodschappenVergelijkerBackend.mapper.SupermarktMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import jonathan.jaron.boodschappenVergelijkerBackend.model.SupermarktDto;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.SupermarktRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SupermarktService {

    public List<Supermarkt> getSupermarkten(List<SupermarktDto> supermarktDtoList) {
        List<Supermarkt> supermarkten = new ArrayList<>();
        for (SupermarktDto supermarktDto: supermarktDtoList ) {
            Supermarkt supermarkt = SupermarktMapper.toSupermarkt(supermarktDto);
            supermarkten.add(supermarkt);
        }
        return supermarkten;
    }
}
