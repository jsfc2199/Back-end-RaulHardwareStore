package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.dto.BillDTO;
import hardware.store.finalChallenge.mapper.BillMapper;
import hardware.store.finalChallenge.repository.IBillRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetBillUseCase {
    private final IBillRepository repository;
    private final BillMapper billMapper;

    public GetBillUseCase(IBillRepository repository, BillMapper billMapper) {
        this.repository = repository;
        this.billMapper = billMapper;
    }

    public Flux<BillDTO> getBills(){
        return repository.findAll().map(billMapper::fromBillToBillDTO);
    }
}
