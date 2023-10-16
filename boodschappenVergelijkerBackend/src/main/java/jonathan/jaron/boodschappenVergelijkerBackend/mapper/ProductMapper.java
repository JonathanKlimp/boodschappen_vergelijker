package jonathan.jaron.boodschappenVergelijkerBackend.mapper;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;

public class ProductMapper {

    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setNaam(product.getNaam());
        productDto.setPrijs(product.getPrijs());
        productDto.setUrl(product.getUrl());
        productDto.setInhoud(product.getInhoud());
        productDto.setImageUrl(product.getImageUrl());
        productDto.setSupermarkt(productDto.getSupermarkt());

        return productDto;
    }

    public static Product toProduct(ProductDto productDto) {
        Product product = new Product();
        product.setId(productDto.getId());
        product.setNaam(productDto.getNaam());
        product.setPrijs(productDto.getPrijs());
        product.setUrl(productDto.getUrl());
        product.setInhoud(productDto.getInhoud());
        product.setImageUrl(productDto.getImageUrl());
        product.setSupermarkt(SupermarktMapper.toSupermarkt(productDto.getSupermarkt()));

        return product;
    }


}
