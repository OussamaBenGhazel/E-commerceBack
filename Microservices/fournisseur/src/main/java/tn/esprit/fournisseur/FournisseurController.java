package tn.esprit.fournisseur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true") // Autorise CORS sur cette API
public class FournisseurController {

    @Autowired
    private fournisseurservice fournisseurService;

    // Endpoint pour ajouter un fournisseur
    @PostMapping("/ajouter")
    public ResponseEntity<fournisseur> ajouterFournisseur(@RequestBody fournisseur f) {
        fournisseur addedFournisseur = fournisseurService.ajouterfournisseur(f);
        return new ResponseEntity<>(addedFournisseur, HttpStatus.CREATED);
    }

    // Endpoint pour obtenir tous les fournisseurs
    @GetMapping("/all")
    public List<fournisseur> getAllFournisseurs() {
        return fournisseurService.findAll();
    }

    // Endpoint pour mettre à jour un fournisseur par ID
    @PutMapping("/update/{id}")
    public ResponseEntity<fournisseur> updateFournisseur(@PathVariable long id, @RequestBody fournisseur newFournisseur) {
        fournisseur updatedFournisseur = fournisseurService.updatefournisseur(id, newFournisseur);
        if (updatedFournisseur != null) {
            return new ResponseEntity<>(updatedFournisseur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un fournisseur par ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFournisseur(@PathVariable long id) {
        String result = fournisseurService.deletefournisseur(id);
        if ("fournisseur supprimé".equals(result)) {
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour récupérer un fournisseur par ID
    @GetMapping("/{id}")
    public ResponseEntity<fournisseur> getFournisseurById(@PathVariable Long id) {
        fournisseur f = fournisseurService.findById(id);
        if (f != null) {
            return new ResponseEntity<>(f, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
