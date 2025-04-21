package reclamation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reclamation")
public class ReclamationRestApi {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private ReclamationService reclamationService;
    @Autowired
    public ReclamationRestApi(ReclamationService reclamationService) {
        this.reclamationService = reclamationService;
    }
    // 🔹 Récupérer toutes les réclamations
    @GetMapping
    public List<Reclamation> getAllReclamations() {
        return reclamationService.getAllReclamations();
    }

    // 🔹 Récupérer une réclamation par ID
    @GetMapping("/{id}")
    public Optional<Reclamation> getReclamationById(@PathVariable int id) {
        return reclamationService.getReclamationById(id);
    }

    // 🔹 Ajouter une réclamation
    @PostMapping
    public Reclamation createReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.createReclamation(reclamation);
    }

    // 🔹 Modifier une réclamation
    @PutMapping("/{id}")
    public Reclamation updateReclamation(@PathVariable int id, @RequestBody Reclamation reclamation) {
        return reclamationService.updateReclamation(id, reclamation);
    }

    // 🔹 Supprimer une réclamation
    @DeleteMapping("/{id}")
    public void deleteReclamation(@PathVariable int id) {
        reclamationService.deleteReclamation(id);
    }
}
