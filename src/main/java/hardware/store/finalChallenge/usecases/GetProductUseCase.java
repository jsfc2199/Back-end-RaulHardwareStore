package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.dto.ProductDTO;
import hardware.store.finalChallenge.mapper.ProductMapper;
import hardware.store.finalChallenge.repository.IProductRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetProductUseCase {
    private final IProductRepository repository;
    private final ProductMapper productMapper;

    public GetProductUseCase(IProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    public Flux<ProductDTO> getProducts(){
        return repository.findAll().map(productMapper::fromProductToProductDTO);
    }
}
