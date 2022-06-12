package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Bill;
import hardware.store.finalChallenge.collection.Provider;
import hardware.store.finalChallenge.collection.Receipt;
import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.dto.ReceiptDTO;
import hardware.store.finalChallenge.mapper.ReceiptMapper;
import hardware.store.finalChallenge.repository.IBillRepository;
import hardware.store.finalChallenge.repository.IReceiptRepository;
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
class GetReceiptUseCaseTest {
    private GetReceiptUseCase getReceiptUseCase;

    @Autowired
    private ReceiptMapper receiptMapper;

    @Mock
    IReceiptRepository receiptRepository;

    @BeforeEach
    void setUp(){
        getReceiptUseCase = new GetReceiptUseCase(receiptRepository, receiptMapper);
    }

    @Test
    void getReceiptTest(){
        Provider provider = new Provider("2","juan","1564865","3521485674");
        Receipt receipt = new Receipt("5","A bunch of products", 5,"5489123","15/05/2022 15:00:00",provider);

        Receipt receipt2 = new Receipt("6","description", 10,"wef984ewfefa","16/05/2022 14:58:21",provider);

        Mockito.when(receiptRepository.findAll()).thenReturn(Flux.just(receipt,receipt2));
        Flux<ReceiptDTO> flux = getReceiptUseCase.getReceipts();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(receiptRepository).findAll();
    }
}