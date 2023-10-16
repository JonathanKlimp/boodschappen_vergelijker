package jonathan.jaron.boodschappenVergelijkerBackend.mapper;

import jonathan.jaron.boodschappenVergelijkerBackend.model.Product;
import jonathan.jaron.boodschappenVergelijkerBackend.model.ProductDto;
import jonathan.jaron.boodschappenVergelijkerBackend.model.Supermarkt;
import jonathan.jaron.boodschappenVergelijkerBackend.model.SupermarktDto;

import java.util.ArrayList;
import java.util.List;


public class SupermarktMapper {

    public static SupermarktDto toSupermarktDto(Supermarkt supermarkt) {
        SupermarktDto supermarktDto = new SupermarktDto();
        supermarktDto.setId(supermarkt.getId());
        supermarktDto.setNaam(supermarkt.getNaam());
        supermarktDto.setUrl(supermarkt.getUrl());
        supermarktDto.setLogo(supermarkt.getLogo());
        supermarktDto.setMerkNaam(supermarkt.getMerkNaam());
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product: supermarkt.getProducten()) {
            productDtos.add(ProductMapper.toProductDto(product));
        }
        supermarktDto.setProducten(productDtos);
        return supermarktDto;
    }

    public static Supermarkt toSupermarkt(SupermarktDto supermarktDto) {
        Supermarkt supermarkt = new Supermarkt();
        supermarkt.setId(supermarktDto.getId());
        supermarkt.setNaam(supermarktDto.getNaam());
        supermarkt.setUrl(supermarktDto.getUrl());
        supermarkt.setLogo(supermarktDto.getLogo());
        supermarkt.setMerkNaam(supermarktDto.getMerkNaam());
        return supermarkt;
    }
}
