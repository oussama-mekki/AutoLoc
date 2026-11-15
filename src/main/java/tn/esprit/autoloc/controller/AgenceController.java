package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/agences")
@Tag(name = "Agence", description = "Gestion des agences de location")
public class AgenceController {
    private final IAgenceService agenceService;

    @Operation(summary = "Afficher toutes les agences", description = "Retourne la liste de toutes les agences")
    @GetMapping("/afficherToutesAgences")
    public List<Agence> getAllAgences() {
        return agenceService.afficherToutesAgences();

    }
    @Operation(summary = "Afficher une agence par id", description = "Retourne l'agence correspondant à l'identifiant")
    @GetMapping("/afficherAgenceById/{id}")
    public Agence getAgenceById(@PathVariable Long id) {
        return agenceService.afficherAgenceById(id);

    }
    @Operation(summary = "Ajouter une agence", description = "Crée une nouvelle agence")
    @PostMapping("/ajouterAgence")
    public Agence ajouterAgence(@RequestBody Agence agence) {
        return agenceService.ajouterAgence(agence);
    }
    @Operation(summary = "Modifier une agence", description = "Met à jour une agence existante (idAgence requis)")
    @PutMapping("/modifierAgence")
    public Agence modifierAgence(@RequestBody Agence agence) {
        return agenceService.modifierAgence(agence);
    }
    @Operation(summary = "Supprimer une agence", description = "Supprime l'agence à partir de son identifiant")
    @DeleteMapping("/supprimerAgence/{idAgence}")
    public void supprimerAgence(@PathVariable Long idAgence) {
        agenceService.supprimerAgence(idAgence);
    }

    @Operation(summary = "Ajouter une agence avec ses véhicules")
    @PostMapping("/ajouterAgenceEtAffecterVehicules")
    public Agence ajouterAgenceEtAffecterVehicules(@RequestBody Agence agence) {
        return agenceService.ajouterAgenceEtAffecterVehicules(agence);
    }
}