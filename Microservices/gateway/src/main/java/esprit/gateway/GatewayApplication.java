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


                .route("commande-service", r -> r.path("/commande/**")  // Toutes les requêtes commençant par /commande
                        .uri("lb://Commande-service")  // Utilisation du load balancing pour l'URI avec Eureka
                )



                //  microservice reclamation



                .route("reclamation", r -> r.path("/reclamation/**")
                        .uri("lb://reclamation"))


                .route("notification", r -> r.path("/notifications/**")
                        .uri("lb://notification-service"))

                .build();
    }


}
