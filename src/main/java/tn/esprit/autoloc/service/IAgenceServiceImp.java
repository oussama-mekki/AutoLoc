package tn.esprit.autoloc.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.AgenceRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class IAgenceServiceImp  implements IAgenceService{
    /*@Autowired
    private AgenceRepository agenceRepository;*/
    private final AgenceRepository agenceRepository;

    @Override
    public Agence ajouterAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence modifierAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public List<Agence> afficherToutesAgences() {
        return agenceRepository.findAll();
    }


    @Override
    public Agence afficherAgenceById(Long id) {
        return agenceRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerAgence(Long id) {
        agenceRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Agence ajouterAgenceEtAffecterVehicules(Agence agence) {
        for (Vehicule vehicule : agence.getVehicules()) {
            vehicule.setAgence(agence);
        }
        return agenceRepository.save(agence);
    }

    private static final DateTimeFormatter FORMAT_DATE = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    @Scheduled(fixedDelay = 2, timeUnit = TimeUnit.MINUTES)
    public void suivreNombreAgences() {
        List<Agence> agences = agenceRepository.findAll();
        System.out.println("\n=================== Q2 : suivi des agences ===================");
        System.out.println("Nombre total d'agences enregistrées : " + agences.size());
        System.out.println("Date et heure de la vérification : " + LocalDateTime.now().format(FORMAT_DATE));
    }
}