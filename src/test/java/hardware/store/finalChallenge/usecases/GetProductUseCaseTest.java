package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Product;
import hardware.store.finalChallenge.dto.ProductDTO;
import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.mapper.ProductMapper;
import hardware.store.finalChallenge.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetProductUseCaseTest {
    private GetProductUseCase getProductUseCase;

    @Autowired
    private ProductMapper productMapper;

    @Mock
    IProductRepository productRepository;

    @BeforeEach
    void setUp(){
        getProductUseCase = new GetProductUseCase(productRepository,productMapper);
    }

    @Test
    void getProductTest(){
        ProviderDTO providerDTO = new ProviderDTO("2","juan","1564865","3521485674");
        Product product = new Product("1",5,50,"hammer","big hammer",30,50000, providerDTO);

        ProviderDTO providerDTO2 = new ProviderDTO("3","franco","4984135","gre168g4er8");
        Product product2 = new Product("2",6,51,"screw driver","big screw driver",31,55000, providerDTO2);

        Mockito.when(productRepository.findAll()).thenReturn(Flux.just(product,product2));
        Flux<ProductDTO> flux = getProductUseCase.getProducts();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(productRepository).findAll();
    }
}