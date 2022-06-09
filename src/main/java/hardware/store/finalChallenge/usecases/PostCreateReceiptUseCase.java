package hardware.store.finalChallenge.usecases;

import hardware.store.finalChallenge.dto.ReceiptDTO;
import hardware.store.finalChallenge.mapper.ReceiptMapper;
import hardware.store.finalChallenge.repository.IReceiptRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostCreateReceiptUseCase {
    private final IReceiptRepository receiptRepository;
    private final ReceiptMapper receiptMapper;

    public PostCreateReceiptUseCase(IReceiptRepository receiptRepository, ReceiptMapper receiptMapper) {
        this.receiptRepository = receiptRepository;
        this.receiptMapper = receiptMapper;
    }

    public Mono<ReceiptDTO> createReceipt(ReceiptDTO receiptDTO){
        return receiptRepository.save(receiptMapper.fromDTOtoReceipt(receiptDTO)).map(receiptMapper::fromReceiptToReceiptDTO);
    }
}
