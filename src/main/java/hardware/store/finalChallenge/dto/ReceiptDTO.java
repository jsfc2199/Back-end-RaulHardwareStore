package hardware.store.finalChallenge.dto;

import hardware.store.finalChallenge.collection.Product;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class ReceiptDTO {
    private String id = UUID.randomUUID().toString();
    private String providerName;
    private List<Product> productsReceived;
    private LocalDate date;
}
