package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.dto.ProductDTO;
import hardware.store.finalChallenge.mapper.ProductMapper;
import hardware.store.finalChallenge.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostCreateProductUseCase {
    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    public PostCreateProductUseCase(IProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Mono<ProductDTO> createProduct(ProductDTO productDTO){
        return productRepository.save(productMapper.fromDTOtoProduct(productDTO))
                .map(productMapper::fromProductToProductDTO);
    }
}
