package hardware.store.finalChallenge.mapper;

import hardware.store.finalChallenge.collection.Product;
import hardware.store.finalChallenge.dto.ProductDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ProductMapper {
    private final ModelMapper modelMapper;

    public ProductMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProductDTO fromProductToProductDTO(Product product){
        return modelMapper.map(product, ProductDTO.class);
    }

    public Product fromDTOtoProduct(ProductDTO productDTO){
        return modelMapper.map(productDTO, Product.class);
    }
}
