package tn.esprit.autoloc.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idVehicule;
    String immatriculation;
    String marque;
    String modele;
    @Enumerated(EnumType.STRING)
    CategorieVehicule categorie;
    BigDecimal tarifJournalier;
    @Enumerated(EnumType.STRING)
    StatutVehicule statut;

    // Plusieurs véhicules appartiennent à une agence
    @ManyToOne
    Agence agence;

    // Un véhicule possède plusieurs équipements et un équipement équipe plusieurs véhicules
    @ManyToMany
    @JoinTable(name = "vehicule_equipement",
            joinColumns = @JoinColumn(name = "vehicule_id"),
            inverseJoinColumns = @JoinColumn(name = "equipement_id"))
    Set<Equipement> equipements;

    // Un véhicule fait l'objet de plusieurs réservations
    @OneToMany(mappedBy = "vehicule")
    @JsonIgnore
    List<Reservation> reservations;

    // Un véhicule subit plusieurs maintenances
    @OneToMany(mappedBy = "vehicule")
    @JsonIgnore
    List<Maintenance> maintenances;
}
