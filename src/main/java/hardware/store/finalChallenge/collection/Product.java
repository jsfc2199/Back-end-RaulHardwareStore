package hardware.store.finalChallenge.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Provider provider;


}
