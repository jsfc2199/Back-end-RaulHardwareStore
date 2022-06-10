package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Provider;
import hardware.store.finalChallenge.collection.Receipt;
import hardware.store.finalChallenge.dto.ReceiptDTO;
import hardware.store.finalChallenge.repository.IReceiptRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostCreateReceiptUseCaseTest {

    @MockBean
    private PostCreateReceiptUseCase postCreateReceiptUseCase;

    @Mock
    IReceiptRepository receiptRepository;

    @Test
    public void createReceiptTest(){
        Provider provider = new Provider("1","juan","321654987","asdf1234");

        Receipt receipt = new Receipt("2","A lot of hammer with dark blue color bought",15,"4","10/06/2022", provider);

        ReceiptDTO receiptDTO = new ReceiptDTO(receipt.getId(),receipt.getDescription(),receipt.getUnits(),receipt.getProductId(),receipt.getDate(),receipt.getProvider());

        StepVerifier.create(Mono.just(Mockito.when(postCreateReceiptUseCase.createReceipt(receiptDTO))
                .thenReturn(Mono.just(receiptDTO)))).expectComplete();

    }
}