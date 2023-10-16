package jonathan.jaron.boodschappenVergelijkerBackend.controller;

import jonathan.jaron.boodschappenVergelijkerBackend.mapper.ProductMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @CrossOrigin(origins = "*")
    @PostMapping("/zoek")
    List<Product> findByNaamLike(@RequestBody String naam){
        List<ProductDto> resultDto = productRepository.findProductByNaam("%"+naam+"%");
        List<Product> result = productService.mapToProduct(resultDto);
        System.out.println(result);
        return result;
    }
}
