package hardware.store.finalChallenge.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "receipt")
public class Receipt {
    @Id
    private String id;
    private String providerName;
    private List<Product> productsReceived;
    private LocalDate date;
}
