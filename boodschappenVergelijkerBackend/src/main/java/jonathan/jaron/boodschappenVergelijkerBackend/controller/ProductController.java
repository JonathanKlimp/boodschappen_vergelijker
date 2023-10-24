package jonathan.jaron.boodschappenVergelijkerBackend.controller;

import jonathan.jaron.boodschappenVergelijkerBackend.mapper.ProductMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import jonathan.jaron.boodschappenVergelijkerBackend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @CrossOrigin(origins = "*")
    @PostMapping("/zoek")
    List<Product> findByNaamLike(@RequestBody String naam){

        System.out.println(naam);
        // is true maar er word geen illegalargument exception gethrowed??
        // maar er komt wel een 400 bad request als response
        System.out.println(naam.equals("undefined"));
        if(naam == null) {
            throw new IllegalArgumentException("cannot search null");
        } else if (naam.equals("undefined")) {
            throw new IllegalArgumentException("cannot search null");
        }
        else {
            List<ProductDto> resultDto = productRepository.findProductByNaam("%"+naam+"%");
            List<Product> result = productService.mapToProduct(resultDto);
            System.out.println(result);
            return result;
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public String exceptionHandler(IllegalArgumentException ex) {
        return "error: " + ex.getMessage();
    }
}
