package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.dto.ProductDTO;
import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.mapper.ProviderMapper;
import hardware.store.finalChallenge.repository.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetProviderUseCase {
    public final IProviderRepository repository;
    public final ProviderMapper providerMapper;

    public GetProviderUseCase(IProviderRepository repository, ProviderMapper providerMapper) {
        this.repository = repository;
        this.providerMapper = providerMapper;
    }

    public Flux<ProviderDTO> getProviders(){
        return repository.findAll().map(providerMapper::fromProviderToProviderDTO);
    }
}
