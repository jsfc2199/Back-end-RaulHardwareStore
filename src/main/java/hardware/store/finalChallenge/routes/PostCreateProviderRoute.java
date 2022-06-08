package hardware.store.finalChallenge.routes;

import hardware.store.finalChallenge.dto.ProviderDTO;
import hardware.store.finalChallenge.usecases.PostCreateProviderUseCase;
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
public class PostCreateProviderRoute {
    @Bean
    public RouterFunction<ServerResponse> createProvider(PostCreateProviderUseCase postCreateProviderUseCase){
        return route(POST("/v1/api/saveProvider").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProviderDTO.class)
                        .flatMap(postCreateProviderUseCase::createProvider)
                        .flatMap(providerDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(providerDTO)));
    }
}
