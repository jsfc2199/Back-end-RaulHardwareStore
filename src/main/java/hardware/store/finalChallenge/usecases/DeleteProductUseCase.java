package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.mapper.ProductMapper;
import hardware.store.finalChallenge.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class DeleteProductUseCase {
    private final IProductRepository productRepository;
    private final ProductMapper productMapper;

    public DeleteProductUseCase(IProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Mono<Void> deleteProductId(String id){
        return productRepository.deleteById(id);
    }
}
