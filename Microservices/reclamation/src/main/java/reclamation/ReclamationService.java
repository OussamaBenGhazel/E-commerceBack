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
    private RestTemplate restTemplate;

    private static final String MAILING_SERVICE_URL = "http://localhost:8084/mail/sendReclamationConfirmation";

    public List<Reclamation> getAllReclamations() {
        return reclamationRepository.findAll();
    }

    public Optional<Reclamation> getReclamationById(int id) {
        return reclamationRepository.findById(id);
    }

    @Autowired
    private EmailService emailService;

    public Reclamation createReclamation(Reclamation reclamation) {
        Reclamation savedReclamation = reclamationRepository.save(reclamation);

        try {
            // Appel du service de mailing local via Mailtrap
            emailService.sendReclamationConfirmation(reclamation.getEmail(), reclamation.getDescription());

            // Si tu veux aussi appeler un autre microservice (existant), garde cette ligne :
            // restTemplate.postForObject(MAILING_SERVICE_URL, savedReclamation, String.class);
        } catch (Exception e) {
            System.out.println("Erreur lors de l’envoi d’email : " + e.getMessage());
        }

        return savedReclamation;
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

    public void deleteReclamation(int id) {
        reclamationRepository.deleteById(id);
    }
}
