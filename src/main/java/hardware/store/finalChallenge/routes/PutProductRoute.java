package hardware.store.finalChallenge.routes;

import hardware.store.finalChallenge.dto.ProductDTO;
import hardware.store.finalChallenge.usecases.PutProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutProductRoute {
    @Bean
    public RouterFunction<ServerResponse> updateProduct(PutProductUseCase putProductUseCase){
        return route(PUT("/v1/api/update-product").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(putProductUseCase::updateProduct)
                        .flatMap(productDTO -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDTO)));
    }
}
