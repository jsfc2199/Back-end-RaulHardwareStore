package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.collection.Provider;
import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.repository.IProviderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostCreateProviderUseCaseTest {

    @MockBean
    private PostCreateProviderUseCase postCreateProviderUseCase;

    @Mock
    IProviderRepository providerRepository;

    @Test
    public void createProviderTest(){
        Provider provider = new Provider("1","juan","321654987","asdf1234");

        ProviderDTO providerDTO = new ProviderDTO();

        providerDTO.setId(provider.getId());
        providerDTO.setName(provider.getName());
        providerDTO.setNumber(provider.getNumber());
        providerDTO.setPassport(provider.getPassport());

        StepVerifier.create(Mono.just(Mockito.when(postCreateProviderUseCase.createProvider(providerDTO))
                .thenReturn(Mono.just(providerDTO)))).expectComplete();
    }
}