package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/contrats")
@Tag(name = "Contrat", description = "Gestion des contrats de location")
public class ContratController {
    private final IContratService contratService;

    @Operation(summary = "Afficher tous les contrats", description = "Retourne la liste de tous les contrats")
    @GetMapping("/afficherToutesContrats")
    public List<Contrat> getAllContrats() {
        return contratService.afficherToutesContrats();
    }

    @Operation(summary = "Afficher un contrat par id", description = "Retourne le contrat correspondant à l'identifiant")
    @GetMapping("/afficherContratById/{id}")
    public Contrat getContratById(@PathVariable Long id) {
        return contratService.afficherContratById(id);
    }

    @Operation(summary = "Ajouter un contrat", description = "Crée un nouveau contrat")
    @PostMapping("/ajouterContrat")
    public Contrat ajouterContrat(@RequestBody Contrat contrat) {
        return contratService.ajouterContrat(contrat);
    }

    @Operation(summary = "Modifier un contrat", description = "Met à jour un contrat existant (idContrat requis)")
    @PutMapping("/modifierContrat")
    public Contrat modifierContrat(@RequestBody Contrat contrat) {
        return contratService.modifierContrat(contrat);
    }

    @Operation(summary = "Supprimer un contrat", description = "Supprime le contrat à partir de son identifiant")
    @DeleteMapping("/supprimerContrat/{idContrat}")
    public void supprimerContrat(@PathVariable Long idContrat) {
        contratService.supprimerContrat(idContrat);
    }
}
