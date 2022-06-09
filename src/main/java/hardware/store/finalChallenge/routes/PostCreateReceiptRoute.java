package hardware.store.finalChallenge.routes;

import hardware.store.finalChallenge.dto.ReceiptDTO;
import hardware.store.finalChallenge.usecases.PostCreateReceiptUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PostCreateReceiptRoute {
    @Bean
    public RouterFunction<ServerResponse> createReceipt(PostCreateReceiptUseCase postCreateReceiptUseCase){
        return route(POST("/v1/api/save-receipt").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDTO.class)
                        .flatMap(postCreateReceiptUseCase::createReceipt)
                        .flatMap(receiptDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(receiptDTO)));
    }
}
