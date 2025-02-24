package tn.esprit.fournisseur;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class fournisseurservice {
    private final fournisseurrepos fr;


    public fournisseurservice(fournisseurrepos fr){

        this.fr=fr;
    }




    public fournisseur ajouterfournisseur(fournisseur f) {
        return fr.save(f);
    }


    public List<fournisseur> findAll() {
        return fr.findAll();
    }


    public fournisseur updatefournisseur(long id, fournisseur newfournisseur) {
        if (fr.findById(id).isPresent()) {
            fournisseur f = fr.findById(id).get();
            f.setNom(newfournisseur.getNom());



            return fr.save(f);
        } else
            return null;
    }


    public String deletefournisseur
            (long id) {
        if (fr.findById(id).isPresent()) {
            fr.deleteById(id);
            return "fournisseur supprimé";
        } else
            return "fournisseur non supprimé";
    }






    public fournisseur findById(Long id){
        return fr.findById(id).get();
    }

}

