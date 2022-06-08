package hardware.store.finalChallenge.dto;

import hardware.store.finalChallenge.collection.Product;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
public class BillDTO {
    private String id = UUID.randomUUID().toString();
    private LocalDate date;
    private String clientName;
    private String seller;
    private List<Product> productsBought;
    private Double totalPaid;
}
