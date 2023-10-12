package jonathan.jaron.boodschappenVergelijkerBackend.controller;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;
    @PostMapping("/product")
    Product save(@RequestBody Product product){ return productRepository.save(product);}
    @GetMapping("/product")
    List<Product> findAll(){return productRepository.findAll();}

    @PostMapping("/zoek")
    List<Product> findByNaamLike(@RequestBody String naam){
        List<Product> result = productRepository.findByNaamLike("%"+naam+"%");
        return (result);
    }
}
