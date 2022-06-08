package hardware.store.finalChallenge.routes;

import hardware.store.finalChallenge.dto.ProductDTO;
import hardware.store.finalChallenge.usecases.GetProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProductRoute {
    @Bean
    public RouterFunction<ServerResponse> allProducts(GetProductUseCase getProductUseCase){
        return route(GET("/v1/api/all"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getProductUseCase.getProducts(), ProductDTO.class)));
    }
}
