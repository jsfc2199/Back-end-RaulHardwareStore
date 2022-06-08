package hardware.store.finalChallenge.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ProviderDTO {
    private String id = UUID.randomUUID().toString();
    private String name;
    private String number;
    private String streetAdress;
}
