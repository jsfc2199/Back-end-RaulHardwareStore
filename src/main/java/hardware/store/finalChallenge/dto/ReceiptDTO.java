package hardware.store.finalChallenge.dto;

import hardware.store.finalChallenge.collection.Product;
import hardware.store.finalChallenge.collection.Provider;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ReceiptDTO {
    private String id;
    private String description;
    private Integer units;
    private String productId;
    private LocalDate date;
    private Provider provider;
}
