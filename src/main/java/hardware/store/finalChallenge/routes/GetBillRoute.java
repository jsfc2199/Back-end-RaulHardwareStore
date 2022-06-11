package hardware.store.finalChallenge.routes;

import hardware.store.finalChallenge.dto.BillDTO;
import hardware.store.finalChallenge.usecases.GetBillUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetBillRoute {
    @Bean
    public RouterFunction<ServerResponse> allBills(GetBillUseCase getBillUseCase){
        return route(GET("/v1/api/all-bills"),request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getBillUseCase.getBills(), BillDTO.class)));
    }
}
