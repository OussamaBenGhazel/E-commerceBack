package tn.esprit.Microservice_User.config;

import org.keycloak.OAuth2Constants;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KeycloakConfig {

    private static Keycloak keycloak = null;

    private final static String serverUrl = "http://localhost:8080";
    private final static String realm = "JobBoardKeycloack";
    private final static String clientId = "candidat-service";
    private final static String clientSecret = "AIzjKpj05KMQHUkrSC2dX0VwSlnh4O4E";
    private final static String username = "jihed";
    private final static String password = "jihed";

    public KeycloakConfig() {}

    @Bean
    public static Keycloak keycloakInstance() {
        if (keycloak == null) {
            keycloak = KeycloakBuilder.builder()
                    .serverUrl(serverUrl)
                    .realm(realm)
                    .grantType(OAuth2Constants.PASSWORD)
                    .clientId(clientId)
                    .clientSecret(clientSecret)
                    .username(username)
                    .password(password)
                    .build();
        }
        return keycloak;
    }
}
