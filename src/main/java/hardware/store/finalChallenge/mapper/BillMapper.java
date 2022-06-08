package hardware.store.finalChallenge.mapper;

import hardware.store.finalChallenge.collection.Bill;
import hardware.store.finalChallenge.dto.BillDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class BillMapper {

    private final ModelMapper modelMapper;

    public BillMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public BillDTO fromBillToBillDTO(Bill bill){
        return modelMapper.map(bill, BillDTO.class);
    }

    public Bill fromDTOtoBill(BillDTO billDTO){
        return modelMapper.map(billDTO, Bill.class);
    }
}
