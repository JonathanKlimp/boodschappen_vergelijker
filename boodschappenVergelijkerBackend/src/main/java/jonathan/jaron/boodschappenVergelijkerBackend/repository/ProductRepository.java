package jonathan.jaron.boodschappenVergelijkerBackend.repository;

import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository  extends JpaRepository<ProductDto,Integer> {
    @Query("SELECT p FROM ProductDto p LEFT JOIN p.supermarkt s WHERE p.naam LIKE :naam")
    List<ProductDto> findProductByNaam(@Param("naam") String naam);

    // find by naam voor het toevoegen aan gebruiker.
    // en een remove (gewoon een rmeove uit de lijst?)
}
