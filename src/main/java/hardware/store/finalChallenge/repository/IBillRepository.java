package hardware.store.finalChallenge.repository;

import hardware.store.finalChallenge.collection.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IBillRepository extends ReactiveMongoRepository<Bill, String> {
}
