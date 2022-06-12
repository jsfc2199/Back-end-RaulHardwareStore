package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Provider;
import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.mapper.ProviderMapper;
import hardware.store.finalChallenge.repository.IProviderRepository;
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
class GetProviderUseCaseTest {

    private GetProviderUseCase getProviderUseCase;

    @Autowired
    private ProviderMapper providerMapper;

    @Mock
    IProviderRepository providerRepository;

    @BeforeEach
    void setUp(){
        getProviderUseCase = new GetProviderUseCase(providerRepository,providerMapper);
    }

    @Test
    void getProviderUseCase(){
        Provider provider = new Provider("1","Juan","123548","987465451");
        Provider provider2 = new Provider("2","Franco","456168798","3210564fgasd");

        Mockito.when(providerRepository.findAll()).thenReturn(Flux.just(provider,provider2));
        Flux<ProviderDTO> flux = getProviderUseCase.getProviders();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(providerRepository).findAll();
    }

}