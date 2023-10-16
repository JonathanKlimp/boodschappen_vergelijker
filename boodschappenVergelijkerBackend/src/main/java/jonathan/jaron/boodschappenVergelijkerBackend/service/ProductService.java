package jonathan.jaron.boodschappenVergelijkerBackend.service;

import jonathan.jaron.boodschappenVergelijkerBackend.mapper.ProductMapper;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;
import jonathan.jaron.boodschappenVergelijkerBackend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    public List<Product> mapToProduct(List<ProductDto> productDtos) {
        List<Product> producten = new ArrayList<>();
        for (ProductDto productDto: productDtos) {
            Product product = ProductMapper.toProduct(productDto);
            producten.add(product);
        }
        return producten;
    }
}
