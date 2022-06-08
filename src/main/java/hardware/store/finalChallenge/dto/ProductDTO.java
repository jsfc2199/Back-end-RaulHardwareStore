package hardware.store.finalChallenge.dto;

import hardware.store.finalChallenge.collection.Provider;
import lombok.Data;

import java.util.UUID;

@Data
public class ProductDTO {
    private String id = UUID.randomUUID().toString();
    private Integer minUnits;
    private Integer maxUnits;
    private String productName;
    private String description;
    private String unitsAvailable;
    private Integer price;
    private Provider provider;
}
