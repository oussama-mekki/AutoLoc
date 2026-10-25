package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/equipements")
@Tag(name = "Equipement", description = "Gestion des équipements des véhicules")
public class EquipementController {
    private final IEquipementService equipementService;

    @Operation(summary = "Afficher tous les équipements", description = "Retourne la liste de tous les équipements")
    @GetMapping("/afficherToutesEquipements")
    public List<Equipement> getAllEquipements() {
        return equipementService.afficherToutesEquipements();
    }

    @Operation(summary = "Afficher un équipement par id", description = "Retourne l'équipement correspondant à l'identifiant")
    @GetMapping("/afficherEquipementById/{id}")
    public Equipement getEquipementById(@PathVariable Long id) {
        return equipementService.afficherEquipementById(id);
    }

    @Operation(summary = "Ajouter un équipement", description = "Crée un nouvel équipement")
    @PostMapping("/ajouterEquipement")
    public Equipement ajouterEquipement(@RequestBody Equipement equipement) {
        return equipementService.ajouterEquipement(equipement);
    }

    @Operation(summary = "Modifier un équipement", description = "Met à jour un équipement existant (idEquipement requis)")
    @PutMapping("/modifierEquipement")
    public Equipement modifierEquipement(@RequestBody Equipement equipement) {
        return equipementService.modifierEquipement(equipement);
    }

    @Operation(summary = "Supprimer un équipement", description = "Supprime l'équipement à partir de son identifiant")
    @DeleteMapping("/supprimerEquipement/{idEquipement}")
    public void supprimerEquipement(@PathVariable Long idEquipement) {
        equipementService.supprimerEquipement(idEquipement);
    }
}
