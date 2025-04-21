package esprit.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                // Microservice Produit
                .route("produit", r -> r.path("/produit/**", "/panier/**")
                        .uri("lb://produit"))

                // Microservice Commande
                .route("commande", r -> r.path("/commande/**", "/factures/**")
                        .uri("lb://commande"))  // Notez le nom en minuscules pour correspondre à la config

                // Microservice Fournisseur
                .route("fournisseur", r -> r.path("/fournisseur/**")
                        .uri("lb://fournisseur"))

                // Microservice Reclamation
                .route("reclamation", r -> r.path("/Rec/reclamation/**")
                        .uri("lb://reclamation"))
                // Microservice Notification
                .route("notification", r -> r.path("/notifications/**")
                        .uri("lb://notification-service"))
                // Microservice-User
                .route("Microservice-User", r -> r.path("/api/v1/")
                        .uri("lb://Microservice-User"))
                // Logistics
                .route("Logistics", r -> r.path("/Logistics")
                        .uri("lb://Logistics"))

                .build();
    }
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.addExposedHeader("Authorization"); // Si vous utilisez JWT

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return new CorsWebFilter(source);
    }
}