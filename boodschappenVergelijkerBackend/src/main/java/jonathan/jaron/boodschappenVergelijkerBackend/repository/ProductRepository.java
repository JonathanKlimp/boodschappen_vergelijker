package jonathan.jaron.boodschappenVergelijkerBackend.repository;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository  extends JpaRepository<Product,Integer> {
    @Query("SELECT p FROM Product p JOIN p.supermarkt s WHERE p.naam LIKE :naam")
    List<Product> findProductByNaam(@Param("naam") String naam);

}
