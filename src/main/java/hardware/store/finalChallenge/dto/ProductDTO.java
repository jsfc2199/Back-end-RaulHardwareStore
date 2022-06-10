package hardware.store.finalChallenge.dto;

import hardware.store.finalChallenge.collection.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private String id;
    private Integer minUnits;
    private Integer maxUnits;
    private String productName;
    private String description;
    private Integer unitsAvailable;
    private Integer price;
    private ProviderDTO provider;
}
