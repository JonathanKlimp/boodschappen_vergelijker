package jonathan.jaron.boodschappenVergelijkerBackend.repository;

import jonathan.jaron.boodschappenVergelijkerBackend.model.SupermarktDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupermarktRepository extends JpaRepository<SupermarktDto,Integer> {
    List<SupermarktDto> findAll();
}
