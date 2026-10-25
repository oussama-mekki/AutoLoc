package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/paiements")
@Tag(name = "Paiement", description = "Gestion des paiements des contrats")
public class PaiementController {
    private final IPaiementService paiementService;

    @Operation(summary = "Afficher tous les paiements", description = "Retourne la liste de tous les paiements")
    @GetMapping("/afficherToutesPaiements")
    public List<Paiement> getAllPaiements() {
        return paiementService.afficherToutesPaiements();
    }

    @Operation(summary = "Afficher un paiement par id", description = "Retourne le paiement correspondant à l'identifiant")
    @GetMapping("/afficherPaiementById/{id}")
    public Paiement getPaiementById(@PathVariable Long id) {
        return paiementService.afficherPaiementById(id);
    }

    @Operation(summary = "Ajouter un paiement", description = "Crée un nouveau paiement")
    @PostMapping("/ajouterPaiement")
    public Paiement ajouterPaiement(@RequestBody Paiement paiement) {
        return paiementService.ajouterPaiement(paiement);
    }

    @Operation(summary = "Modifier un paiement", description = "Met à jour un paiement existant (idPaiement requis)")
    @PutMapping("/modifierPaiement")
    public Paiement modifierPaiement(@RequestBody Paiement paiement) {
        return paiementService.modifierPaiement(paiement);
    }

    @Operation(summary = "Supprimer un paiement", description = "Supprime le paiement à partir de son identifiant")
    @DeleteMapping("/supprimerPaiement/{idPaiement}")
    public void supprimerPaiement(@PathVariable Long idPaiement) {
        paiementService.supprimerPaiement(idPaiement);
    }
}
