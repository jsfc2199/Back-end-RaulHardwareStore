package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Bill;
import hardware.store.finalChallenge.collection.Product;
import hardware.store.finalChallenge.dto.BillDTO;
import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.mapper.BillMapper;
import hardware.store.finalChallenge.repository.IBillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetBillUseCaseTest {
    private GetBillUseCase getBillUseCase;

    @Autowired
    private BillMapper billMapper;

    @Mock
    IBillRepository billRepository;

    @BeforeEach
    void setUp(){
        getBillUseCase = new GetBillUseCase(billRepository,billMapper);
    }

    @Test
    void getBillTest(){
        ProviderDTO providerDTO = new ProviderDTO("15","Carlos","123456789","987654321");
        Product product = new Product("5",5,100,"Hammer", "Heavy hammer, black color",30,50000, providerDTO);

        ProviderDTO providerDTO2 = new ProviderDTO("16","Pedro","1564897","165478964");
        Product product2 = new Product("6",8,40,"product 2", "description 2",10,30000, providerDTO2);

        List<Product> productsBought = new ArrayList<>();
        productsBought.add(product);
        productsBought.add(product2);

        Bill bill = new Bill("1","Client1","Seller1","11/06/2022 15:00:00",productsBought,80000.0);

        Mockito.when(billRepository.findAll()).thenReturn(Flux.just(bill));
        Flux<BillDTO> flux = getBillUseCase.getBills();

        StepVerifier.create(flux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(billRepository).findAll();

    }
}