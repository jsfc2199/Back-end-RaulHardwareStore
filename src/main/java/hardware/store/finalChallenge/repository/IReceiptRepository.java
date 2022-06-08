package hardware.store.finalChallenge.repository;

import hardware.store.finalChallenge.collection.Receipt;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IReceiptRepository extends MongoRepository<Receipt, String> {
}
