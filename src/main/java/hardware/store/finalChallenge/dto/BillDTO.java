package hardware.store.finalChallenge.dto;

import hardware.store.finalChallenge.collection.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillDTO {
    private String id;
    private String clientName;
    private String seller;
    private String date;
    private List<Product> productsBought;
    private Double totalPaid;
}
