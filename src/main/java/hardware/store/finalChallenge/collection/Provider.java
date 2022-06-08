package hardware.store.finalChallenge.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Data
@Document(collection = "provider")
public class Provider {
    @Id
    private String id = UUID.randomUUID().toString();
    private String name;
    private String number;
    private String streetAdress;
}
