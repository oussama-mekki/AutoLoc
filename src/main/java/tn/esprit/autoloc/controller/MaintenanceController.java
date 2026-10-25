package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/maintenances")
@Tag(name = "Maintenance", description = "Gestion des maintenances des véhicules")
public class MaintenanceController {
    private final IMaintenanceService maintenanceService;

    @Operation(summary = "Afficher toutes les maintenances", description = "Retourne la liste de toutes les maintenances")
    @GetMapping("/afficherToutesMaintenances")
    public List<Maintenance> getAllMaintenances() {
        return maintenanceService.afficherToutesMaintenances();
    }

    @Operation(summary = "Afficher une maintenance par id", description = "Retourne la maintenance correspondant à l'identifiant")
    @GetMapping("/afficherMaintenanceById/{id}")
    public Maintenance getMaintenanceById(@PathVariable Long id) {
        return maintenanceService.afficherMaintenanceById(id);
    }

    @Operation(summary = "Ajouter une maintenance", description = "Crée une nouvelle maintenance")
    @PostMapping("/ajouterMaintenance")
    public Maintenance ajouterMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.ajouterMaintenance(maintenance);
    }

    @Operation(summary = "Modifier une maintenance", description = "Met à jour une maintenance existante (idMaintenance requis)")
    @PutMapping("/modifierMaintenance")
    public Maintenance modifierMaintenance(@RequestBody Maintenance maintenance) {
        return maintenanceService.modifierMaintenance(maintenance);
    }

    @Operation(summary = "Supprimer une maintenance", description = "Supprime la maintenance à partir de son identifiant")
    @DeleteMapping("/supprimerMaintenance/{idMaintenance}")
    public void supprimerMaintenance(@PathVariable Long idMaintenance) {
        maintenanceService.supprimerMaintenance(idMaintenance);
    }
}
