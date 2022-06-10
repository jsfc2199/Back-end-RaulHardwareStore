package hardware.store.finalChallenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderDTO {
    private String id;
    private String name;
    private String number;
    private String passport;
}
