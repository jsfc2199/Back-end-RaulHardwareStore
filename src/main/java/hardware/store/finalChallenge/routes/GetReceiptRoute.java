package hardware.store.finalChallenge.routes;

import hardware.store.finalChallenge.dto.ReceiptDTO;
import hardware.store.finalChallenge.usecases.GetReceiptUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetReceiptRoute {
    @Bean
    public RouterFunction<ServerResponse> getAllReceipts(GetReceiptUseCase getReceiptUseCase){
        return route(GET("/v1/api/all-receipts"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getReceiptUseCase.getReceipts(), ReceiptDTO.class)));
    }
}
