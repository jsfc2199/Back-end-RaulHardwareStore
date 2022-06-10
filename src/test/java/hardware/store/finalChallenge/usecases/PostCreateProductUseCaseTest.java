package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Product;
import hardware.store.finalChallenge.dto.ProductDTO;
import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostCreateProductUseCaseTest {

    @MockBean
    private PostCreateProductUseCase postCreateProductUseCase;

    @Mock
    IProductRepository productRepository;

    @Test
    public void createProductTest(){
        ProviderDTO providerDTO = new ProviderDTO("15","Carlos","123456789","987654321");

        Product product = new Product("5",5,100,"Hammer", "Heavy hammer, black color",30,50000, providerDTO);

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setMinUnits(product.getMinUnits());
        productDTO.setMaxUnits(product.getMaxUnits());
        productDTO.setProductName(product.getProductName());
        productDTO.setDescription(product.getDescription());
        productDTO.setUnitsAvailable(product.getUnitsAvailable());
        productDTO.setPrice(product.getPrice());
        productDTO.setProvider(product.getProvider());

        StepVerifier.create(Mono.just(Mockito.when(postCreateProductUseCase.createProduct(productDTO))
                .thenReturn(Mono.just(productDTO)))).expectComplete();
    }
}