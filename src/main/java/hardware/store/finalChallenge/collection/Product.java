package hardware.store.finalChallenge.collection;

import hardware.store.finalChallenge.dto.ProviderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private Integer minUnits;
    private Integer maxUnits;
    private String productName;
    private String description;
    private Integer unitsAvailable;
    private Integer price;
    private ProviderDTO provider;


}
