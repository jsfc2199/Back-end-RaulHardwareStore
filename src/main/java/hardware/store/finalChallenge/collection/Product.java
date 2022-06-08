package hardware.store.finalChallenge.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id = UUID.randomUUID().toString();
    private Integer minUnits;
    private Integer maxUnits;
    private String productName;
    private String description;
    private String unitsAvailable;
    private Integer price;
    private String provider;

}
