package hardware.store.finalChallenge.repository;

import hardware.store.finalChallenge.collection.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProviderRepository extends MongoRepository<Provider, String> {
}
