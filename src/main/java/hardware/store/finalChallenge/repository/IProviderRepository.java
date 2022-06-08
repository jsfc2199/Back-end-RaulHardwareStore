package hardware.store.finalChallenge.repository;

import hardware.store.finalChallenge.collection.Provider;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProviderRepository extends ReactiveMongoRepository<Provider, String> {
}
