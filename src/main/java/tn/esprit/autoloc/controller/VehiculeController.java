package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/vehicules")
@Tag(name = "Vehicule", description = "Gestion des véhicules")
public class VehiculeController {
    private final IVehiculeService vehiculeService;

    @Operation(summary = "Afficher tous les véhicules", description = "Retourne la liste de tous les véhicules")
    @GetMapping("/afficherToutesVehicules")
    public List<Vehicule> getAllVehicules() {
        return vehiculeService.afficherToutesVehicules();
    }

    @Operation(summary = "Afficher un véhicule par id", description = "Retourne le véhicule correspondant à l'identifiant")
    @GetMapping("/afficherVehiculeById/{id}")
    public Vehicule getVehiculeById(@PathVariable Long id) {
        return vehiculeService.afficherVehiculeById(id);
    }

    @Operation(summary = "Ajouter un véhicule", description = "Crée un nouveau véhicule")
    @PostMapping("/ajouterVehicule")
    public Vehicule ajouterVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.ajouterVehicule(vehicule);
    }

    @Operation(summary = "Modifier un véhicule", description = "Met à jour un véhicule existant (idVehicule requis)")
    @PutMapping("/modifierVehicule")
    public Vehicule modifierVehicule(@RequestBody Vehicule vehicule) {
        return vehiculeService.modifierVehicule(vehicule);
    }

    @Operation(summary = "Supprimer un véhicule", description = "Supprime le véhicule à partir de son identifiant")
    @DeleteMapping("/supprimerVehicule/{idVehicule}")
    public void supprimerVehicule(@PathVariable Long idVehicule) {
        vehiculeService.supprimerVehicule(idVehicule);
    }
}
