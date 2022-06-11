package hardware.store.finalChallenge.routes;

import hardware.store.finalChallenge.dto.BillDTO;
import hardware.store.finalChallenge.usecases.PostCreateBillUseCase;
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
public class PostCreateBillRoute {
    @Bean
    public RouterFunction<ServerResponse> createBill(PostCreateBillUseCase postCreateBillUseCase){
        return route(POST("/v1/api/save-bill").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(BillDTO.class)
                        .flatMap(postCreateBillUseCase::createBill)
                        .flatMap(billDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(billDTO)));
    }
}
