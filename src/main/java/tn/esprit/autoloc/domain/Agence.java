package tn.esprit.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Agence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idAgence;
    String nom;
    String ville;
    String adresse;
    String telephone;


    @JsonIgnore
    @OneToMany(mappedBy = "agence")
    List<Employe> employes = new ArrayList<>();

    @JsonIgnoreProperties("agence")
    @OneToMany(mappedBy = "agence", cascade = CascadeType.PERSIST)
    List<Vehicule> vehicules = new ArrayList<>();
}
