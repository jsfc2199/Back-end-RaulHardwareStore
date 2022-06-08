package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.mapper.ProviderMapper;
import hardware.store.finalChallenge.repository.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostCreateProviderUseCase {
    private final IProviderRepository repository;
    private final ProviderMapper providerMapper;

    public PostCreateProviderUseCase(IProviderRepository repository, ProviderMapper providerMapper) {
        this.repository = repository;
        this.providerMapper = providerMapper;
    }

    public Mono<ProviderDTO> createProvider(ProviderDTO providerDTO){
        return repository.save(providerMapper.fromDTOtoProvider(providerDTO)).map(providerMapper::fromProviderToProviderDTO);
    }
}
