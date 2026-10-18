package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiements")
public class PaiementController {
    private final IPaiementService paiementService;

    @GetMapping("/afficherToutesPaiements")
    public List<Paiement> getAllPaiements() {
        return paiementService.afficherToutesPaiements();
    }

    @GetMapping("/afficherPaiementById/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.afficherPaiementById(id);
    }

    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @DeleteMapping("/supprimerPaiement/{idPaiement}")
    public void supprimerPaiement(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }
}
