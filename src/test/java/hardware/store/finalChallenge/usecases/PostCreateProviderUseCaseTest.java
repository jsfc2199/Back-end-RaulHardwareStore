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
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;
import static reactor.core.publisher.Mono.when;

@SpringBootTest
class PostCreateProviderUseCaseTest {


    private PostCreateProviderUseCase postCreateProviderUseCase;

    @Autowired
    private ProviderMapper providerMapper;

    @Mock
    IProviderRepository providerRepository;

    @BeforeEach
    void setUp(){
        postCreateProviderUseCase = new PostCreateProviderUseCase(providerRepository, providerMapper);
    }

    @Test
    public void createProviderTest(){
        Provider provider = new Provider("1","juan","321654987","asdf1234");

        ProviderDTO providerDTO = new ProviderDTO();

        providerDTO.setId(provider.getId());
        providerDTO.setName(provider.getName());
        providerDTO.setNumber(provider.getNumber());
        providerDTO.setPassport(provider.getPassport());

        when(providerRepository.save(provider)).thenReturn(Mono.just(providerDTO));

        Mono<ProviderDTO> publisher = postCreateProviderUseCase.createProvider(providerDTO);

        StepVerifier
                .create(publisher)
                .expectNext(providerDTO)
                .verifyComplete();

        Mockito.verify(providerRepository).save(provider);
    }

}