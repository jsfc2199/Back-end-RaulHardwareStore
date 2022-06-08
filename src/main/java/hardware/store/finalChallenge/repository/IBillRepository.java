package hardware.store.finalChallenge.repository;

import hardware.store.finalChallenge.collection.Bill;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBillRepository extends ReactiveMongoRepository<Bill, String> {
}
