package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Product;
import hardware.store.finalChallenge.dto.ProductDTO;
import hardware.store.finalChallenge.dto.ProviderDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PutProductUseCaseTest {
    @MockBean
    private PutProductUseCase putProductUseCase;

    @Test
    public void updateProductTest(){
        ProviderDTO providerDTO = new ProviderDTO("15","Carlos","123456789","987654321");

        Product productUpdated = new Product("5",5,100,"Hammer", "Heavy hammer, black color",30,50000, providerDTO);

        ProductDTO productDTO = new ProductDTO(productUpdated.getId(),productUpdated.getMinUnits(),productUpdated.getMaxUnits(),productUpdated.getProductName(),
                productUpdated.getDescription(),productUpdated.getUnitsAvailable(),productUpdated.getPrice(),productUpdated.getProvider());

        StepVerifier.create(Mono.just(Mockito.when(putProductUseCase.updateProduct(productDTO))
                .thenReturn(Mono.just(productDTO)))).expectComplete();
    }
}