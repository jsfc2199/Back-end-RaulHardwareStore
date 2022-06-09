package hardware.store.finalChallenge.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "bill")
public class Bill {
    @Id
    private String id;
    private String clientName;
    private String seller;
    private String date;
    private List<Product> productsBought;
    private Double totalPaid;
}
