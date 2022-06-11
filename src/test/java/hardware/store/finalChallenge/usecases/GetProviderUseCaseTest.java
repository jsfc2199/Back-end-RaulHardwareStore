package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Provider;
import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.repository.IProviderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetProviderUseCaseTest {


    private GetProviderUseCase getProviderUseCase;

    @MockBean
    private PostCreateProviderUseCase postCreateProviderUseCase;

    @Mock
    IProviderRepository providerRepository;

    @Test
    public void getProviderTest(){

    }

}