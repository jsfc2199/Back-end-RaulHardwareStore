package hardware.store.finalChallenge.dto;

import hardware.store.finalChallenge.collection.Product;
import hardware.store.finalChallenge.collection.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceiptDTO {
    private String id;
    private String description;
    private Integer units;
    private String productId;
    private String date;
    private Provider provider;
}
