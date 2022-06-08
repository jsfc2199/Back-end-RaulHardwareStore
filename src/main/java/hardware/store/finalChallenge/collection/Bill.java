package hardware.store.finalChallenge.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "bill")
public class Bill {
    @Id
    private String id;
    private LocalDate date;
    private String clientName;
    private String seller;
    private List<Product> productsBought;
    private Double totalPaid;
}
