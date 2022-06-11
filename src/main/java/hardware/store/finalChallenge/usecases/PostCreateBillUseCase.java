package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.dto.BillDTO;
import hardware.store.finalChallenge.mapper.BillMapper;
import hardware.store.finalChallenge.repository.IBillRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostCreateBillUseCase {
    private final IBillRepository repository;
    private final BillMapper billMapper;

    public PostCreateBillUseCase(IBillRepository repository, BillMapper billMapper) {
        this.repository = repository;
        this.billMapper = billMapper;
    }

    public Mono<BillDTO> createBill(BillDTO billDTO){
        return repository.save(billMapper.fromDTOtoBill(billDTO))
                .map(billMapper::fromBillToBillDTO);
    }
}
