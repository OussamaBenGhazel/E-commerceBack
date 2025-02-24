package tn.esprit.fournisseur;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fournisseur")
public class fournisseurcontrolleur {



private final fournisseurservice fs;



    public fournisseurcontrolleur(fournisseurservice fs) {
        this.fs = fs;
    }

    @GetMapping("/all")
    public ResponseEntity<List<fournisseur>> listfournisseur(){
        return new ResponseEntity<>(fs.findAll(), HttpStatus.OK);
    }




    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<fournisseur> createLivrable(@RequestBody fournisseur livrable) {
        return new ResponseEntity<>(fs.ajouterfournisseur(livrable), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<fournisseur> updateLivrable(@PathVariable(value = "id") long id,
                                                   @RequestBody fournisseur livrable){
        return new ResponseEntity<>(fs.updatefournisseur(id, livrable),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteLivarble(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(fs.deletefournisseur(id), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public fournisseur findById(@PathVariable Long id){
        return fs.findById(id);
    }



}
