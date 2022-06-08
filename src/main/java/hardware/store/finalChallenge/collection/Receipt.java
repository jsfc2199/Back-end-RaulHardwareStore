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
@Document(collection = "receipt")
public class Receipt {
    @Id
    private String id;
    private String description;
    private Integer units;
    private String productId;
    private LocalDate date;
    private Provider provider;
}
