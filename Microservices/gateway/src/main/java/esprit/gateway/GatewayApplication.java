package esprit.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("candidat", r -> r.path("/candidats/**")
                        .uri("lb://candidat"))


//  microservice   produit
                .route("Produit", r -> r.path("/produit/**")
                        .uri("lb://Produit"))

                .route("Produit", r -> r.path("/panier/**")
                        .uri("lb://Produit"))


                //  microservice   produit


                .route("Microservice-User", r -> r.path("/notifications/**")
                        .uri("lb://Microservice-User"))


               // micro commande
                .route("Commande-service", r -> r.path("/commandes/**")
                        .uri("lb://Commande-service"))


               //  micro notification

                .route("notification-service", r -> r.path("/notifications/**")
                        .uri("lb://notification-service"))

                //  microservice reclamation



                .route("reclamation", r -> r.path("/reclamation/**")
                        .uri("lb://reclamation"))


                .route("notification", r -> r.path("/notifications/**")
                        .uri("lb://notification-service"))

                .route("notification", r -> r.path("/notifications/**")
                        .uri("lb://notification-service"))
                .build();
    }


}
