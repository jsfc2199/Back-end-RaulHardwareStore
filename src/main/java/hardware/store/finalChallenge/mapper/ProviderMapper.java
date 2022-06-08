package hardware.store.finalChallenge.mapper;

import hardware.store.finalChallenge.collection.Provider;
import hardware.store.finalChallenge.dto.ProviderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ProviderMapper {
    private final ModelMapper modelMapper;

    public ProviderMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ProviderDTO fromProviderToProviderDTO(Provider provider){
        return modelMapper.map(provider, ProviderDTO.class);
    }

    public Provider fromDTOtoProvider(ProviderDTO providerDTO){
        return modelMapper.map(providerDTO, Provider.class);
    }
}
