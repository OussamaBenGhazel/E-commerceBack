package reclamation;
import reclamation.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import org.springframework.web.client.RestTemplate;

@Service

public class ReclamationService {
    @Autowired
    private ReclamationRepository reclamationRepository;
    @Autowired
    private RestTemplate restTemplate;  // Vérifie que l'injection fonctionne icitilisé pour envoyer des requêtes HTTP
    private static final String MAILING_SERVICE_URL = "http://localhost:8084/mail/sendReclamationConfirmation";

    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    public Optional<Reclamation> getReclamationById(int id) {
        return reclamationRepository.findById(id);
    }

    // Méthode pour gérer la création d'une réclamation
    public Reclamation createReclamation(Reclamation reclamation) {
        // Envoie la requête pour envoyer un email
        String emailServiceUrl = "http://localhost:8084/mail/sendReclamationConfirmation";
        restTemplate.postForObject(emailServiceUrl, reclamation, String.class);
        return reclamation; // retourne la réclamation après traitement

    }

    public void sendEmail(String email) {
        String url = "http://localhost:8084/mail/sendReclamationConfirmation";  // L'URL du service de mailing
        // Logique pour envoyer une requête HTTP via RestTemplate
    }

    public Reclamation updateReclamation(int id, Reclamation newReclamation) {
        return reclamationRepository.findById(id)
                .map(reclamation -> {
                    reclamation.setDescription(newReclamation.getDescription());
                    reclamation.setEmail(newReclamation.getEmail());
                    reclamation.setType(newReclamation.getType());
                    reclamation.setEtat(newReclamation.getEtat());
                    return reclamationRepository.save(reclamation);
                })
                .orElseThrow(() -> new RuntimeException("Réclamation introuvable !"));
    }

    // 🔹 Supprimer une réclamation
    public void deleteReclamation(int id) {
        reclamationRepository.deleteById(id);
    }
}
