package jonathan.jaron.boodschappenVergelijkerBackend.repository;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupermarktRepository extends JpaRepository<Supermarkt,Integer> {
}
