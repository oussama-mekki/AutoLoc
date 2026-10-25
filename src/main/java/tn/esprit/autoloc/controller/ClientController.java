package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/clients")
@Tag(name = "Client", description = "Gestion des clients")
public class ClientController {
    private final IClientService clientService;

    @Operation(summary = "Afficher tous les clients", description = "Retourne la liste de tous les clients")
    @GetMapping("/afficherToutesClients")
    public List<Client> getAllClients() {
        return clientService.afficherToutesClients();
    }

    @Operation(summary = "Afficher un client par id", description = "Retourne le client correspondant à l'identifiant")
    @GetMapping("/afficherClientById/{id}")
    public Client getClientById(@PathVariable Long id) {
        return clientService.afficherClientById(id);
    }

    @Operation(summary = "Ajouter un client", description = "Crée un nouveau client")
    @PostMapping("/ajouterClient")
    public Client ajouterClient(@RequestBody Client client) {
        return clientService.ajouterClient(client);
    }

    @Operation(summary = "Modifier un client", description = "Met à jour un client existant (idClient requis)")
    @PutMapping("/modifierClient")
    public Client modifierClient(@RequestBody Client client) {
        return clientService.modifierClient(client);
    }

    @Operation(summary = "Supprimer un client", description = "Supprime le client à partir de son identifiant")
    @DeleteMapping("/supprimerClient/{idClient}")
    public void supprimerClient(@PathVariable Long idClient) {
        clientService.supprimerClient(idClient);
    }
}
