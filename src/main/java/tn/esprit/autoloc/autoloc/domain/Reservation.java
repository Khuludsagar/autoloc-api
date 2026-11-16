package tn.esprit.autoloc.autoloc.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idReservation;
    LocalDate dateDebut;
    LocalDate dateFin;
    @Enumerated(EnumType.STRING)
    StatutReservation statut;

    // Plusieurs réservations pour un client
    @ManyToOne
    Client client;

    // Plusieurs réservations pour un véhicule
    @ManyToOne
    Vehicule vehicule;

    // Une réservation donne lieu à un seul contrat
    @OneToOne(mappedBy = "reservation")
    @JsonIgnore
    Contrat contrat;
}
