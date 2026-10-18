package tn.esprit.autoloc.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/employes")
public class EmployeController {
    private final IEmployeService employeService;

    @GetMapping("/afficherToutesEmployes")
    public List<Employe> getAllEmployes() {
        return employeService.afficherToutesEmployes();
    }

    @GetMapping("/afficherEmployeById/{id}")
    public Employe getEmployeById(@PathVariable Long id) {
        return employeService.afficherEmployeById(id);
    }

    @PostMapping("/ajouterEmploye")
    public Employe ajouterEmploye(@RequestBody Employe employe) {
        return employeService.ajouterEmploye(employe);
    }

    @PutMapping("/modifierEmploye")
    public Employe modifierEmploye(@RequestBody Employe employe) {
        return employeService.modifierEmploye(employe);
    }

    @DeleteMapping("/supprimerEmploye/{idEmploye}")
    public void supprimerEmploye(@PathVariable Long idEmploye) {
        employeService.supprimerEmploye(idEmploye);
    }
}
