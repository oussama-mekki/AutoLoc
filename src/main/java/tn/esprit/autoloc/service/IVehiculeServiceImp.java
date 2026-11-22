package tn.esprit.autoloc.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.EquipementRepository;
import tn.esprit.autoloc.repository.VehiculeRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class IVehiculeServiceImp implements IVehiculeService {
    private final VehiculeRepository vehiculeRepository;

    @Override
    public Vehicule ajouterVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule modifierVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public List<Vehicule> afficherToutesVehicules() {
        return vehiculeRepository.findAll();
    }

    @Override
    public Vehicule afficherVehiculeById(Long id) {
        return vehiculeRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerVehicule(Long id) {
        vehiculeRepository.deleteById(id);
    }

    private final EquipementRepository equipementRepository;

    @Override
    @Transactional
    public Vehicule affecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));
        Equipement equipement = equipementRepository.findById(idEquipement)
                .orElseThrow(() -> new EntityNotFoundException("Équipement introuvable : " + idEquipement));
        if (!vehicule.getEquipements().contains(equipement)) {
            vehicule.getEquipements().add(equipement);
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    @Transactional
    public Vehicule desaffecterEquipement(Long idVehicule, Long idEquipement) {
        Vehicule vehicule = vehiculeRepository.findById(idVehicule)
                .orElseThrow(() -> new EntityNotFoundException("Véhicule introuvable : " + idVehicule));
        vehicule.getEquipements().removeIf(e -> e.getIdEquipement().equals(idEquipement));
        return vehiculeRepository.save(vehicule);
    }

    private static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Scheduled(initialDelay = 5, fixedRate = 60, timeUnit = TimeUnit.SECONDS)
    public void actualiserEtatVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        System.out.println("\n=================== Q1 : actualisation des véhicules ===================");
        System.out.println("Nombre total de véhicules : " + vehicules.size());
        System.out.println("Date et heure de l'actualisation : " + LocalDateTime.now().format(FORMAT_DATE));
    }


    @Scheduled(cron = "0 0 9 ? * MON")
    public void genererRapportVehicules() {
        List<Vehicule> vehicules = vehiculeRepository.findAll();
        int total = vehicules.size();
        System.out.println("\n=================== Q3 : rapport hebdomadaire des véhicules ===================");
        System.out.println("Nombre total de véhicules : " + total);
        System.out.println("Date et heure de génération : " + LocalDateTime.now().format(FORMAT_DATE));
    }
}