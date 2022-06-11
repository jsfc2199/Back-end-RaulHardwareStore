package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Product;
import hardware.store.finalChallenge.dto.BillDTO;
import hardware.store.finalChallenge.dto.ProviderDTO;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PostCreateBillUseCaseTest {
    @MockBean
    private PostCreateBillUseCase postCreateBillUseCase;

    @Test
    public void createBillTest(){
        ProviderDTO providerDTO = new ProviderDTO("15","Carlos","123456789","987654321");
        Product product = new Product("5",5,100,"Hammer", "Heavy hammer, black color",30,50000, providerDTO);

        ProviderDTO providerDTO2 = new ProviderDTO("16","Pedro","1564897","165478964");
        Product product2 = new Product("6",8,40,"product 2", "description 2",10,30000, providerDTO2);

        List<Product> productsBought = new ArrayList<>();
        productsBought.add(product);
        productsBought.add(product2);

        BillDTO billDTO = new BillDTO("1","Client1","Seller1","11/06/2022 15:00:00",productsBought,80000.0);

        StepVerifier.create(Mono.just(Mockito.when(postCreateBillUseCase.createBill(billDTO)).thenReturn(Mono.just(billDTO)))).expectComplete();
    }
}