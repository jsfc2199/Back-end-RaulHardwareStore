package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.dto.ReceiptDTO;
import hardware.store.finalChallenge.mapper.ReceiptMapper;
import hardware.store.finalChallenge.repository.IReceiptRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetReceiptUseCase {
    private final IReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    public GetReceiptUseCase(IReceiptRepository receiptRepository, ReceiptMapper receiptMapper) {
        this.receiptRepository = receiptRepository;
        this.receiptMapper = receiptMapper;
    }

    public Flux<ReceiptDTO> getReceipts(){
        return receiptRepository.findAll().map(receiptMapper::fromReceiptToReceiptDTO);
    }
}
