package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employes")
@Tag(name = "Employe", description = "Gestion des employés des agences")
public class EmployeController {
    private final IEmployeService employeService;

    @Operation(summary = "Afficher tous les employés", description = "Retourne la liste de tous les employés")
    @GetMapping("/afficherToutesEmployes")
    public List<Employe> getAllEmployes() {
        return employeService.afficherToutesEmployes();
    }

    @Operation(summary = "Afficher un employé par id", description = "Retourne l'employé correspondant à l'identifiant")
    @GetMapping("/afficherEmployeById/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.afficherEmployeById(id);
    }

    @Operation(summary = "Ajouter un employé", description = "Crée un nouvel employé")
    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @Operation(summary = "Modifier un employé", description = "Met à jour un employé existant (idEmploye requis)")
    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @Operation(summary = "Supprimer un employé", description = "Supprime l'employé à partir de son identifiant")
    @DeleteMapping("/supprimerEmploye/{idEmploye}")
    public void supprimerEmploye(@PathVariable Long idEmploye) {
        employeService.supprimerEmploye(idEmploye);
    }

    @Operation(summary = "Désaffecter un employé de son agence")
    @PutMapping("/desaffecterEmploye/{idEmploye}")
    public Employe desaffecterEmploye(@PathVariable Long idEmploye) {
        return employeService.desaffecterEmploye(idEmploye);
    }

    @Operation(summary = "Affecter un employé à une agence")
    @PutMapping("/affecterEmploye/{idEmploye}/{idAgence}")
    public Employe affecterEmploye(@PathVariable Long idEmploye, @PathVariable Long idAgence) {
        return employeService.affecterEmploye(idEmploye, idAgence);
    }
}
