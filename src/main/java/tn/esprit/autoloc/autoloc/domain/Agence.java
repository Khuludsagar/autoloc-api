package tn.esprit.autoloc.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    // Une agence possède plusieurs véhicules
    // WRITE_ONLY : accepté en entrée (ajout agence + véhicules), non renvoyé en sortie (évite la boucle JSON)
    @OneToMany(mappedBy = "agence")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    List<Vehicule> vehicules;

    // Une agence emploie plusieurs employés
    @OneToMany(mappedBy = "agence")
    @JsonIgnore
    List<Employe> employes;
}
