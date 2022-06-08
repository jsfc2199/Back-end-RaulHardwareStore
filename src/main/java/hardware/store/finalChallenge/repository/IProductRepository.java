package hardware.store.finalChallenge.repository;

import hardware.store.finalChallenge.collection.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface IProductRepository extends ReactiveMongoRepository<Product, String> {
}
