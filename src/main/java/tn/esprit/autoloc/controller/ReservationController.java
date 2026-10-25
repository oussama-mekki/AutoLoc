package tn.esprit.autoloc.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.autoloc.domain.Reservation;
import tn.esprit.autoloc.service.IReservationService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/reservations")
@Tag(name = "Reservation", description = "Gestion des réservations")
public class ReservationController {
    private final IReservationService reservationService;

    @Operation(summary = "Afficher toutes les réservations", description = "Retourne la liste de toutes les réservations")
    @GetMapping("/afficherToutesReservations")
    public List<Reservation> getAllReservations() {
        return reservationService.afficherToutesReservations();
    }

    @Operation(summary = "Afficher une réservation par id", description = "Retourne la réservation correspondant à l'identifiant")
    @GetMapping("/afficherReservationById/{id}")
    public Reservation getReservationById(@PathVariable Long id) {
        return reservationService.afficherReservationById(id);
    }

    @Operation(summary = "Ajouter une réservation", description = "Crée une nouvelle réservation")
    @PostMapping("/ajouterReservation")
    public Reservation ajouterReservation(@RequestBody Reservation reservation) {
        return reservationService.ajouterReservation(reservation);
    }

    @Operation(summary = "Modifier une réservation", description = "Met à jour une réservation existante (idReservation requis)")
    @PutMapping("/modifierReservation")
    public Reservation modifierReservation(@RequestBody Reservation reservation) {
        return reservationService.modifierReservation(reservation);
    }

    @Operation(summary = "Supprimer une réservation", description = "Supprime la réservation à partir de son identifiant")
    @DeleteMapping("/supprimerReservation/{idReservation}")
    public void supprimerReservation(@PathVariable Long idReservation) {
        reservationService.supprimerReservation(idReservation);
    }
}
