//package tn.esprit.produit.config;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**") // Autorise toutes les routes
//                .allowedOrigins("http://localhost:4200") // URL de votre frontend Angular
//                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Méthodes HTTP autorisées
//                .allowedHeaders("*") // Autorise tous les en-têtes
//                .allowCredentials(true); // Autorise les cookies/authentification
//    }
//}