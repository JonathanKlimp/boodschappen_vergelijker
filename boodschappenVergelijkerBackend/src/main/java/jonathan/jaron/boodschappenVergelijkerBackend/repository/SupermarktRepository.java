package jonathan.jaron.boodschappenVergelijkerBackend.repository;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SupermarktRepository extends JpaRepository<Supermarkt,Integer> {
    List<Supermarkt> findAll();
}
